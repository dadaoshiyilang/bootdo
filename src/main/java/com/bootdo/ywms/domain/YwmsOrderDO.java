package com.bootdo.ywms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 用户订单表
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-12 14:41:17
 */
public class YwmsOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//订单id
	private Integer orderid;
	//订单号
	private String ordersn;
	//订单金额
	private Double ordercount;

	//手机号
	private String phonenumber;
	//订单总金额
	private Double allordercount;
	//用户id
	private Integer userid;
	//充值的缘豆数量
	private String productname;
	//1支付宝,2微信,3IAP
	private Integer paytype;
	//0.支付失败1.支付成功
	private Integer state;
	//0.为推送,1.已经推送
	private Integer pushstatus;
	//创建时间
	private Date createtime;
	//修改时间
	private Date updatetime;
	//用户最后一次上线时间
	private Date lastonlinetime;

	//状态（1为可用0为不可用）
	private Integer deleteflag;

	//用户昵称
	private String nickname;

	//眼缘id
	private String yyid;

	//用户性别
	private String usersex;

	//用户创建时间
	private Date usercreatetime;

	//用户可用状态
	private String del;

	//用户可用状态
	private String start;

	//用户可用状态
	private String end;

	//缘豆(充值)
	private BigDecimal recharge;
	//缘币(提现)
	private BigDecimal withdraw;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getUsercreatetime() {
		return usercreatetime;
	}

	public void setUsercreatetime(Date usercreatetime) {
		this.usercreatetime = usercreatetime;
	}

	public Date getLastonlinetime() {
		return lastonlinetime;
	}

	public void setLastonlinetime(Date lastonlinetime) {
		this.lastonlinetime = lastonlinetime;
	}

	public Double getAllordercount() {
		return allordercount;
	}

	public void setAllordercount(Double allordercount) {
		this.allordercount = allordercount;
	}

	public BigDecimal getRecharge() {
		return recharge;
	}

	public void setRecharge(BigDecimal recharge) {
		this.recharge = recharge;
	}

	public BigDecimal getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(BigDecimal withdraw) {
		this.withdraw = withdraw;
	}

	public String getUsersex() {
		return usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getYyid() {
		return yyid;
	}

	public void setYyid(String yyid) {
		this.yyid = yyid;
	}

	/**
	 * 设置：订单id
	 */
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	/**
	 * 获取：订单id
	 */
	public Integer getOrderid() {
		return orderid;
	}
	/**
	 * 设置：订单号
	 */
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	/**
	 * 获取：订单号
	 */
	public String getOrdersn() {
		return ordersn;
	}
	/**
	 * 设置：订单金额
	 */
	public void setOrdercount(Double ordercount) {
		this.ordercount = ordercount;
	}
	/**
	 * 获取：订单金额
	 */
	public Double getOrdercount() {
		return ordercount;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * 设置：充值的缘豆数量
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}
	/**
	 * 获取：充值的缘豆数量
	 */
	public String getProductname() {
		return productname;
	}
	/**
	 * 设置：1支付宝,2微信,3IAP
	 */
	public void setPaytype(Integer paytype) {
		this.paytype = paytype;
	}
	/**
	 * 获取：1支付宝,2微信,3IAP
	 */
	public Integer getPaytype() {
		return paytype;
	}
	/**
	 * 设置：0.支付失败1.支付成功
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：0.支付失败1.支付成功
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：0.为推送,1.已经推送
	 */
	public void setPushstatus(Integer pushstatus) {
		this.pushstatus = pushstatus;
	}
	/**
	 * 获取：0.为推送,1.已经推送
	 */
	public Integer getPushstatus() {
		return pushstatus;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：状态（1为可用0为不可用）
	 */
	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}
	/**
	 * 获取：状态（1为可用0为不可用）
	 */
	public Integer getDeleteflag() {
		return deleteflag;
	}
}
