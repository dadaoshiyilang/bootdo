package com.bootdo.ywms.service;

import com.bootdo.ywms.domain.YwmsOrderDO;
import com.bootdo.ywms.domain.YwmsnumDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-12 14:41:17
 */
public interface YwmsOrderService {
	
	YwmsOrderDO get(Integer orderid);
	
	List<YwmsOrderDO> list(Map<String, Object> map);

	YwmsnumDO num(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(YwmsOrderDO ywmsOrder);

	int recharge(YwmsOrderDO ywmsOrder);


	int update(YwmsOrderDO ywmsOrder);
	
	int remove(Integer orderid);
	
	int batchRemove(Integer[] orderids);

	//云支付的
	List<YwmsOrderDO> listyun(Map<String, Object> map);
	//云支付的
	int countyun(Map<String, Object> map);

	//统计网页中的每日
	YwmsnumDO numYun(Map<String, Object> map);
}