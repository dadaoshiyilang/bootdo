package com.bootdo.ywms.service;

import com.bootdo.ywms.domain.YwmsPresentListDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-25 18:13:49
 */
public interface YwmsPresentListService {
	
	YwmsPresentListDO get(Integer id);
	
	List<YwmsPresentListDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(YwmsPresentListDO ywmsPresentList, MultipartFile fileField, Long userId);
	
	int update(YwmsPresentListDO ywmsPresentList,Long userId);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	int batchOnline(Integer[] ids, String status);
}
