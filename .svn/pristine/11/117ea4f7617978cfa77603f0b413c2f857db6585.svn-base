package com.bootdo.review.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.review.dao.AuthenticationDao;
import com.bootdo.review.domain.AuthenticationDO;
import com.bootdo.review.service.AuthenticationService;



@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private AuthenticationDao authenticationDao;
	
	@Override
	public AuthenticationDO get(Long id){
		return authenticationDao.get(id);
	}
	
	@Override
	public List<AuthenticationDO> list(Map<String, Object> map){
		return authenticationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return authenticationDao.count(map);
	}
	
	@Override
	public int save(AuthenticationDO authentication){
		return authenticationDao.save(authentication);
	}
	
	@Override
	public int update(AuthenticationDO authentication){
		return authenticationDao.update(authentication);
	}
	
	@Override
	public int remove(Long id){
		return authenticationDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return authenticationDao.batchRemove(ids);
	}
	
	@Override
	public int batchPass(Long[] users, String status, String userstatus){
		return authenticationDao.batchPass(users, status, userstatus);
	}
	
	@Override
	public List<AuthenticationDO> Detaillist(Map<String, Object> map){
		return authenticationDao.Detaillist(map);
	}
	
	@Override
	public int detailcount(Map<String, Object> map){
		return authenticationDao.detailcount(map);
	}
}
