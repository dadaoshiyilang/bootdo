package com.bootdo.ywms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 用户表
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-05 15:03:23
 */
public class YwmsUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户唯一标识
	private Integer userid;
	//眼缘ID
	private String yyid;
	//用户手机号，也是登陆名
	private String phonenumber;
	//用户密码
	private String userpassword;
	//头像地址
	private String portraiturl;
	//用户昵称
	private String nickname;
	//空间背景图片
	private String albumpicture;
	//性别 0女 1男
	private String usersex;
	//年龄
	private String age;
	//用户生日
	private Date userbirthday;
	//用户星座
	private String constellation;
	//用户的定位地址
	private String userloc;
	//用户所在的省市
	private String usersite;
	//身高
	private String userheight;
	//体重
	private String userweight;
	//三围
	private String sanwei;
	//职业
	private String occupation;
	//用户经度
	private BigDecimal longitude;
	//用户纬度
	private BigDecimal latitude;
	//兴趣爱好
	private String interest;
	//签名
	private String signature;
	//关注数
	private Integer concerncount;
	//粉丝
	private Integer fans;
	//图片数量
	private Integer piccount;
	//视频数量
	private Integer vediocount;
	//聊天价格
	private Integer priceforchat;
	//在线视频价格
	private Integer priceforvedio;
	//浏览次数
	private Integer lookcount;
	//是否认证，0未认证 1已认证 2审核中 3合作网红
	private String adminaffirm;
	//认证图片1
	private String attestationpicture1;
	//认证图片2
	private String attestationpicture2;
	//身份证
	private String creditcard;
	//姓名(提款姓名)
	private String realname;
	//提款账户
	private String withdrawacount;
	//缘豆(充值)
	private BigDecimal recharge;
	//缘币(提现)
	private BigDecimal withdraw;
	//设备号
	private String deviceid;
	//用户的状态（1为可用0为不可用）
	private String deleteflag;
	//授权码
	private String accesscode;
	//最后一次登陆时间
	private Date lastlogintime;
	//创建时间
	private Date createtime;
	//更新时间
	private Date updatetime;
	//融云及时聊天的token
	private String rytoken;
	//被举报次数
	private Integer reportedtime;
	//0.非会员1.会员
	private Integer vip;
	//1.月会员2.季会员3.半年会员4.年会员
	private Integer viptype;
	//0.否1.是(需付费才可以查看的用户(入驻版的兼职以及以后的主播))
	private Integer paytosee;
	//qq登陆id
	private String qqopenid;
	//微信登陆id
	private String weixinopenid;
	//微博的openid
	private String weiboopenid;
	//0.不在线,1.在线
	private Integer online;
	//最近一次上线时间
	private Date lastonlinetime;
	//最近一次下线时间
	private Date lastofflinetime;
	//在线总时间
	private Integer onlinecount;
	//好评率
	private Double feedback;
	//评价条数
	private Integer evaluatecount;
	//合作网红(0.否,1.是)
	private Integer whcooperation;
	//合作网红公司名称
	private String whcomId;
	//合作网红公司的名称
	private String whcompany;
	//未读系统消息条数
	private Integer unreadsysinfo;
	//未读动态消息条数
	private Integer unreadnewsinfo;

	/**
	 * 设置：用户唯一标识
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：用户唯一标识
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * 设置：眼缘ID
	 */
	public void setYyid(String yyid) {
		this.yyid = yyid;
	}
	/**
	 * 获取：眼缘ID
	 */
	public String getYyid() {
		return yyid;
	}
	/**
	 * 设置：用户手机号，也是登陆名
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * 获取：用户手机号，也是登陆名
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * 设置：用户密码
	 */
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	/**
	 * 获取：用户密码
	 */
	public String getUserpassword() {
		return userpassword;
	}
	/**
	 * 设置：头像地址
	 */
	public void setPortraiturl(String portraiturl) {
		this.portraiturl = portraiturl;
	}
	/**
	 * 获取：头像地址
	 */
	public String getPortraiturl() {
		return portraiturl;
	}
	/**
	 * 设置：用户昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：用户昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：空间背景图片
	 */
	public void setAlbumpicture(String albumpicture) {
		this.albumpicture = albumpicture;
	}
	/**
	 * 获取：空间背景图片
	 */
	public String getAlbumpicture() {
		return albumpicture;
	}
	/**
	 * 设置：性别 0女 1男
	 */
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	/**
	 * 获取：性别 0女 1男
	 */
	public String getUsersex() {
		return usersex;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public String getAge() {
		return age;
	}
	/**
	 * 设置：用户生日
	 */
	public void setUserbirthday(Date userbirthday) {
		this.userbirthday = userbirthday;
	}
	/**
	 * 获取：用户生日
	 */
	public Date getUserbirthday() {
		return userbirthday;
	}
	/**
	 * 设置：用户星座
	 */
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	/**
	 * 获取：用户星座
	 */
	public String getConstellation() {
		return constellation;
	}
	/**
	 * 设置：用户的定位地址
	 */
	public void setUserloc(String userloc) {
		this.userloc = userloc;
	}
	/**
	 * 获取：用户的定位地址
	 */
	public String getUserloc() {
		return userloc;
	}
	/**
	 * 设置：用户所在的省市
	 */
	public void setUsersite(String usersite) {
		this.usersite = usersite;
	}
	/**
	 * 获取：用户所在的省市
	 */
	public String getUsersite() {
		return usersite;
	}
	/**
	 * 设置：身高
	 */
	public void setUserheight(String userheight) {
		this.userheight = userheight;
	}
	/**
	 * 获取：身高
	 */
	public String getUserheight() {
		return userheight;
	}
	/**
	 * 设置：体重
	 */
	public void setUserweight(String userweight) {
		this.userweight = userweight;
	}
	/**
	 * 获取：体重
	 */
	public String getUserweight() {
		return userweight;
	}
	/**
	 * 设置：三围
	 */
	public void setSanwei(String sanwei) {
		this.sanwei = sanwei;
	}
	/**
	 * 获取：三围
	 */
	public String getSanwei() {
		return sanwei;
	}
	/**
	 * 设置：职业
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**
	 * 获取：职业
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * 设置：用户经度
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：用户经度
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}
	/**
	 * 设置：用户纬度
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：用户纬度
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}
	/**
	 * 设置：兴趣爱好
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}
	/**
	 * 获取：兴趣爱好
	 */
	public String getInterest() {
		return interest;
	}
	/**
	 * 设置：签名
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * 获取：签名
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * 设置：关注数
	 */
	public void setConcerncount(Integer concerncount) {
		this.concerncount = concerncount;
	}
	/**
	 * 获取：关注数
	 */
	public Integer getConcerncount() {
		return concerncount;
	}
	/**
	 * 设置：粉丝
	 */
	public void setFans(Integer fans) {
		this.fans = fans;
	}
	/**
	 * 获取：粉丝
	 */
	public Integer getFans() {
		return fans;
	}
	/**
	 * 设置：图片数量
	 */
	public void setPiccount(Integer piccount) {
		this.piccount = piccount;
	}
	/**
	 * 获取：图片数量
	 */
	public Integer getPiccount() {
		return piccount;
	}
	/**
	 * 设置：视频数量
	 */
	public void setVediocount(Integer vediocount) {
		this.vediocount = vediocount;
	}
	/**
	 * 获取：视频数量
	 */
	public Integer getVediocount() {
		return vediocount;
	}
	/**
	 * 设置：聊天价格
	 */
	public void setPriceforchat(Integer priceforchat) {
		this.priceforchat = priceforchat;
	}
	/**
	 * 获取：聊天价格
	 */
	public Integer getPriceforchat() {
		return priceforchat;
	}
	/**
	 * 设置：在线视频价格
	 */
	public void setPriceforvedio(Integer priceforvedio) {
		this.priceforvedio = priceforvedio;
	}
	/**
	 * 获取：在线视频价格
	 */
	public Integer getPriceforvedio() {
		return priceforvedio;
	}
	/**
	 * 设置：浏览次数
	 */
	public void setLookcount(Integer lookcount) {
		this.lookcount = lookcount;
	}
	/**
	 * 获取：浏览次数
	 */
	public Integer getLookcount() {
		return lookcount;
	}
	/**
	 * 设置：是否认证，0未认证 1已认证 2审核中 3合作网红
	 */
	public void setAdminaffirm(String adminaffirm) {
		this.adminaffirm = adminaffirm;
	}
	/**
	 * 获取：是否认证，0未认证 1已认证 2审核中 3合作网红
	 */
	public String getAdminaffirm() {
		return adminaffirm;
	}
	/**
	 * 设置：认证图片1
	 */
	public void setAttestationpicture1(String attestationpicture1) {
		this.attestationpicture1 = attestationpicture1;
	}
	/**
	 * 获取：认证图片1
	 */
	public String getAttestationpicture1() {
		return attestationpicture1;
	}
	/**
	 * 设置：认证图片2
	 */
	public void setAttestationpicture2(String attestationpicture2) {
		this.attestationpicture2 = attestationpicture2;
	}
	/**
	 * 获取：认证图片2
	 */
	public String getAttestationpicture2() {
		return attestationpicture2;
	}
	/**
	 * 设置：身份证
	 */
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	/**
	 * 获取：身份证
	 */
	public String getCreditcard() {
		return creditcard;
	}
	/**
	 * 设置：姓名(提款姓名)
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：姓名(提款姓名)
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：提款账户
	 */
	public void setWithdrawacount(String withdrawacount) {
		this.withdrawacount = withdrawacount;
	}
	/**
	 * 获取：提款账户
	 */
	public String getWithdrawacount() {
		return withdrawacount;
	}
	/**
	 * 设置：缘豆(充值)
	 */
	public void setRecharge(BigDecimal recharge) {
		this.recharge = recharge;
	}
	/**
	 * 获取：缘豆(充值)
	 */
	public BigDecimal getRecharge() {
		return recharge;
	}
	/**
	 * 设置：缘币(提现)
	 */
	public void setWithdraw(BigDecimal withdraw) {
		this.withdraw = withdraw;
	}
	/**
	 * 获取：缘币(提现)
	 */
	public BigDecimal getWithdraw() {
		return withdraw;
	}
	/**
	 * 设置：设备号
	 */
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	/**
	 * 获取：设备号
	 */
	public String getDeviceid() {
		return deviceid;
	}
	/**
	 * 设置：用户的状态（1为可用0为不可用）
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	/**
	 * 获取：用户的状态（1为可用0为不可用）
	 */
	public String getDeleteflag() {
		return deleteflag;
	}
	/**
	 * 设置：授权码
	 */
	public void setAccesscode(String accesscode) {
		this.accesscode = accesscode;
	}
	/**
	 * 获取：授权码
	 */
	public String getAccesscode() {
		return accesscode;
	}
	/**
	 * 设置：最后一次登陆时间
	 */
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	/**
	 * 获取：最后一次登陆时间
	 */
	public Date getLastlogintime() {
		return lastlogintime;
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
	 * 设置：更新时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：融云及时聊天的token
	 */
	public void setRytoken(String rytoken) {
		this.rytoken = rytoken;
	}
	/**
	 * 获取：融云及时聊天的token
	 */
	public String getRytoken() {
		return rytoken;
	}
	/**
	 * 设置：被举报次数
	 */
	public void setReportedtime(Integer reportedtime) {
		this.reportedtime = reportedtime;
	}
	/**
	 * 获取：被举报次数
	 */
	public Integer getReportedtime() {
		return reportedtime;
	}
	/**
	 * 设置：0.非会员1.会员
	 */
	public void setVip(Integer vip) {
		this.vip = vip;
	}
	/**
	 * 获取：0.非会员1.会员
	 */
	public Integer getVip() {
		return vip;
	}
	/**
	 * 设置：1.月会员2.季会员3.半年会员4.年会员
	 */
	public void setViptype(Integer viptype) {
		this.viptype = viptype;
	}
	/**
	 * 获取：1.月会员2.季会员3.半年会员4.年会员
	 */
	public Integer getViptype() {
		return viptype;
	}
	/**
	 * 设置：0.否1.是(需付费才可以查看的用户(入驻版的兼职以及以后的主播))
	 */
	public void setPaytosee(Integer paytosee) {
		this.paytosee = paytosee;
	}
	/**
	 * 获取：0.否1.是(需付费才可以查看的用户(入驻版的兼职以及以后的主播))
	 */
	public Integer getPaytosee() {
		return paytosee;
	}
	/**
	 * 设置：qq登陆id
	 */
	public void setQqopenid(String qqopenid) {
		this.qqopenid = qqopenid;
	}
	/**
	 * 获取：qq登陆id
	 */
	public String getQqopenid() {
		return qqopenid;
	}
	/**
	 * 设置：微信登陆id
	 */
	public void setWeixinopenid(String weixinopenid) {
		this.weixinopenid = weixinopenid;
	}
	/**
	 * 获取：微信登陆id
	 */
	public String getWeixinopenid() {
		return weixinopenid;
	}
	/**
	 * 设置：微博的openid
	 */
	public void setWeiboopenid(String weiboopenid) {
		this.weiboopenid = weiboopenid;
	}
	/**
	 * 获取：微博的openid
	 */
	public String getWeiboopenid() {
		return weiboopenid;
	}
	/**
	 * 设置：0.不在线,1.在线
	 */
	public void setOnline(Integer online) {
		this.online = online;
	}
	/**
	 * 获取：0.不在线,1.在线
	 */
	public Integer getOnline() {
		return online;
	}
	/**
	 * 设置：最近一次上线时间
	 */
	public void setLastonlinetime(Date lastonlinetime) {
		this.lastonlinetime = lastonlinetime;
	}
	/**
	 * 获取：最近一次上线时间
	 */
	public Date getLastonlinetime() {
		return lastonlinetime;
	}
	/**
	 * 设置：最近一次下线时间
	 */
	public void setLastofflinetime(Date lastofflinetime) {
		this.lastofflinetime = lastofflinetime;
	}
	/**
	 * 获取：最近一次下线时间
	 */
	public Date getLastofflinetime() {
		return lastofflinetime;
	}
	/**
	 * 设置：在线总时间
	 */
	public void setOnlinecount(Integer onlinecount) {
		this.onlinecount = onlinecount;
	}
	/**
	 * 获取：在线总时间
	 */
	public Integer getOnlinecount() {
		return onlinecount;
	}
	/**
	 * 设置：好评率
	 */
	public void setFeedback(Double feedback) {
		this.feedback = feedback;
	}
	/**
	 * 获取：好评率
	 */
	public Double getFeedback() {
		return feedback;
	}
	/**
	 * 设置：评价条数
	 */
	public void setEvaluatecount(Integer evaluatecount) {
		this.evaluatecount = evaluatecount;
	}
	/**
	 * 获取：评价条数
	 */
	public Integer getEvaluatecount() {
		return evaluatecount;
	}
	/**
	 * 设置：合作网红(0.否,1.是)
	 */
	public void setWhcooperation(Integer whcooperation) {
		this.whcooperation = whcooperation;
	}
	/**
	 * 获取：合作网红(0.否,1.是)
	 */
	public Integer getWhcooperation() {
		return whcooperation;
	}
	/**
	 * 设置：合作网红公司的名称
	 */
	public void setWhcompany(String whcompany) {
		this.whcompany = whcompany;
	}
	/**
	 * 获取：合作网红公司的名称
	 */
	public String getWhcompany() {
		return whcompany;
	}
	public String getWhcomId() {
		return whcomId;
	}
	public void setWhcomId(String whcomId) {
		this.whcomId = whcomId;
	}
	/**
	 * 设置：未读系统消息条数
	 */
	public void setUnreadsysinfo(Integer unreadsysinfo) {
		this.unreadsysinfo = unreadsysinfo;
	}
	/**
	 * 获取：未读系统消息条数
	 */
	public Integer getUnreadsysinfo() {
		return unreadsysinfo;
	}
	/**
	 * 设置：未读动态消息条数
	 */
	public void setUnreadnewsinfo(Integer unreadnewsinfo) {
		this.unreadnewsinfo = unreadnewsinfo;
	}
	/**
	 * 获取：未读动态消息条数
	 */
	public Integer getUnreadnewsinfo() {
		return unreadnewsinfo;
	}
}
