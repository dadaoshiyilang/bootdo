package com.bootdo.review.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lz
 * @date 2018-07-04 13:44:49
 */
public class NewsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//动态id(专辑id)
	private Integer newsid;
	//发送人id
	private Integer userid;
	//眼缘id
	private String yyid;
	//昵称
	private String nickname;
	//头像
	private String portraiturl;
	//类型(1.图片2.视频)
	private String datatype;
	//动态描述
	private String remark;
	//该动态免费查看的张数
	private Integer freetolook;
	//查看剩下的需要的付费(缘豆)
	private Integer costtolook;
	//动态标签
	private String newstags;
	//动态内容(封面图片地址)
	private String newsinfo;
	//该动态的图片数量
	private Integer size;
	//封面图的宽高比
	private String thumbrate;
	//封面图地址
	private String thumbnailurl;
	//发动态时所在地址
	private String newsloc;
	//点赞数
	private Integer likecount;
	//动态被收藏数
	private Integer favocount;
	//播放数
	private Integer playcount;
	//评论数
	private Integer commentcount;
	//创建时间
	private Date createtime;
	//修改时间
	private Date updatetime;
	//有效标记
	private String deleteflag;
	//100.合法,101.违规类型99处理中
	private Integer illegaltype;
	//
	private String longitude;
	//
	private String latitude;
	//
	private String dataurl;

	/**
	 * 设置：动态id(专辑id)
	 */
	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}
	/**
	 * 获取：动态id(专辑id)
	 */
	public Integer getNewsid() {
		return newsid;
	}
	/**
	 * 设置：发送人id
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：发送人id
	 */
	public Integer getUserid() {
		return userid;
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
	 * 设置：类型(1.图片2.视频)
	 */
	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}
	/**
	 * 获取：类型(1.图片2.视频)
	 */
	public String getDatatype() {
		return datatype;
	}
	/**
	 * 设置：动态描述
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：动态描述
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：该动态免费查看的张数
	 */
	public void setFreetolook(Integer freetolook) {
		this.freetolook = freetolook;
	}
	/**
	 * 获取：该动态免费查看的张数
	 */
	public Integer getFreetolook() {
		return freetolook;
	}
	/**
	 * 设置：查看剩下的需要的付费(缘豆)
	 */
	public void setCosttolook(Integer costtolook) {
		this.costtolook = costtolook;
	}
	/**
	 * 获取：查看剩下的需要的付费(缘豆)
	 */
	public Integer getCosttolook() {
		return costtolook;
	}
	/**
	 * 设置：动态标签
	 */
	public void setNewstags(String newstags) {
		this.newstags = newstags;
	}
	/**
	 * 获取：动态标签
	 */
	public String getNewstags() {
		return newstags;
	}
	/**
	 * 设置：动态内容(封面图片地址)
	 */
	public void setNewsinfo(String newsinfo) {
		this.newsinfo = newsinfo;
	}
	/**
	 * 获取：动态内容(封面图片地址)
	 */
	public String getNewsinfo() {
		return newsinfo;
	}
	/**
	 * 设置：该动态的图片数量
	 */
	public void setSize(Integer size) {
		this.size = size;
	}
	/**
	 * 获取：该动态的图片数量
	 */
	public Integer getSize() {
		return size;
	}
	/**
	 * 设置：封面图的宽高比
	 */
	public void setThumbrate(String thumbrate) {
		this.thumbrate = thumbrate;
	}
	/**
	 * 获取：封面图的宽高比
	 */
	public String getThumbrate() {
		return thumbrate;
	}
	/**
	 * 设置：封面图地址
	 */
	public void setThumbnailurl(String thumbnailurl) {
		this.thumbnailurl = thumbnailurl;
	}
	/**
	 * 获取：封面图地址
	 */
	public String getThumbnailurl() {
		return thumbnailurl;
	}
	/**
	 * 设置：发动态时所在地址
	 */
	public void setNewsloc(String newsloc) {
		this.newsloc = newsloc;
	}
	/**
	 * 获取：发动态时所在地址
	 */
	public String getNewsloc() {
		return newsloc;
	}
	/**
	 * 设置：点赞数
	 */
	public void setLikecount(Integer likecount) {
		this.likecount = likecount;
	}
	/**
	 * 获取：点赞数
	 */
	public Integer getLikecount() {
		return likecount;
	}
	/**
	 * 设置：动态被收藏数
	 */
	public void setFavocount(Integer favocount) {
		this.favocount = favocount;
	}
	/**
	 * 获取：动态被收藏数
	 */
	public Integer getFavocount() {
		return favocount;
	}
	/**
	 * 设置：播放数
	 */
	public void setPlaycount(Integer playcount) {
		this.playcount = playcount;
	}
	/**
	 * 获取：播放数
	 */
	public Integer getPlaycount() {
		return playcount;
	}
	/**
	 * 设置：评论数
	 */
	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getCommentcount() {
		return commentcount;
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
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	/**
	 * 获取：有效标记
	 */
	public String getDeleteflag() {
		return deleteflag;
	}
	/**
	 * 设置：100.合法,101.违规类型99处理中
	 */
	public void setIllegaltype(Integer illegaltype) {
		this.illegaltype = illegaltype;
	}
	/**
	 * 获取：100.合法,101.违规类型99处理中
	 */
	public Integer getIllegaltype() {
		return illegaltype;
	}
	/**
	 * 设置：
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：
	 */
	public String getLatitude() {
		return latitude;
	}
	public String getYyid() {
		return yyid;
	}
	public void setYyid(String yyid) {
		this.yyid = yyid;
	}
	public String getDataurl() {
		return dataurl;
	}
	public void setDataurl(String dataurl) {
		this.dataurl = dataurl;
	}
}
