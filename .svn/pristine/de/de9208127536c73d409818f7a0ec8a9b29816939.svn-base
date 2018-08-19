package com.bootdo.system.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.PayInfoDO;
import com.bootdo.system.service.PayInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 支付管理表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-26 15:09:27
 */
 
@Controller
@RequestMapping("/system/payInfo")
public class PayInfoController {
	@Autowired
	private PayInfoService payInfoService;
	
	@GetMapping()
	@RequiresPermissions("system:payInfo:payInfo")
	String PayInfo(){
	    return "system/payInfo/payInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:payInfo:payInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PayInfoDO> payInfoList = payInfoService.list(query);
		int total = payInfoService.count(query);
		PageUtils pageUtils = new PageUtils(payInfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:payInfo:add")
	String add(){
	    return "system/payInfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:payInfo:edit")
	String edit(@PathVariable("id") Long id,Model model){
		PayInfoDO payInfo = payInfoService.get(id);
		model.addAttribute("payInfo", payInfo);
	    return "system/payInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:payInfo:add")
	public R save( PayInfoDO payInfo){
		if(payInfoService.save(payInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:payInfo:edit")
	public R update( PayInfoDO payInfo){
		payInfoService.update(payInfo);
		return R.ok();
	}

	/**
	 * 冻结用户
	 */
	@PostMapping( "/freeze")
	@ResponseBody
	@RequiresPermissions("system:payInfo:freeze")
	public R freeze(PayInfoDO payInfo){
		if(payInfoService.editfreeze(payInfo)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 启用用户
	 */
	@PostMapping( "/thaw")
	@ResponseBody
	@RequiresPermissions("system:payInfo:thaw")
	public R thaw(PayInfoDO payInfo){
		int a = payInfoService.editthaw(payInfo);
		if(a>0){
			return R.ok();
		}else if (a==-1){
			return R.error("请先停用同类型支付的其他公司支付方式");
		}else{
			return R.error();
		}

	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:payInfo:remove")
	public R remove( Long id){
		if(payInfoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:payInfo:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		payInfoService.batchRemove(ids);
		return R.ok();
	}
	
}
