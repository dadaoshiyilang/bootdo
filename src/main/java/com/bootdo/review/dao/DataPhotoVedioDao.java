package com.bootdo.review.dao;

import com.bootdo.review.domain.DataPhotoVedioDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author lz
 * @email 1992lcg@163.com
 * @date 2018-07-05 15:08:05
 */
@Mapper
public interface DataPhotoVedioDao {

	DataPhotoVedioDO get(Integer did);
	
	List<DataPhotoVedioDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DataPhotoVedioDO dataPhotoVedio);
	
	int update(DataPhotoVedioDO dataPhotoVedio);
	
	int remove(Integer did);
	
	int batchRemove(Integer[] dids);
	
	int batchPass(@Param(value = "ids") Integer[] dids, @Param(value = "status") String status,
			@Param("reason") String reason);
}
