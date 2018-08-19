package com.bootdo.banner.service;

import com.bootdo.banner.domain.AdvertisePictureDO;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 首页轮播图表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-19 10:56:38
 */
public interface AdvertisePictureService {
	
	AdvertisePictureDO get(Integer id);
	
	List<AdvertisePictureDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	boolean save(AdvertisePictureDO advertisePicture, MultipartFile fileField, Long userId);
	
	int update(AdvertisePictureDO advertisePicture, Long userId);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	int batchOnline(Integer[] ids, String status);
}
