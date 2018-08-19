package com.bootdo.ywms.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.ywms.domain.YwmsJiguanginfoDO;
import com.bootdo.ywms.service.YwmsJiguanginfoService;
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
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-23 10:02:23
 */
 
@Controller
@RequestMapping("/ywms/ywmsJiguanginfo")
public class YwmsJiguanginfoController {
	@Autowired
	private YwmsJiguanginfoService ywmsJiguanginfoService;
	
	@GetMapping()
	@RequiresPermissions("ywms:ywmsJiguanginfo:ywmsJiguanginfo")
	String YwmsJiguanginfo(){
	    return "ywms/ywmsJiguanginfo/ywmsJiguanginfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ywms:ywmsJiguanginfo:ywmsJiguanginfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YwmsJiguanginfoDO> ywmsJiguanginfoList = ywmsJiguanginfoService.list(query);
		int total = ywmsJiguanginfoService.count(query);
		PageUtils pageUtils = new PageUtils(ywmsJiguanginfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ywms:ywmsJiguanginfo:add")
	String add(){
	    return "ywms/ywmsJiguanginfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ywms:ywmsJiguanginfo:edit")
	String edit(@PathVariable("id") Long id,Model model){
		YwmsJiguanginfoDO ywmsJiguanginfo = ywmsJiguanginfoService.get(id);
		model.addAttribute("ywmsJiguanginfo", ywmsJiguanginfo);
	    return "ywms/ywmsJiguanginfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ywms:ywmsJiguanginfo:add")
	public R save( YwmsJiguanginfoDO ywmsJiguanginfo){
		if(ywmsJiguanginfoService.save(ywmsJiguanginfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ywms:ywmsJiguanginfo:edit")
	public R update( YwmsJiguanginfoDO ywmsJiguanginfo){
		ywmsJiguanginfoService.update(ywmsJiguanginfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsJiguanginfo:remove")
	public R remove( Long id){
		if(ywmsJiguanginfoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsJiguanginfo:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		ywmsJiguanginfoService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * 推送系统消息(公告)
	 * @return
	 */
	@GetMapping("/pushInfo")
	@RequiresPermissions("ywms:ywmsJiguanginfo:pushInfo")
	String Recharge(){
		return "ywms/ywmsJiguanginfo/pushInfo";
	}




	/**
	 * 推送
	 */
	@ResponseBody
	@PostMapping("/push")
	public R push(@RequestParam Map<String, Object> params){
		if(ywmsJiguanginfoService.push(params)>0) {
			return R.ok();
		}
		return R.error();
	}


}
