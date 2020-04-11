package com.jay.java.Sort;
/**
 * 新闻排序
 * - 标题，
 * - 点击量
 * - 时间	
 * @author jay
 *
 */

import java.util.Date;

public class RefSortNewsItem implements java.lang.Comparable<RefSortNewsItem>{
	private String title;
	private int hits;
	private Date pubTime;
	
	public RefSortNewsItem() {
		super();
	}
	public RefSortNewsItem(String title, int hits, Date pubTime) {
		super();
		this.title = title;
		this.hits = hits;
		this.pubTime = pubTime;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the hits
	 */
	public int getHits() {
		return hits;
	}
	/**
	 * @param hits the hits to set
	 */
	public void setHits(int hits) {
		this.hits = hits;
	}
	/**
	 * @return the pubTime
	 */
	public Date getPubTime() {
		return pubTime;
	}
	/**
	 * @param pubTime the pubTime to set
	 */
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}
	/*
	 * java.lang.Comparable接口
	 * 重写compareTo方法	
	 */
	@Override
	public int compareTo(RefSortNewsItem o) {
		// TODO Auto-generated method stub
		int result;
		result = -this.pubTime.compareTo(o.pubTime);
		if(0==result) {
			//点击量
			result = this.hits - o.hits;
			if(0 == result) {
				result = -this.title.compareTo(o.title);
				return result;
			}
		}
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder bd = new StringBuilder();
		bd.append("title:").append(this.title);
		bd.append(",time:").append(this.pubTime);
		bd.append(",hits:").append(this.hits).append("\n");
		
		return bd.toString();
	}
	
	
}
