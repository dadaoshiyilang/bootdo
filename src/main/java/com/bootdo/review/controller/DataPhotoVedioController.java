package com.bootdo.review.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.review.domain.DataPhotoVedioDO;
import com.bootdo.review.domain.NewsDO;
import com.bootdo.review.service.DataPhotoVedioService;
import com.bootdo.review.service.NewsService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author lz
 * @email 1992lcg@163.com
 * @date 2018-07-05 15:08:05
 */
 
@Controller
@RequestMapping("/review/dataPhotoVedio")
public class DataPhotoVedioController {
	@Autowired
	private DataPhotoVedioService dataPhotoVedioService;
	
	@Autowired
	private NewsService newsService; 
	
	@GetMapping()
	@RequiresPermissions("review:dataPhotoVedio:dataPhotoVedio")
	String DataPhotoVedio(){
	    return "review/dataPhotoVedio/dataPhotoVedio";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("review:dataPhotoVedio:dataPhotoVedio")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DataPhotoVedioDO> dataPhotoVedioList = dataPhotoVedioService.list(query);
		int total = dataPhotoVedioService.count(query);
		PageUtils pageUtils = new PageUtils(dataPhotoVedioList, total);
		return pageUtils;
	}
	

	@GetMapping("/edit/{did}")
	@RequiresPermissions("review:dataPhotoVedio:edit")
	String edit(@PathVariable("did") Integer did,Model model){
		DataPhotoVedioDO dataPhotoVedio = dataPhotoVedioService.get(did);
		model.addAttribute("dataPhotoVedio", dataPhotoVedio);
	    return "review/dataPhotoVedio/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("review:dataPhotoVedio:add")
	public R save( DataPhotoVedioDO dataPhotoVedio){
		if(dataPhotoVedioService.save(dataPhotoVedio)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("review:dataPhotoVedio:edit")
	public R update( DataPhotoVedioDO dataPhotoVedio){
		dataPhotoVedioService.update(dataPhotoVedio);
		return R.ok();
	}
	
	/**
	 * 单个图片删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("review:dataPhotoVedio:remove")
	public R remove(Integer did){
		if(dataPhotoVedioService.remove(did)>0){
			DataPhotoVedioDO dto = dataPhotoVedioService.get(did);
			NewsDO newsDto = new NewsDO();
			newsDto.setNewsid(dto.getNewsid());
			newsService.updateNews(newsDto);
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 审核操作
	 */
	@PostMapping( "/batchPass")
	@ResponseBody
	@RequiresPermissions("review:dataPhotoVedio:pass")
	public R pass(@RequestParam("ids[]") Integer[] dids, @RequestParam("status") String status,
			@RequestParam("reason") String reason){
		dataPhotoVedioService.batchPass(dids, status, reason);
		return R.ok();
	}
}
