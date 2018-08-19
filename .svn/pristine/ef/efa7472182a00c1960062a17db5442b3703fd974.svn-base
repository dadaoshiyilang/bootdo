package com.bootdo.ywms.dao;

import com.bootdo.ywms.domain.YwmsPresentListDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-25 18:13:49
 */
@Mapper
public interface YwmsPresentListDao {

	YwmsPresentListDO get(Integer id);
	
	List<YwmsPresentListDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(YwmsPresentListDO ywmsPresentList);
	
	int update(YwmsPresentListDO ywmsPresentList);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	int batchOnline(@Param(value = "ids") Integer[] ids, @Param(value = "status") String status);
}
