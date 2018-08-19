package com.bootdo.banner.controller;

import com.bootdo.banner.domain.AdvertisePictureDO;
import com.bootdo.banner.service.AdvertisePictureService;
import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 首页轮播图表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-19 10:56:38
 */
 
@Controller
@RequestMapping("/banner/advertisePicture")
public class AdvertisePictureController extends BaseController {
	@Autowired
	private AdvertisePictureService advertisePictureService;
	
	@GetMapping()
	@RequiresPermissions("banner:advertisePicture:advertisePicture")
	String AdvertisePicture(){
	    return "banner/advertisePicture/advertisePicture";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("banner:advertisePicture:advertisePicture")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AdvertisePictureDO> advertisePictureList = advertisePictureService.list(query);
		/*for (AdvertisePictureDO adverDo : advertisePictureList) {
			adverDo.setPicDepositUrl("bannerImage"+"/"+adverDo.getPicDepositUrl());
		}*/
		int total = advertisePictureService.count(query);
		PageUtils pageUtils = new PageUtils(advertisePictureList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("banner:advertisePicture:add")
	String add(){
	    return "banner/advertisePicture/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("banner:advertisePicture:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		AdvertisePictureDO advertisePicture = advertisePictureService.get(id);
		model.addAttribute("advertisePicture", advertisePicture);
	    return "banner/advertisePicture/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("banner:advertisePicture:add")
	public R save(AdvertisePictureDO advertisePicture, @RequestParam(value ="avatar_file",required = false) MultipartFile fileField){
		if(advertisePictureService.save(advertisePicture, fileField, getUserId())){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("banner:advertisePicture:edit")
	public R update( AdvertisePictureDO advertisePicture){
		advertisePictureService.update(advertisePicture, getUserId());
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("banner:advertisePicture:remove")
	public R remove( Integer id){
		if(advertisePictureService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@PostMapping( "/onlineup")
	@ResponseBody
	@RequiresPermissions("banner:advertisePicture:onlineup")
	public R remove(@RequestParam("ids[]") Integer[] ids, @RequestParam("status") String status){
		advertisePictureService.batchOnline(ids, status);
		return R.ok();
	}
	
}
