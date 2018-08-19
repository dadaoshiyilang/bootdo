package com.bootdo.review.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.review.dao.DataPhotoVedioDao;
import com.bootdo.review.domain.DataPhotoVedioDO;
import com.bootdo.review.service.DataPhotoVedioService;



@Service
public class DataPhotoVedioServiceImpl implements DataPhotoVedioService {
	@Autowired
	private DataPhotoVedioDao dataPhotoVedioDao;
	
	@Override
	public DataPhotoVedioDO get(Integer did){
		return dataPhotoVedioDao.get(did);
	}
	
	@Override
	public List<DataPhotoVedioDO> list(Map<String, Object> map){
		return dataPhotoVedioDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dataPhotoVedioDao.count(map);
	}
	
	@Override
	public int save(DataPhotoVedioDO dataPhotoVedio){
		return dataPhotoVedioDao.save(dataPhotoVedio);
	}
	
	@Override
	public int update(DataPhotoVedioDO dataPhotoVedio){
		return dataPhotoVedioDao.update(dataPhotoVedio);
	}
	
	@Override
	public int remove(Integer did){
		return dataPhotoVedioDao.remove(did);
	}
	
	@Override
	public int batchRemove(Integer[] dids){
		return dataPhotoVedioDao.batchRemove(dids);
	}
	
	@Override
	public int batchPass(Integer[] dids, String status, String reason){
		return dataPhotoVedioDao.batchPass(dids, status, reason);
	}
}
