package com.bootdo.review.service;

import com.bootdo.review.domain.DataPhotoVedioDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lz
 * @email 1992lcg@163.com
 * @date 2018-07-05 15:08:05
 */
public interface DataPhotoVedioService {
	
	DataPhotoVedioDO get(Integer did);
	
	List<DataPhotoVedioDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DataPhotoVedioDO dataPhotoVedio);
	
	int update(DataPhotoVedioDO dataPhotoVedio);
	
	int remove(Integer did);
	
	int batchRemove(Integer[] dids);
	
	int batchPass(Integer[] dids, String status, String reason);
}
