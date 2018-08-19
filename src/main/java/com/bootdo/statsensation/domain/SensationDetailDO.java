package com.bootdo.statsensation.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 网红公司网红收益跑批信息表
 * 
 * @author lz
 * @email 1992lcg@163.com
 * @date 2018-07-18 15:37:08
 */
public class SensationDetailDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id自增长
	private Long id;
	//网红公司id
	private String whid;
	//网红公司名称
	private String whname;
	//用户id
	private Integer userid;
	//眼缘ID
	private String yyid;
	//用户昵称
	private String nickname;
	//头像地址
	private String channel;
	//视频聊天收益
	private Double expensenum;
	// 变化时间
	private Date changeTime;
	//状态 1：正常 2：停止
	private String status;
	//备注
	private String remark;

	/**
	 * 设置：id自增长
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id自增长
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：网红公司id
	 */
	public void setWhid(String whid) {
		this.whid = whid;
	}
	/**
	 * 获取：网红公司id
	 */
	public String getWhid() {
		return whid;
	}
	/**
	 * 设置：网红公司名称
	 */
	public void setWhname(String whname) {
		this.whname = whname;
	}
	/**
	 * 获取：网红公司名称
	 */
	public String getWhname() {
		return whname;
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
	 * 设置：状态 1：正常 2：停止
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1：正常 2：停止
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Double getExpensenum() {
		return expensenum;
	}
	public void setExpensenum(Double expensenum) {
		this.expensenum = expensenum;
	}
	public Date getChangeTime() {
		return changeTime;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
}
