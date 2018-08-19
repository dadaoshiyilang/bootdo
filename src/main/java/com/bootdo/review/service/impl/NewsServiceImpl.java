package com.bootdo.review.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.bootdo.review.dao.NewsDao;
import com.bootdo.review.domain.NewsDO;
import com.bootdo.review.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDao newsDao;
	
	@Override
	public NewsDO get(Integer newsid){
		return newsDao.get(newsid);
	}
	
	@Override
	public List<NewsDO> list(Map<String, Object> map){
		return newsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return newsDao.count(map);
	}
	
	@Override
	public int save(NewsDO news){
		return newsDao.save(news);
	}
	
	@Override
	public int update(NewsDO news){
		return newsDao.update(news);
	}
	
	@Override
	public int remove(Integer newsid){
		return newsDao.remove(newsid);
	}
	
	@Override
	public int batchRemove(Integer[] newsids){
		return newsDao.batchRemove(newsids);
	}
	
	@Override
	public int updateNews(NewsDO news){
		return newsDao.updateNews(news);
	}
	
	@Override
	public List<NewsDO> getNewsINfo(Integer newsid){
		return newsDao.getNewsINfo(newsid);
	}
}
