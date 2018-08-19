package com.bootdo.ywms.service.impl;


import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.bootdo.common.ywms.AlipayUtil;
import com.bootdo.common.ywms.JiguangPush;
import com.bootdo.ywms.dao.YwmsUserWithdrawalDao;
import com.bootdo.ywms.domain.YwmsJgDO;
import com.bootdo.ywms.domain.YwmsUserDO;
import com.bootdo.ywms.domain.YwmsUserWithdrawalDO;
import com.bootdo.ywms.domain.YwmswithdrawnumDO;
import com.bootdo.ywms.service.YwmsUserWithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class YwmsUserWithdrawalServiceImpl implements YwmsUserWithdrawalService {
	@Autowired
	private YwmsUserWithdrawalDao ywmsUserWithdrawalDao;
	
	@Override
	public YwmsUserWithdrawalDO get(Integer id){
		return ywmsUserWithdrawalDao.get(id);
	}


	@Override
	public List<YwmsUserWithdrawalDO> list(Map<String, Object> map){
		return ywmsUserWithdrawalDao.list(map);
	}

	@Override
	public List<YwmsUserWithdrawalDO> listrecord(Map<String, Object> map){
		return ywmsUserWithdrawalDao.listrecord(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return ywmsUserWithdrawalDao.count(map);
	}
	@Override
	public int countrecord(Map<String, Object> map){
		return ywmsUserWithdrawalDao.countrecord(map);
	}

	@Override
	public int save(YwmsUserWithdrawalDO ywmsUserWithdrawal){
		return ywmsUserWithdrawalDao.save(ywmsUserWithdrawal);
	}
	
	@Override
	public int update(YwmsUserWithdrawalDO ywmsUserWithdrawal){
		return ywmsUserWithdrawalDao.update(ywmsUserWithdrawal);
	}
	
	@Override
	public int remove(Integer id){
		return ywmsUserWithdrawalDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return ywmsUserWithdrawalDao.batchRemove(ids);
	}

	@Override
	public int no(Integer id){
		YwmsUserWithdrawalDO userwithdrawal = ywmsUserWithdrawalDao.get(id);

		String userid = String.valueOf(userwithdrawal.getUserid()) ;

		BigDecimal yuanbi = new BigDecimal(String.valueOf(userwithdrawal.getYuanbi())) ;

		String alert="您的提现请求被管理员驳回";

		JiguangPush.JiguangPush(alert,userid);


		YwmsJgDO ji = new YwmsJgDO();
		ji.setTouserid(Integer.parseInt(userid));
		ji.setType(1);
		ji.setCommentcontext(alert);
		int a = ywmsUserWithdrawalDao.insertWithdrawJiguangInfo(ji);
		int b=0;
		int c=0;

		if(a>0){
			//不通过
			b= ywmsUserWithdrawalDao.no(id);
			//增加用户未读消息条数
			YwmsUserDO user = new YwmsUserDO();
			user.setUserid(Integer.parseInt(userid));
			user.setWithdraw(yuanbi);

			c= ywmsUserWithdrawalDao.addunreadsysinfono(user);

	}

	return a*b*c;
	}


	@Override
	public Map<String, Object> yes(Integer id){
		YwmsUserWithdrawalDO userwithdrawal = ywmsUserWithdrawalDao.get(id);
		String out_biz_no=userwithdrawal.getOutBizNo();
		String userid = String.valueOf(userwithdrawal.getUserid()) ;
		String payaccount = userwithdrawal.getPayaccount();
		BigDecimal amount = userwithdrawal.getAmount();
		Map<String, Object> params = new HashMap<>();
		params.put("out_biz_no",out_biz_no);
		params.put("payaccount",payaccount);
		params.put("amount",amount);
		AlipayFundTransToaccountTransferResponse response = new AlipayFundTransToaccountTransferResponse();
		try {
			 response = AlipayUtil.getTransferInfo(params);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		if (response.isSuccess()){
			String alert="您的提现请求已经处理成功,请及时查看您的账户!";

			JiguangPush.JiguangPush(alert,userid);

			YwmsJgDO ji = new YwmsJgDO();
			ji.setTouserid(Integer.parseInt(userid));
			ji.setType(1);
			ji.setCommentcontext(alert);
			int a = ywmsUserWithdrawalDao.insertWithdrawJiguangInfo(ji);
			int b=0;
			int c=0;

			if(a>0){
				//通过
				b= ywmsUserWithdrawalDao.yes(id);
				//增加用户未读消息条数
				c= ywmsUserWithdrawalDao.addunreadsysinfo(userid);

			}
			Map<String,Object> result = new HashMap<>();
			if ( a*b*c==1){
				result.put("result","1");
			}
			alert="您的提现请求已经处理成功,请查看提现记录!";
			result.put("msg",alert);
			return result;
		}else{

			String msg = response.getSubMsg();

			BigDecimal yuanbi = new BigDecimal(String.valueOf(userwithdrawal.getYuanbi())) ;

			String alert="提现请求失败,"+msg;

			JiguangPush.JiguangPush(alert,userid);


			YwmsJgDO ji = new YwmsJgDO();
			ji.setTouserid(Integer.parseInt(userid));
			ji.setType(1);
			ji.setCommentcontext(alert);
			int a = ywmsUserWithdrawalDao.insertWithdrawJiguangInfo(ji);
			int b=0;
			int c=0;

			if(a>0){
				//不通过
				b= ywmsUserWithdrawalDao.no(id);
				//增加用户未读消息条数
				YwmsUserDO user = new YwmsUserDO();
				user.setUserid(Integer.parseInt(userid));
				user.setWithdraw(yuanbi);

				c= ywmsUserWithdrawalDao.addunreadsysinfono(user);

			}
			Map<String,Object> result = new HashMap<>();
			if ( a*b*c==1){
				result.put("result","0");
			}

			result.put("msg",alert);
			return result;
		}




	}

	@Override
	@Transactional
	public YwmswithdrawnumDO num(Map<String, Object> map) {
		Date time = new Date();
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");
		String nowtime = format0.format(time.getTime());//这个就是把时间戳经过处理得到期望格式的时间
		map.put("nowtime",nowtime);

		YwmswithdrawnumDO a = ywmsUserWithdrawalDao.num1(map);

		YwmswithdrawnumDO b = ywmsUserWithdrawalDao.num2(map);

		a.setTodayuserwithdrawnum(b.getTodayuserwithdrawnum());
		a.setTodaymoneywithdrawnum(b.getTodaymoneywithdrawnum());
		return a;
	}



}
