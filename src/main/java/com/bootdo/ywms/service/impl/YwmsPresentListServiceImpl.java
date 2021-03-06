package com.bootdo.ywms.service.impl;

import cn.jiguang.common.utils.StringUtils;
import com.bootdo.common.utils.OSSClientUtil;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.UserService;
import com.bootdo.ywms.dao.YwmsPresentListDao;
import com.bootdo.ywms.domain.YwmsPresentListDO;
import com.bootdo.ywms.service.YwmsPresentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class YwmsPresentListServiceImpl implements YwmsPresentListService {
	@Autowired
	private YwmsPresentListDao ywmsPresentListDao;

	@Autowired
	private OSSClientUtil ossClient;


	@Autowired
	private UserService userService;

	@Override
	public YwmsPresentListDO get(Integer id){
		return ywmsPresentListDao.get(id);
	}
	
	@Override
	public List<YwmsPresentListDO> list(Map<String, Object> map){
		return ywmsPresentListDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ywmsPresentListDao.count(map);
	}
	
	@Override
	public int save(YwmsPresentListDO ywmsPresentList, MultipartFile fileField, Long userId){
		try {
			String presenturl = ossClient.uploadImg2Oss(fileField,"presentlist");// 上传图片到阿里云
			//String presenturl = "presentlist/%E8%BF%AA%E5%A5%A5%E7%9C%9F%E6%88%91%402x.png";
			if (StringUtils.isNotEmpty(presenturl)) {
				ywmsPresentList.setPresenturl("presentlist/"+presenturl);
				Date endDate = ywmsPresentList.getEndtime();// 结束日期
				Calendar endDatecal = Calendar.getInstance();
				endDatecal.setTime(endDate);
				endDatecal.add(Calendar.HOUR, 23);
				endDatecal.add(Calendar.MINUTE, 59);
				endDatecal.add(Calendar.SECOND, 59);
				ywmsPresentList.setEndtime(endDatecal.getTime());// 结束时间
				ywmsPresentList.setCreatetime(new Date());// 创建时间
				UserDO userDO  = userService.get(userId);
				ywmsPresentList.setCreateuser(userDO.getName());// 创建者
				ywmsPresentList.setDel(1);
				int flag = ywmsPresentListDao.save(ywmsPresentList);
				if (flag > 0) {
					return 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;


	}
	
	@Override
	public int update(YwmsPresentListDO ywmsPresentList, Long userId){
		ywmsPresentList.setUpdatetime(new Date());
		Date endDate = ywmsPresentList.getEndtime();// 结束日期
		Calendar endDatecal = Calendar.getInstance();
		endDatecal.setTime(endDate);
		endDatecal.add(Calendar.HOUR, 23);
		endDatecal.add(Calendar.MINUTE, 59);
		endDatecal.add(Calendar.SECOND, 59);
		ywmsPresentList.setEndtime(endDatecal.getTime());// 结束时间
		UserDO userDO  = userService.get(userId);
		ywmsPresentList.setUpdateuser(userDO.getName());
		return ywmsPresentListDao.update(ywmsPresentList);
	}
	
	@Override
	public int remove(Integer id){
		return ywmsPresentListDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return ywmsPresentListDao.batchRemove(ids);
	}

	@Override
	public int batchOnline(Integer[] ids, String status){
		return ywmsPresentListDao.batchOnline(ids, status);
	}




	
}
