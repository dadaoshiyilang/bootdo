package com.bootdo.system.service.impl;

import com.bootdo.system.dao.PayInfoDao;
import com.bootdo.system.domain.PayInfoDO;
import com.bootdo.system.service.PayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class PayInfoServiceImpl implements PayInfoService {
	@Autowired
	private PayInfoDao payInfoDao;
	
	@Override
	public PayInfoDO get(Long id){
		return payInfoDao.get(id);
	}
	
	@Override
	public List<PayInfoDO> list(Map<String, Object> map){
		return payInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return payInfoDao.count(map);
	}
	
	@Override
	public int save(PayInfoDO payInfo){
		return payInfoDao.save(payInfo);
	}
	
	@Override
	public int update(PayInfoDO payInfo){
		return payInfoDao.update(payInfo);
	}

	@Override
	public int editfreeze( PayInfoDO payInfo){
		return payInfoDao.editfreeze(payInfo);
	}


	@Override
	public int editthaw( PayInfoDO payInfo){
		int b = payInfoDao.countthaw(payInfo);
		if (b>0){
			return -1;
		}else{
			int a = payInfoDao.editthaw(payInfo);
			return a;
		}


	}


	@Override
	public int remove(Long id){
		return payInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return payInfoDao.batchRemove(ids);
	}
	
}
