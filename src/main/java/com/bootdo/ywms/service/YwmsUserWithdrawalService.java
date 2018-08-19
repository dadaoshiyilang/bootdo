package com.bootdo.ywms.service;

import com.bootdo.ywms.domain.YwmsUserWithdrawalDO;
import com.bootdo.ywms.domain.YwmswithdrawnumDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ffff
 * @email 1992lcg@163.com
 * @date 2018-07-16 14:03:50
 */
public interface YwmsUserWithdrawalService {
	
	YwmsUserWithdrawalDO get(Integer id);

	//统计网页中的每日
	YwmswithdrawnumDO num(Map<String, Object> map);


	//提现审核
	List<YwmsUserWithdrawalDO> list(Map<String, Object> map);

	//提现记录
	List<YwmsUserWithdrawalDO> listrecord(Map<String, Object> map);

	int count(Map<String, Object> map);


	int countrecord(Map<String, Object> map);
	int save(YwmsUserWithdrawalDO ywmsUserWithdrawal);
	
	int update(YwmsUserWithdrawalDO ywmsUserWithdrawal);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	int no(Integer id);


	Map<String, Object> yes(Integer id);
}
