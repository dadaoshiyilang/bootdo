package com.bootdo.ywms.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.ywms.domain.YwmsOrderDO;
import com.bootdo.ywms.domain.YwmsnumDO;
import com.bootdo.ywms.service.YwmsOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-12 14:41:17
 */
 
@Controller
@RequestMapping("/ywms/ywmsYun")
public class YwmsYunRecordController {
	@Autowired
	private YwmsOrderService ywmsOrderService;
	
	@GetMapping()
	@RequiresPermissions("ywms:ywmsYun:ywmsOrder")
	String YwmsOrder(){
	    return "ywms/ywmsYun/ywmsOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ywms:ywmsYun:ywmsOrder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YwmsOrderDO> ywmsOrderList = ywmsOrderService.listyun(query);
		int total = ywmsOrderService.countyun(query);
		PageUtils pageUtils = new PageUtils(ywmsOrderList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/list1")
	@RequiresPermissions("ywms:ywmsYun:ywmsOrder")
	public YwmsnumDO list1(@RequestParam Map<String, Object> params){
		//查询列表数据
		YwmsnumDO a = ywmsOrderService.numYun(params);
		System.out.print("111");
		return a;
	}





	
}
