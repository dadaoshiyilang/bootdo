package com.bootdo.ywms.service.impl;



import com.bootdo.ywms.dao.YwmsYbDao;
import com.bootdo.ywms.domain.YwmsUserDO;
import com.bootdo.ywms.domain.YwmsYbDO;
import com.bootdo.ywms.service.YwmsYbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class YwmsYbServiceImpl implements YwmsYbService{
	@Autowired
	private YwmsYbDao ywmsYbDao;


	@Override
	public List<YwmsYbDO> list(Map<String, Object> map) {
		return ywmsYbDao.list(map);
	}


	@Override
	public List<YwmsYbDO> list2(Map<String, Object> map) {
		return ywmsYbDao.list2(map);
	}

	@Override
	public int insertRecord(YwmsUserDO ywmsUser) {
		return ywmsYbDao.insertRecord(ywmsUser);
	}


}
