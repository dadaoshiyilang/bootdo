package com.bootdo.review.service;

import com.bootdo.review.domain.NewsDO;
import java.util.List;
import java.util.Map;

/**
 * @author lz
 * @email 1992lcg@163.com
 * @date 2018-07-04 13:44:49
 */
public interface NewsService {
	
	NewsDO get(Integer newsid);
	
	List<NewsDO> getNewsINfo(Integer newsid);
	
	List<NewsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(NewsDO news);
	
	int update(NewsDO news);
	
	int remove(Integer newsid);
	
	int batchRemove(Integer[] newsids);
	
	int updateNews(NewsDO news);
}
