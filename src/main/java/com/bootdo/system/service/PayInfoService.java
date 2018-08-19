package com.bootdo.system.service;

import com.bootdo.system.domain.PayInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 支付管理表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-26 15:09:27
 */
public interface PayInfoService {
	
	PayInfoDO get(Long id);
	
	List<PayInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PayInfoDO payInfo);
	
	int update(PayInfoDO payInfo);

	int editfreeze(PayInfoDO payInfo);
	int editthaw(PayInfoDO payInfo);

	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
