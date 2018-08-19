package com.bootdo.statsensation.dao;

import com.bootdo.statsensation.domain.SensationDetailDO;
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
public interface SensationDetailDao {

	SensationDetailDO get(Long id);
	
	List<SensationDetailDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SensationDetailDO sensationDetail);
	
	int update(SensationDetailDO sensationDetail);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	Map<String, Object> getSensation(Map<String, String> map);
}
