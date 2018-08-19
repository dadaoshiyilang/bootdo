package com.bootdo.ywms.domain;

import java.io.Serializable;


/**
 * 
 * 极光推送(充值)
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-05 15:03:23
 */
public class YwmsJgDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//发送给的id
	private Integer touserid;
	//发送类型
	private Integer type;
	//发送内容
	private String commentcontext;


	public Integer getTouserid() {
		return touserid;
	}

	public void setTouserid(Integer touserid) {
		this.touserid = touserid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCommentcontext() {
		return commentcontext;
	}

	public void setCommentcontext(String commentcontext) {
		this.commentcontext = commentcontext;
	}
}
