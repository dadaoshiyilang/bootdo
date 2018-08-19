package com.bootdo.review.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-12 14:17:28
 */
public class AuthenticationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private Long id;
	//用户id
	private Integer userid;
	//认证图片1
	private String authpic1;
	//认证图片2
	private String authpic2;
	//认证状态(0.认证失败,1.认证成功,2.认证中)
	private Integer authstatus;
	//创建时间
	private Date createtime;
	//修改时间
	private Date updatetime;
	//有效标记
	private Integer del;
	private String usersex;
	private String portraiturl;
	private String yyid;
	private String nickname;

	/**
	 * 设置：主键id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Long getId() {
		return id;
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
	 * 设置：认证图片1
	 */
	public void setAuthpic1(String authpic1) {
		this.authpic1 = authpic1;
	}
	/**
	 * 获取：认证图片1
	 */
	public String getAuthpic1() {
		return authpic1;
	}
	/**
	 * 设置：认证图片2
	 */
	public void setAuthpic2(String authpic2) {
		this.authpic2 = authpic2;
	}
	/**
	 * 获取：认证图片2
	 */
	public String getAuthpic2() {
		return authpic2;
	}
	/**
	 * 设置：认证状态(0.认证失败,1.认证成功,2.认证中)
	 */
	public void setAuthstatus(Integer authstatus) {
		this.authstatus = authstatus;
	}
	/**
	 * 获取：认证状态(0.认证失败,1.认证成功,2.认证中)
	 */
	public Integer getAuthstatus() {
		return authstatus;
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
	 * 设置：有效标记
	 */
	public void setDel(Integer del) {
		this.del = del;
	}
	/**
	 * 获取：有效标记
	 */
	public Integer getDel() {
		return del;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getPortraiturl() {
		return portraiturl;
	}
	public void setPortraiturl(String portraiturl) {
		this.portraiturl = portraiturl;
	}
	public String getYyid() {
		return yyid;
	}
	public void setYyid(String yyid) {
		this.yyid = yyid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
