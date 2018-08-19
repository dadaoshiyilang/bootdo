package com.bootdo.ywms.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.ywms.domain.YwmsPresentListDO;
import com.bootdo.ywms.service.YwmsPresentListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

import static com.bootdo.common.utils.ShiroUtils.getUserId;

/**
 * 
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-25 18:13:49
 */
 
@Controller
@RequestMapping("/ywms/ywmsPresentList")
public class YwmsPresentListController {
	@Autowired
	private YwmsPresentListService ywmsPresentListService;
	
	@GetMapping()
	@RequiresPermissions("ywms:ywmsPresentList:ywmsPresentList")
	String YwmsPresentList(){
	    return "ywms/ywmsPresentList/ywmsPresentList";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ywms:ywmsPresentList:ywmsPresentList")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YwmsPresentListDO> ywmsPresentListList = ywmsPresentListService.list(query);
		int total = ywmsPresentListService.count(query);
		PageUtils pageUtils = new PageUtils(ywmsPresentListList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("ywms:ywmsPresentList:add")
	String add(){
	    return "ywms/ywmsPresentList/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("ywms:ywmsPresentList:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		YwmsPresentListDO ywmsPresentList = ywmsPresentListService.get(id);
		model.addAttribute("ywmsPresentList", ywmsPresentList);
	    return "ywms/ywmsPresentList/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ywms:ywmsPresentList:add")
	public R save(YwmsPresentListDO ywmsPresentList, @RequestParam(value ="avatar_file",required = false) MultipartFile fileField){
		if(ywmsPresentListService.save(ywmsPresentList,fileField, getUserId())>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ywms:ywmsPresentList:edit")
	public R update( YwmsPresentListDO ywmsPresentList){
		ywmsPresentListService.update(ywmsPresentList,getUserId());
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsPresentList:remove")
	public R remove( Integer id){
		if(ywmsPresentListService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsPresentList:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		ywmsPresentListService.batchRemove(ids);
		return R.ok();
	}


	/**
	 * 修改
	 */
	@PostMapping( "/onlineup")
	@ResponseBody
	@RequiresPermissions("banner:advertisePicture:onlineup")
	public R remove(@RequestParam("ids[]") Integer[] ids, @RequestParam("status") String status){
		ywmsPresentListService.batchOnline(ids, status);
		return R.ok();
	}

}
