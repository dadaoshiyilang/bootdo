package com.bootdo.sensation.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.common.utils.CommonUtil;
import com.bootdo.sensation.dao.OnlineSensationDao;
import com.bootdo.sensation.domain.OnlineSensationDO;
import com.bootdo.sensation.service.OnlineSensationService;



@Service
public class OnlineSensationServiceImpl implements OnlineSensationService {
	@Autowired
	private OnlineSensationDao onlineSensationDao;
	
	@Override
	public OnlineSensationDO get(Long id){
		return onlineSensationDao.get(id);
	}
	
	@Override
	public OnlineSensationDO getSensation(String whid){
		return onlineSensationDao.getSensation(whid);
	}
	
	@Override
	public List<OnlineSensationDO> list(Map<String, Object> map){
		return onlineSensationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return onlineSensationDao.count(map);
	}
	
	@Override
	public int save(OnlineSensationDO onlineSensation){
		 Long longtime =System.currentTimeMillis();
		 // 网红公司ID
		 String whid = longtime.toString().substring(longtime.toString().length()-6) + CommonUtil.createRandom(true,4);
		 onlineSensation.setWhid(whid);
		 onlineSensation.setCreateTime(new Date());// 创建时间
		 onlineSensation.setUpdateTime(new Date());// 修改时间
		
		
		return onlineSensationDao.save(onlineSensation);
	}
	
	@Override
	public int update(OnlineSensationDO onlineSensation){
		return onlineSensationDao.update(onlineSensation);
	}
	
	@Override
	public int remove(Long id){
		return onlineSensationDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return onlineSensationDao.batchRemove(ids);
	}
	
}
