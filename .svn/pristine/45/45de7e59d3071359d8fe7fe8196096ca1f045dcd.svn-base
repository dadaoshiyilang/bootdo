package com.bootdo.ywms.service;

import com.bootdo.ywms.domain.YwmsPhotoReviewDO;

import java.util.List;
import java.util.Map;

/**
 * 头像审核表
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-11 16:10:11
 */
public interface YwmsPhotoReviewService {
	
	YwmsPhotoReviewDO get(Long id);
	
	List<YwmsPhotoReviewDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(YwmsPhotoReviewDO ywmsPhotoReview);
	
	int update(YwmsPhotoReviewDO ywmsPhotoReview);
	
	int remove(Long id);

	int no(YwmsPhotoReviewDO ywmsPhotoReview);

	int yes(YwmsPhotoReviewDO ywmsPhotoReview);



	int batchRemove(Long[] ids);
	//批量通过
	int batchPass(Integer[] dids, String status);
	//批量不通过
	int batchnotPass(Integer[] dids,Integer[] userids, String status);




}
