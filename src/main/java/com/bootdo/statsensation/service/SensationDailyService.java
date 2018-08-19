package com.bootdo.statsensation.service;

import com.bootdo.statsensation.domain.SensationDailyDO;
import com.bootdo.ywms.domain.YwmsUserDO;

import java.util.List;
import java.util.Map;

/**
 * 网红公司网红收益跑批信息表
 * 
 * @author lz
 * @email 1992lcg@163.com
 * @date 2018-07-18 15:37:08
 */
public interface SensationDailyService {
	
	SensationDailyDO get(Long id);
	
	List<SensationDailyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SensationDailyDO sensationDaily, YwmsUserDO userDO);
	
	int update(SensationDailyDO sensationDaily);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	Map<String, Object> getSensation(Map<String, String> map);
}
