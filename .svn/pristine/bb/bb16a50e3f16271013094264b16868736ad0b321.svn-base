package com.bootdo.ywms.dao;

import com.bootdo.ywms.domain.YwmsJgDO;
import com.bootdo.ywms.domain.YwmsPhotoReviewDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 头像审核表
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-11 16:10:11
 */
@Mapper
public interface YwmsPhotoReviewDao {

	YwmsPhotoReviewDO get(Long id);
	
	List<YwmsPhotoReviewDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(YwmsPhotoReviewDO ywmsPhotoReview);
	
	int update(YwmsPhotoReviewDO ywmsPhotoReview);
	
	int remove(Long id);

	int no(YwmsPhotoReviewDO ywmsPhotoReview);

	int yes(YwmsPhotoReviewDO ywmsPhotoReview);

	int updatephoto(YwmsPhotoReviewDO ywmsPhotoReview);

	int updatedefaultphoto(YwmsPhotoReviewDO ywmsPhotoReview);

	int batchRemove(Long[] ids);

	int batchPass(@Param(value = "ids") Integer[] dids, @Param(value = "status") String status);

	int batchnotPass(@Param(value = "ids") Integer[] dids, @Param(value = "status") String status);



	int insertPhotoReviewJiguangInfo(YwmsJgDO ji);

	int addunreadsysinfo(YwmsPhotoReviewDO ywmsPhotoReview);

}
