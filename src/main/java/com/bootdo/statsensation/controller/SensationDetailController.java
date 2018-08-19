package com.bootdo.statsensation.controller;

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
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.statsensation.domain.SensationDetailDO;
import com.bootdo.statsensation.service.SensationDetailService;
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
@RequestMapping("/statsensation/sensationDetail")
public class SensationDetailController extends BaseController{
	@Autowired
	private SensationDetailService sensationDetailService;
	
	@Autowired
	private YwmsUserService ywmsUserService;
	
	@GetMapping()
	@RequiresPermissions("statsensation:sensationDetail:sensationDetail")
	String SensationDaily(@ModelAttribute("whid") String whid, Model model){
		model.addAttribute("whid", whid);
	    return "statsensation/sensationDetail/sensationDetail";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("statsensation:sensationDetail:sensationDetail")
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
		List<SensationDetailDO> sensationDailyList = sensationDetailService.list(query);
		int total = sensationDetailService.count(query);
		PageUtils pageUtils = new PageUtils(sensationDailyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{whid}")
	@RequiresPermissions("statsensation:sensationDetail:add")
	String add(@PathVariable("whid") String whid, Model model){
		model.addAttribute("whid", whid);
	    return "statsensation/sensationDetail/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("statsensation:sensationDetail:edit")
	String edit(@PathVariable("id") Long id,Model model){
		SensationDetailDO sensationDetail = sensationDetailService.get(id);
		model.addAttribute("sensationDetail", sensationDetail);
	    return "statsensation/sensationDaily/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("statsensation:sensationDetail:add")
	public R save( SensationDetailDO sensationDetail){
		YwmsUserDO userDO = ywmsUserService.getUserByYyid(sensationDetail.getYyid());
		if (userDO == null) {
			return R.error("用户眼缘Id不存在，请确认...");
		}
		if ("3".equals(userDO.getAdminaffirm()) || "1".equals(userDO.getWhcooperation())) {// 判断是否加入过网红公司
			return R.error("该用户已绑定网红公司，请确认...");
		}
		if(sensationDetailService.save(sensationDetail, userDO)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("statsensation:sensationDetail:edit")
	public R update( SensationDetailDO sensationDetail){
		sensationDetailService.update(sensationDetail);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Long id){
		if(sensationDetailService.remove(id)>0){
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
		sensationDetailService.batchRemove(ids);
		return R.ok();
	}
	
	/**
	 * 得到网红的收益情况
	 */
	@GetMapping( "/getwhuserInfo")
	@ResponseBody
	public R getAmount(String inputValue, String whid, String yyid, String flag) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("createTime", inputValue);
		reqMap.put("yyid", yyid);
		reqMap.put("whid", whid);
		resultMap = sensationDetailService.getSensation(reqMap);
		resultMap.put("flag", StringUtils.isNotEmpty(flag)?Integer.parseInt(flag):Integer.parseInt("0"));
		return R.ok(resultMap);
	}
}
