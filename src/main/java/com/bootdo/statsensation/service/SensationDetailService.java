package com.bootdo.statsensation.service;

import com.bootdo.statsensation.domain.SensationDetailDO;
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
public interface SensationDetailService {
	
	SensationDetailDO get(Long id);
	
	List<SensationDetailDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SensationDetailDO sensationDetail, YwmsUserDO userDO);
	
	int update(SensationDetailDO sensationDetail);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	Map<String, Object> getSensation(Map<String, String> map);
}
