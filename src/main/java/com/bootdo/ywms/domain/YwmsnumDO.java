package com.bootdo.ywms.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 每日充值和总充值
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-05 15:03:23
 */
public class YwmsnumDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//所有用户数
	private Integer allusernum;
	//当日用户数
	private Integer todayusernum;
	//所有用户充值金额
	private BigDecimal allmoneynum;
	//当日用户充值金额
	private BigDecimal todaymoneynum;


	public Integer getAllusernum() {
		return allusernum;
	}

	public void setAllusernum(Integer allusernum) {
		this.allusernum = allusernum;
	}

	public Integer getTodayusernum() {
		return todayusernum;
	}

	public void setTodayusernum(Integer todayusernum) {
		this.todayusernum = todayusernum;
	}

	public BigDecimal getAllmoneynum() {
		return allmoneynum;
	}

	public void setAllmoneynum(BigDecimal allmoneynum) {
		this.allmoneynum = allmoneynum;
	}

	public BigDecimal getTodaymoneynum() {
		return todaymoneynum;
	}

	public void setTodaymoneynum(BigDecimal todaymoneynum) {
		this.todaymoneynum = todaymoneynum;
	}
}
