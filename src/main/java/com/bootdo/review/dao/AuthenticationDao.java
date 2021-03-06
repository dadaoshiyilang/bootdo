package com.bootdo.review.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.bootdo.review.domain.AuthenticationDO;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-12 14:17:28
 */
@Mapper
public interface AuthenticationDao {

	AuthenticationDO get(Long id);
	
	List<AuthenticationDO> list(Map<String,Object> map);
	
	List<AuthenticationDO> Detaillist(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int detailcount(Map<String,Object> map);
	
	int save(AuthenticationDO authentication);
	
	int update(AuthenticationDO authentication);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	
	int batchPass(@Param(value = "users") Long[] users, @Param(value = "status") String status, @Param(value = "userstatus") String userstatus);
}
