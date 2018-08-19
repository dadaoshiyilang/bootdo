package com.bootdo.review.controller;

import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootdo.review.domain.NewsDO;
import com.bootdo.review.service.NewsService;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.utils.CommonConfig;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * @author lz
 * @date 2018-07-04 13:44:49
 */
 
@Controller
@RequestMapping("/review/news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	@GetMapping()
	@RequiresPermissions("review:news:news")
	String News(){
	    return "review/news/news";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("review:news:news")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<NewsDO> newsList = newsService.list(query);
		int total = newsService.count(query);
		PageUtils pageUtils = new PageUtils(newsList, total);
		return pageUtils;
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("review:news:remove")
	public R remove( Integer newsid){
		if(newsService.remove(newsid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 查看
	 */
	@GetMapping("/preview/{newsid}")
	@RequiresPermissions("review:news:preview")
	String edit(@PathVariable("newsid") Integer newsid,Model model){
		String rtn = "";
		NewsDO dto = newsService.get(newsid);
		if (dto != null && "1".equals(dto.getDatatype())) {// 图片
			List<NewsDO> newslist = newsService.getNewsINfo(newsid);
			String aliUrl = CommonConfig.OSS_URL;//阿里云前缀地址
			for (NewsDO news : newslist) {
				news.setDataurl(aliUrl + "/" + news.getDataurl());
			}
			model.addAttribute("list", newslist);
			model.addAttribute("portraiturl", aliUrl + "/"+dto.getPortraiturl());			
			return "review/news/photoEdit";
		} else {
			List<NewsDO> newslist = newsService.getNewsINfo(newsid);
			String aliUrl = CommonConfig.OSS_URL;//阿里云前缀地址
			model.addAttribute("vedioUrl", aliUrl + "/" + newslist.get(0).getDataurl());			
			return "review/news/vedioEdit";
		}
	}
}
