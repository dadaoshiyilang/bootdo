package com.bootdo.ywms.dao;

import com.bootdo.ywms.domain.YwmsUserDO;
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
public interface YwmsUserDao {

	YwmsUserDO get(Integer userid);

	YwmsUserDO get1(String yyid);

	List<YwmsUserDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(YwmsUserDO ywmsUser);
	
	int update(YwmsUserDO ywmsUser);

	//管理员修改缘豆
	int updaterecharge(YwmsUserDO ywmsUser);


	int remove(Integer userid);

	int editfreeze( YwmsUserDO ywmsUser);

	int batchRemove(Integer[] userids);


	String allwh();
	
	YwmsUserDO getUserByYyid(String yyid);
}
