package com.bootdo.ywms.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.ywms.domain.YwmsUserWithdrawalDO;
import com.bootdo.ywms.domain.YwmswithdrawnumDO;
import com.bootdo.ywms.service.YwmsUserWithdrawalService;
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
 * 提现记录明细
 * @author ffff
 * @email 1992lcg@163.com
 * @date 2018-07-16 14:03:50
 */
 
@Controller
@RequestMapping("/ywms/ywmsWithdrawalRecord")
public class YwmsWithdrawalRecordController {
	@Autowired
	private YwmsUserWithdrawalService ywmsUserWithdrawalService;
	
	@GetMapping()
	@RequiresPermissions("ywms:ywmsWithdrawalRecord:ywmsWithdrawalRecord")
	String YwmsUserWithdrawal(){
	    return "ywms/ywmsWithdrawalRecord/ywmsWithdrawalRecord";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ywms:ywmsWithdrawalRecord:ywmsWithdrawalRecord")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YwmsUserWithdrawalDO> ywmsUserWithdrawalList = ywmsUserWithdrawalService.listrecord(query);
		int total = ywmsUserWithdrawalService.countrecord(query);
		PageUtils pageUtils = new PageUtils(ywmsUserWithdrawalList, total);
		return pageUtils;
	}


	@ResponseBody
	@GetMapping("/list1")
	@RequiresPermissions("ywms:ywmsYun:ywmsOrder")
	public YwmswithdrawnumDO list1(@RequestParam Map<String, Object> params){
		//查询列表数据
		YwmswithdrawnumDO a = ywmsUserWithdrawalService.num(params);

		return a;
	}





}
