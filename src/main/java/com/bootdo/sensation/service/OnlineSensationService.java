package com.bootdo.sensation.service;

import com.bootdo.sensation.domain.OnlineSensationDO;

import java.util.List;
import java.util.Map;

/**
 * 网红公司信息表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-18 10:52:52
 */
public interface OnlineSensationService {
	
	OnlineSensationDO get(Long id);
	
	OnlineSensationDO getSensation(String whid);
	
	List<OnlineSensationDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OnlineSensationDO onlineSensation);
	
	int update(OnlineSensationDO onlineSensation);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
