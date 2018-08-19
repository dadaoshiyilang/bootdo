package com.bootdo.system.domain;

import java.io.Serializable;



/**
 * 支付管理表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-26 15:09:27
 */
public class PayInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//支付名称
	private String payname;
	//支付标识
	private String payType;
	//支付标识
	private String payFlag;


	//状态  -1：停用  0：使用中
	private String status;
	//是否删除  -1：已删除  0：正常
	private String delFlag;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	/**
	 * 设置：支付名称
	 */
	public void setPayname(String payname) {
		this.payname = payname;
	}
	/**
	 * 获取：支付名称
	 */
	public String getPayname() {
		return payname;
	}
	/**
	 * 设置：支付标识
	 */
	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}
	/**
	 * 获取：支付标识
	 */
	public String getPayFlag() {
		return payFlag;
	}
	/**
	 * 设置：状态  -1：停用  0：使用中
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态  -1：停用  0：使用中
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：是否删除  -1：已删除  0：正常
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除  -1：已删除  0：正常
	 */
	public String getDelFlag() {
		return delFlag;
	}
}
