package com.bootdo.statsensation.dao;

import com.bootdo.statsensation.domain.SensationDailyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 网红公司网红收益跑批信息表
 * @author lz
 * @email 1992lcg@163.com
 * @date 2018-07-18 15:37:08
 */
@Mapper
public interface SensationDailyDao {

	SensationDailyDO get(Long id);
	
	List<SensationDailyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SensationDailyDO sensationDaily);
	
	int update(SensationDailyDO sensationDaily);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	Map<String, Object> getSensation(Map<String, String> map);
}
