package com.bootdo.ywms.dao;

import com.bootdo.ywms.domain.YwmsJiguanginfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-23 10:02:23
 */
@Mapper
public interface YwmsJiguanginfoDao {

	YwmsJiguanginfoDO get(Long id);
	
	List<YwmsJiguanginfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(YwmsJiguanginfoDO ywmsJiguanginfo);
	
	int update(YwmsJiguanginfoDO ywmsJiguanginfo);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	int insertinfo(YwmsJiguanginfoDO ywmsJiguanginfo);

	int addunreadsysinfobybatch(List<YwmsJiguanginfoDO> jg);

	int addunreadsysinfo(String userid);

	int insertinfoByBatch(List<YwmsJiguanginfoDO> jg);

}
