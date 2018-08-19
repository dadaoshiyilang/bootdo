package com.bootdo.ywms.dao;

import com.bootdo.ywms.domain.YwmsOrderDO;
import com.bootdo.ywms.domain.YwmsnumDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-12 14:41:17
 */
@Mapper
public interface YwmsOrderDao {

	YwmsOrderDO get(Integer orderid);
	
	List<YwmsOrderDO> list(Map<String,Object> map);

	//总充值人数
	YwmsnumDO num1(Map<String, Object> map);

	//当天充值人数
	YwmsnumDO num2(Map<String, Object> map);

	int count(Map<String,Object> map);
	
	int save(YwmsOrderDO ywmsOrder);


	int recharge(YwmsOrderDO ywmsOrder);


	int update(YwmsOrderDO ywmsOrder);
	
	int remove(Integer orderid);
	
	int batchRemove(Integer[] orderids);

	List<YwmsOrderDO> listyun(Map<String,Object> map);
	int countyun(Map<String,Object> map);

	//总充值人数
	YwmsnumDO numYun1(Map<String, Object> map);

	//当天充值人数
	YwmsnumDO numYun2(Map<String, Object> map);
	
	YwmsOrderDO getUserByYyid(String yyid);
}
