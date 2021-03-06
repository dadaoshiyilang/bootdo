package com.bootdo.ywms.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.ywms.domain.YwmsUserWithdrawalDO;
import com.bootdo.ywms.service.YwmsUserWithdrawalService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ffff
 * @email 1992lcg@163.com
 * @date 2018-07-16 14:03:50
 */
 
@Controller
@RequestMapping("/ywms/ywmsUserWithdrawal")
public class YwmsUserWithdrawalController {
	@Autowired
	private YwmsUserWithdrawalService ywmsUserWithdrawalService;
	
	@GetMapping()
	@RequiresPermissions("ywms:ywmsUserWithdrawal:ywmsUserWithdrawal")
	String YwmsUserWithdrawal(){
	    return "ywms/ywmsUserWithdrawal/ywmsUserWithdrawal";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ywms:ywmsUserWithdrawal:ywmsUserWithdrawal")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YwmsUserWithdrawalDO> ywmsUserWithdrawalList = ywmsUserWithdrawalService.list(query);
		int total = ywmsUserWithdrawalService.count(query);
		PageUtils pageUtils = new PageUtils(ywmsUserWithdrawalList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ywms:ywmsUserWithdrawal:add")
	String add(){
	    return "ywms/ywmsUserWithdrawal/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ywms:ywmsUserWithdrawal:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		YwmsUserWithdrawalDO ywmsUserWithdrawal = ywmsUserWithdrawalService.get(id);
		model.addAttribute("ywmsUserWithdrawal", ywmsUserWithdrawal);
	    return "ywms/ywmsUserWithdrawal/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ywms:ywmsUserWithdrawal:add")
	public R save( YwmsUserWithdrawalDO ywmsUserWithdrawal){
		if(ywmsUserWithdrawalService.save(ywmsUserWithdrawal)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ywms:ywmsUserWithdrawal:edit")
	public R update( YwmsUserWithdrawalDO ywmsUserWithdrawal){
		ywmsUserWithdrawalService.update(ywmsUserWithdrawal);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsUserWithdrawal:remove")
	public R remove( Integer id){
		if(ywmsUserWithdrawalService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsUserWithdrawal:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		ywmsUserWithdrawalService.batchRemove(ids);
		return R.ok();
	}


	/**
	 * 不通过提现请求
	 */
	@PostMapping( "/no")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsUserWithdrawal:no")
	public R no( Integer id){
		if(ywmsUserWithdrawalService.no(id)>0){
			return R.ok();
		}
		return R.error();
	}


	/**
	 * 通过提现请求
	 */
	@PostMapping( "/yes")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsUserWithdrawal:yes")
	public R yes(Integer id){
		Map<String, Object> yes =   ywmsUserWithdrawalService.yes(id);
		if(yes.get("result").equals("1")){
			return R.ok(String.valueOf(yes.get("msg")));
		}
		return R.error(String.valueOf(yes.get("msg")));
	}


}
