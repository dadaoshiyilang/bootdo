package com.bootdo.review.service;

import com.bootdo.review.domain.AuthenticationDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-12 14:17:28
 */
public interface AuthenticationService {
	
	AuthenticationDO get(Long id);
	
	List<AuthenticationDO> list(Map<String, Object> map);
	
	List<AuthenticationDO> Detaillist(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int detailcount(Map<String, Object> map);
	
	int save(AuthenticationDO authentication);
	
	int update(AuthenticationDO authentication);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int batchPass(Long[] users, String status, String userstatus);
}
