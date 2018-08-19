package com.bootdo.ywms.service.impl;

import com.bootdo.ywms.dao.YwmsUserDao;
import com.bootdo.ywms.domain.YwmsUserDO;
import com.bootdo.ywms.service.YwmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class YwmsUserServiceImpl implements YwmsUserService {
	@Autowired
	private YwmsUserDao ywmsUserDao;
	
	@Override
	public YwmsUserDO get(Integer userid){
		return ywmsUserDao.get(userid);
	}
	
	@Override
	public List<YwmsUserDO> list(Map<String, Object> map){
		return ywmsUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ywmsUserDao.count(map);
	}
	
	@Override
	public int save(YwmsUserDO ywmsUser){
		return ywmsUserDao.save(ywmsUser);
	}
	
	@Override
	public int update(YwmsUserDO ywmsUser){
		return ywmsUserDao.update(ywmsUser);
	}
	
	@Override
	public int remove(Integer userid){
		return ywmsUserDao.remove(userid);
	}

	@Override
	public int editfreeze( YwmsUserDO ywmsUser){
		if(ywmsUser.getDeleteflag().equals("0")){
			ywmsUser.setDeleteflag("1");
		}else if(ywmsUser.getDeleteflag().equals("1")){
			ywmsUser.setDeleteflag("0");
		}
		return ywmsUserDao.editfreeze(ywmsUser);
	}


	@Override
	public int batchRemove(Integer[] userids){
		return ywmsUserDao.batchRemove(userids);
	}
	
	
	@Override
	public YwmsUserDO getUserByYyid(String yyid) {
		return ywmsUserDao.getUserByYyid(yyid);
	}
}
