package com.bootdo.ywms.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.ywms.domain.YwmsOrderDO;
import com.bootdo.ywms.domain.YwmsnumDO;
import com.bootdo.ywms.service.YwmsOrderService;
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
 * @date 2018-07-12 14:41:17
 */
 
@Controller
@RequestMapping("/ywms/ywmsOrder")
public class YwmsOrderController {
	@Autowired
	private YwmsOrderService ywmsOrderService;
	
	@GetMapping()
	@RequiresPermissions("ywms:ywmsOrder:ywmsOrder")
	String YwmsOrder(){
	    return "ywms/ywmsOrder/ywmsOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("ywms:ywmsOrder:ywmsOrder")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YwmsOrderDO> ywmsOrderList = ywmsOrderService.list(query);
		int total = ywmsOrderService.count(query);
		PageUtils pageUtils = new PageUtils(ywmsOrderList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/list1")
	@RequiresPermissions("ywms:ywmsOrder:ywmsOrder")
	public YwmsnumDO list1(@RequestParam Map<String, Object> params){
		//查询列表数据
		YwmsnumDO a = ywmsOrderService.num(params);

		return a;
	}



	@GetMapping("/Recharge")
	@RequiresPermissions("ywms:ywmsOrder:Recharge")
	String Recharge(){
		return "ywms/ywmsOrder/recharge";
	}

	/**
	 * 后台充值缘币
	 */
	@ResponseBody
	@PostMapping("/recharge")
	public R recharge( YwmsOrderDO ywmsOrder){
		if(ywmsOrderService.recharge(ywmsOrder)>0){
			return R.ok();
		}
		return R.error();
	}


	@GetMapping("/add")
	@RequiresPermissions("ywms:ywmsOrder:add")
	String add(){
	    return "ywms/ywmsOrder/add";
	}

	@GetMapping("/edit/{orderid}")
	@RequiresPermissions("ywms:ywmsOrder:edit")
	String edit(@PathVariable("orderid") Integer orderid,Model model){
		YwmsOrderDO ywmsOrder = ywmsOrderService.get(orderid);
		model.addAttribute("ywmsOrder", ywmsOrder);
	    return "ywms/ywmsOrder/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("ywms:ywmsOrder:add")
	public R save( YwmsOrderDO ywmsOrder){
		if(ywmsOrderService.save(ywmsOrder)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("ywms:ywmsOrder:edit")
	public R update( YwmsOrderDO ywmsOrder){
		ywmsOrderService.update(ywmsOrder);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsOrder:remove")
	public R remove( Integer orderid){
		if(ywmsOrderService.remove(orderid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("ywms:ywmsOrder:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] orderids){
		ywmsOrderService.batchRemove(orderids);
		return R.ok();
	}
	
}
