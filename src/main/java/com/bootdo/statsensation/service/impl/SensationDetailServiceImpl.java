package com.bootdo.statsensation.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootdo.statsensation.dao.SensationDetailDao;
import com.bootdo.statsensation.domain.SensationDetailDO;
import com.bootdo.statsensation.service.SensationDetailService;
import com.bootdo.ywms.domain.YwmsUserDO;
import com.bootdo.ywms.service.YwmsUserService;


@Service
public class SensationDetailServiceImpl implements SensationDetailService {
	@Autowired
	private SensationDetailDao sensationDetailDao;
	
	@Autowired
	private YwmsUserService ywmsUserService;
	
	@Override
	public SensationDetailDO get(Long id){
		return sensationDetailDao.get(id);
	}
	
	@Override
	public List<SensationDetailDO> list(Map<String, Object> map){
		return sensationDetailDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sensationDetailDao.count(map);
	}
	
	@Override
	public int save(SensationDetailDO sensationDaily, YwmsUserDO userDO){
		userDO.setAdminaffirm("3");// 合作网红
		userDO.setWhcooperation(1);// 合作网红：是
		userDO.setWhcompany(sensationDaily.getWhname());// 网红公司名称
		userDO.setWhcomId(sensationDaily.getWhid());// 网红公司Id
		return ywmsUserService.update(userDO);
	}
	
	@Override
	public int update(SensationDetailDO sensationDetail){
		return sensationDetailDao.update(sensationDetail);
	}
	
	@Override
	public int remove(Long id){
		return sensationDetailDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sensationDetailDao.batchRemove(ids);
	}
	
	@Override
	public Map<String, Object> getSensation(Map<String, String> map) {
		return sensationDetailDao.getSensation(map);
	}
}
