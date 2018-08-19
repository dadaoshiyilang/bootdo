package com.bootdo.ywms.dao;

import com.bootdo.ywms.domain.YwmsUserDO;
import com.bootdo.ywms.domain.YwmsYbDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-05 15:03:23
 */
@Mapper
public interface YwmsYbDao {

	List<YwmsYbDO> list(Map<String,Object> map);


	List<YwmsYbDO> list2(Map<String,Object> map);


	int insertRecord(YwmsUserDO ywmsUser);
}
