package com.bootdo.ywms.service.impl;

import com.bootdo.common.ywms.JiguangPush;
import com.bootdo.ywms.dao.YwmsJiguanginfoDao;
import com.bootdo.ywms.dao.YwmsUserDao;
import com.bootdo.ywms.domain.YwmsJiguanginfoDO;
import com.bootdo.ywms.domain.YwmsUserDO;
import com.bootdo.ywms.service.YwmsJiguanginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service
public class YwmsJiguanginfoServiceImpl implements YwmsJiguanginfoService {
	@Autowired
	private YwmsJiguanginfoDao ywmsJiguanginfoDao;
	@Autowired
	private YwmsUserDao ywmsUserDao;
	@Override
	public YwmsJiguanginfoDO get(Long id){
		return ywmsJiguanginfoDao.get(id);
	}
	
	@Override
	public List<YwmsJiguanginfoDO> list(Map<String, Object> map){
		return ywmsJiguanginfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ywmsJiguanginfoDao.count(map);
	}
	
	@Override
	public int save(YwmsJiguanginfoDO ywmsJiguanginfo){
		return ywmsJiguanginfoDao.save(ywmsJiguanginfo);
	}
	
	@Override
	public int update(YwmsJiguanginfoDO ywmsJiguanginfo){
		return ywmsJiguanginfoDao.update(ywmsJiguanginfo);
	}
	
	@Override
	public int remove(Long id){
		return ywmsJiguanginfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return ywmsJiguanginfoDao.batchRemove(ids);
	}

	@Override
	@Transactional
	public int push(Map<String, Object> map) {
		String choose = (String) map.get("choose");
		if (choose.equals("0")){
			//指定单个用户
			int a=0;
			if (map.get("touserid")!=null){
				YwmsUserDO user =  ywmsUserDao.get1(String.valueOf(map.get("touserid")));
				//应为订单表中没有眼缘id的字段.所以使用字符类型同为varchar的ordersn占时保存一下

				if (user.getUserid()!=null){

					int userid =user.getUserid() ;
					YwmsJiguanginfoDO jiguaninfo = new YwmsJiguanginfoDO();
					jiguaninfo.setTouserid(Long.valueOf(user.getUserid()));
					jiguaninfo.setType(1);
					jiguaninfo.setCommentcontext((String) map.get("commentcontext"));
					a = ywmsJiguanginfoDao.insertinfo(jiguaninfo);
					if (a>0){
						String alert="您的提现请求已经处理成功,请及时查看您的账户!";

						JiguangPush.JiguangPush(alert,String.valueOf(userid));

						ywmsJiguanginfoDao.addunreadsysinfo(String.valueOf(userid));
					}
				}

			}

			return a;
		}else if (choose.equals("1")){
			//所有网红
			String allwh = ywmsUserDao.allwh();
			if(allwh!=null){
				String[] a = allwh.trim().split(",");
				List<YwmsJiguanginfoDO> jiguaninfo = new ArrayList<>();
				for(int j = 0 ; j < a.length; j++) {
					YwmsJiguanginfoDO jiguan = new YwmsJiguanginfoDO();
					jiguan.setTouserid(Long.valueOf(a[j]));
					jiguan.setType(1);
					jiguan.setCommentcontext((String) map.get("commentcontext"));
					jiguaninfo.add(jiguan);

				}
				ywmsJiguanginfoDao.insertinfoByBatch(jiguaninfo);

				String alert="您的提现请求已经处理成功,请及时查看您的账户!";

				for (int i=0;i<a.length;i++){

					JiguangPush.JiguangPush(alert,String.valueOf(a[i]));
				}

				ywmsJiguanginfoDao.addunreadsysinfobybatch(jiguaninfo);



			}
			return 1 ;
		}else if (choose.equals("2")){
			//指定多个用户
			return 0;
			/*String allwh = ywmsUserDao.allwh();
			if(allwh!=null){
				String[] a = allwh.trim().split(",");
				List<YwmsJiguanginfoDO> jiguaninfo = new ArrayList<>();
				for(int j = 0 ; j < a.length; j++) {
					YwmsJiguanginfoDO jiguan = new YwmsJiguanginfoDO();
					jiguan.setTouserid(Long.valueOf(a[j]));
					jiguan.setType(1);
					jiguan.setCommentcontext((String) map.get("commentcontext"));
					jiguaninfo.add(jiguan);

				}
				ywmsJiguanginfoDao.insertinfoByBatch(jiguaninfo);

				String alert="您的提现请求已经处理成功,请及时查看您的账户!";

				for (int i=0;i<a.length;i++){

					JiguangPush.JiguangPush(alert,String.valueOf(a[i]));
				}

				ywmsJiguanginfoDao.addunreadsysinfobybatch(jiguaninfo);



			}
			return 1 ;*/
		}
		return 0;
	}

}
