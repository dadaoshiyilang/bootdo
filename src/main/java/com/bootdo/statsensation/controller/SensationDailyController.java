package com.bootdo.statsensation.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.DateUtils;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.sensation.domain.OnlineSensationDO;
import com.bootdo.sensation.service.OnlineSensationService;
import com.bootdo.statsensation.domain.SensationDailyDO;
import com.bootdo.statsensation.service.SensationDailyService;
import com.bootdo.ywms.domain.YwmsUserDO;
import com.bootdo.ywms.service.YwmsUserService;

/**
 * 网红公司网红收益跑批信息表
 * 
 * @author lz
 * @email 1992lcg@163.com
 * @date 2018-07-18 15:37:08
 */
 
@Controller
@RequestMapping("/statsensation/sensationDaily")
public class SensationDailyController extends BaseController{
	@Autowired
	private SensationDailyService sensationDailyService;
	
	@Autowired
	private YwmsUserService ywmsUserService;
	
	@Autowired
	private OnlineSensationService onlineSensationService;
	
	@GetMapping()
	@RequiresPermissions("statsensation:sensationDaily:sensationDaily")
	String SensationDaily(@ModelAttribute("whid") String whid, Model model){
		model.addAttribute("whid", whid);
	    return "statsensation/sensationDaily/sensationDaily";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("statsensation:sensationDaily:sensationDaily")
	public PageUtils list(@RequestParam Map<String, Object> params){
		if (!"0".equals((String)params.get("flag"))) {
			if (StringUtils.isNotEmpty((String)params.get("createTime"))) {
				String yearMonth = ((String)params.get("createTime")).substring(0, 7);
				String year = ((String)params.get("createTime")).substring(0, 4);
				if ("1".equals((String)params.get("flag"))) {
					params.put("createTime", params.get("createTime"));
				} else if ("2".equals((String)params.get("flag"))) {
					params.put("createTime", yearMonth);
				} else if ("3".equals((String)params.get("flag"))) {
					params.put("createTime", year);
				}
			}			
		}
		
		//查询列表数据
        Query query = new Query(params);
		List<SensationDailyDO> sensationDailyList = sensationDailyService.list(query);
		int total = sensationDailyService.count(query);
		PageUtils pageUtils = new PageUtils(sensationDailyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{whid}")
	@RequiresPermissions("statsensation:sensationDaily:add")
	String add(@PathVariable("whid") String whid, Model model){
		model.addAttribute("whid", whid);
	    return "statsensation/sensationDaily/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("statsensation:sensationDaily:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SensationDailyDO sensationDaily = sensationDailyService.get(id);
		model.addAttribute("sensationDaily", sensationDaily);
	    return "statsensation/sensationDaily/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("statsensation:sensationDaily:add")
	public R save( SensationDailyDO sensationDaily){
		YwmsUserDO userDO = ywmsUserService.getUserByYyid(sensationDaily.getYyid());
		if (userDO == null) {
			return R.error("用户眼缘Id不存在，请确认...");
		}
		if ("3".equals(userDO.getAdminaffirm()) || "1".equals(userDO.getWhcooperation())) {// 判断是否加入过网红公司
			return R.error("该用户已绑定网红公司，请确认...");
		}
		if(sensationDailyService.save(sensationDaily, userDO)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("statsensation:sensationDaily:edit")
	public R update( SensationDailyDO sensationDaily){
		sensationDailyService.update(sensationDaily);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sensationDailyService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("statsensation:sensationDaily:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		sensationDailyService.batchRemove(ids);
		return R.ok();
	}
	
	/**
	 * 得到收益的情况
	 */
	@GetMapping( "/getAmount")
	@ResponseBody
	public R getAmount(String inputValue, String whid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, String> reqMap = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(inputValue)) {
			String yearMonth = inputValue.substring(0, 7);
			String year = inputValue.substring(0, 4);
			reqMap.put("inputValue", inputValue);
			reqMap.put("yearMonth", yearMonth);
			reqMap.put("year", year);
			reqMap.put("whid", whid);
			resultMap = sensationDailyService.getSensation(reqMap);
		}
		return R.ok(resultMap);
	}
	
	@GetMapping("/view/{whid}/{yyid}/{createTime}/{flag}/{userid}")
	@RequiresPermissions("statsensation:sensationDaily:view")
	String view(@PathVariable("whid") String whid, @PathVariable("yyid") String yyid, 
			@PathVariable("createTime") Date createTime, @PathVariable("flag") String flag,
			@PathVariable("userid") String userid, RedirectAttributes attr){
		String dateTime = DateUtils.format(createTime, DateUtils.DATE_SMALL_STR);
		OnlineSensationDO sensationDo = onlineSensationService.getSensation(whid);
		attr.addFlashAttribute("sensationDo", sensationDo);
		attr.addFlashAttribute("dateTime", dateTime);
		attr.addFlashAttribute("yyid", yyid);
		attr.addFlashAttribute("flag", flag);
		attr.addFlashAttribute("userid", userid);
	    return "redirect:/statsensation/sensationDetail";
	}
}
