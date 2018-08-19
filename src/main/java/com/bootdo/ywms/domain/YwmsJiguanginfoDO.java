package com.bootdo.ywms.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fff
 * @email 1992lcg@163.com
 * @date 2018-07-23 10:02:23
 */
public class YwmsJiguanginfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private Long id;
	//推送给的用户id
	private Long touserid;
	//昵称
	private String nickname;
	//头像
	private String portraiturl;
	//动态封面
	private String thumbnailurl;
	//动态id
	private Long newsid;
	//消息类型(1.系统消息,2.动态,3.)
	private Integer type;
	//消息类型(例如"评论动态")
	private String infotype;
	//动态类型(1.图片,2.视频)
	private Integer datatype;
	//购买所获的缘币
	private Integer yuanbi;
	//评论id
	private Long commentid;
	//评论内容
	private String commentcontext;
	//时间
	private Date createtime;
	//删除标记
	private Integer del;

	//批量发送信息的用户的id
	private String userids;


	private String choose;

	public String getUserids() {
		return userids;
	}

	public void setUserids(String userids) {
		this.userids = userids;
	}

	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

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
	 * 设置：推送给的用户id
	 */
	public void setTouserid(Long touserid) {
		this.touserid = touserid;
	}
	/**
	 * 获取：推送给的用户id
	 */
	public Long getTouserid() {
		return touserid;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：头像
	 */
	public void setPortraiturl(String portraiturl) {
		this.portraiturl = portraiturl;
	}
	/**
	 * 获取：头像
	 */
	public String getPortraiturl() {
		return portraiturl;
	}
	/**
	 * 设置：动态封面
	 */
	public void setThumbnailurl(String thumbnailurl) {
		this.thumbnailurl = thumbnailurl;
	}
	/**
	 * 获取：动态封面
	 */
	public String getThumbnailurl() {
		return thumbnailurl;
	}
	/**
	 * 设置：动态id
	 */
	public void setNewsid(Long newsid) {
		this.newsid = newsid;
	}
	/**
	 * 获取：动态id
	 */
	public Long getNewsid() {
		return newsid;
	}
	/**
	 * 设置：消息类型(1.系统消息,2.动态,3.)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：消息类型(1.系统消息,2.动态,3.)
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：消息类型(例如"评论动态")
	 */
	public void setInfotype(String infotype) {
		this.infotype = infotype;
	}
	/**
	 * 获取：消息类型(例如"评论动态")
	 */
	public String getInfotype() {
		return infotype;
	}
	/**
	 * 设置：动态类型(1.图片,2.视频)
	 */
	public void setDatatype(Integer datatype) {
		this.datatype = datatype;
	}
	/**
	 * 获取：动态类型(1.图片,2.视频)
	 */
	public Integer getDatatype() {
		return datatype;
	}
	/**
	 * 设置：购买所获的缘币
	 */
	public void setYuanbi(Integer yuanbi) {
		this.yuanbi = yuanbi;
	}
	/**
	 * 获取：购买所获的缘币
	 */
	public Integer getYuanbi() {
		return yuanbi;
	}
	/**
	 * 设置：评论id
	 */
	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}
	/**
	 * 获取：评论id
	 */
	public Long getCommentid() {
		return commentid;
	}
	/**
	 * 设置：评论内容
	 */
	public void setCommentcontext(String commentcontext) {
		this.commentcontext = commentcontext;
	}
	/**
	 * 获取：评论内容
	 */
	public String getCommentcontext() {
		return commentcontext;
	}
	/**
	 * 设置：时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：删除标记
	 */
	public void setDel(Integer del) {
		this.del = del;
	}
	/**
	 * 获取：删除标记
	 */
	public Integer getDel() {
		return del;
	}
}
