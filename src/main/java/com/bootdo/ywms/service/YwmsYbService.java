package com.bootdo.ywms.service;

import com.bootdo.ywms.domain.YwmsUserDO;
import com.bootdo.ywms.domain.YwmsYbDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-05 15:03:23
 */
public interface YwmsYbService {
	

	//缘豆流水
	List<YwmsYbDO> list(Map<String, Object> map);

	//缘币流水
	List<YwmsYbDO> list2(Map<String, Object> map);


	//插入管理缘修改缘币记录
	int insertRecord(YwmsUserDO ywmsUser);
}
