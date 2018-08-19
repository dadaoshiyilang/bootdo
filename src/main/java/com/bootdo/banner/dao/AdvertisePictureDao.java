package com.bootdo.banner.dao;

import com.bootdo.banner.domain.AdvertisePictureDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 首页轮播图表
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-19 10:56:38
 */
@Mapper
public interface AdvertisePictureDao {

	AdvertisePictureDO get(Integer id);
	
	List<AdvertisePictureDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AdvertisePictureDO advertisePicture);
	
	int update(AdvertisePictureDO advertisePicture);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	int batchOnline(@Param(value = "ids") Integer[] ids, @Param(value = "status") String status);
}
