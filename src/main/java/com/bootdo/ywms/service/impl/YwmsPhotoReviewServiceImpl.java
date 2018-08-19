package com.bootdo.ywms.service.impl;

import com.bootdo.common.ywms.JiguangPush;
import com.bootdo.ywms.dao.YwmsPhotoReviewDao;
import com.bootdo.ywms.domain.YwmsJgDO;
import com.bootdo.ywms.domain.YwmsPhotoReviewDO;
import com.bootdo.ywms.service.YwmsPhotoReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;



@Service
public class YwmsPhotoReviewServiceImpl implements YwmsPhotoReviewService {
	@Autowired
	private YwmsPhotoReviewDao ywmsPhotoReviewDao;
	
	@Override
	public YwmsPhotoReviewDO get(Long id){
		return ywmsPhotoReviewDao.get(id);
	}
	
	@Override
	public List<YwmsPhotoReviewDO> list(Map<String, Object> map){
		return ywmsPhotoReviewDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ywmsPhotoReviewDao.count(map);
	}
	
	@Override
	public int save(YwmsPhotoReviewDO ywmsPhotoReview){
		return ywmsPhotoReviewDao.save(ywmsPhotoReview);
	}
	
	@Override
	public int update(YwmsPhotoReviewDO ywmsPhotoReview){
		return ywmsPhotoReviewDao.update(ywmsPhotoReview);
	}
	
	@Override
	public int remove(Long id){
		return ywmsPhotoReviewDao.remove(id);
	}
	@Override
	public int no(YwmsPhotoReviewDO ywmsPhotoReview){
		int a =ywmsPhotoReviewDao.no(ywmsPhotoReview);
		String  userid  =  String.valueOf(ywmsPhotoReview.getUserid());
		String alert="上传头像存在问题,系统以替换成默认头像,请您重新上传合理头像!";

		JiguangPush.JiguangPush(alert,String.valueOf(userid));
		String d = "default%20avatar/personal_bg_portrait%402x.png";
		ywmsPhotoReview.setPortraiturl(d);
		ywmsPhotoReviewDao.updatedefaultphoto(ywmsPhotoReview);
		return a;
	}

	@Override
	@Transactional
	public int yes(YwmsPhotoReviewDO ywmsPhotoReview){
		int a = ywmsPhotoReviewDao.yes(ywmsPhotoReview);
		//ywmsPhotoReviewDao.updatephoto(ywmsPhotoReview);
		return a ;
	}


	@Override
	public int batchRemove(Long[] ids){
		return ywmsPhotoReviewDao.batchRemove(ids);
	}


	@Override
	public int batchPass(Integer[] dids, String status){
		return ywmsPhotoReviewDao.batchPass(dids, status);
	}


	@Override
	public int batchnotPass(Integer[] dids,Integer[] userids, String status){

		for(int i=0;i<userids.length;i++){

			String alert="上传头像存在问题,系统以替换成默认头像,请您重新上传合理头像!";

			JiguangPush.JiguangPush(alert,String.valueOf(userids[0]));

			YwmsJgDO ji = new YwmsJgDO();
			ji.setTouserid(userids[i]);
			ji.setType(1);
			ji.setCommentcontext(alert);
			int a = ywmsPhotoReviewDao.insertPhotoReviewJiguangInfo(ji);

			if(a>0){
				//增加用户未读消息条数
				YwmsPhotoReviewDO ywmsPhotoReview = new YwmsPhotoReviewDO();
				String d = "default%20avatar/personal_bg_portrait%402x.png";
				ywmsPhotoReview.setPortraiturl(d);
				ywmsPhotoReview.setUserid(userids[i]);
				 ywmsPhotoReviewDao.addunreadsysinfo(ywmsPhotoReview);

			}
		}

		return ywmsPhotoReviewDao.batchnotPass(dids, status);
	}

}
