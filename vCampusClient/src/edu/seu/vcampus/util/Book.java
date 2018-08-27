/**
 * Book.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 图书信息基础类
 */
package edu.seu.vcampus.util;

import java.util.ArrayList;
import java.util.Date;

public class Book implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _name;             //书籍名称
	private String _number;           //书籍编号
	private String _author;           //作者
	private String _autherCountry;    //作者国籍
	private String _publishingHouse;  //出版社
	private Date _collectDate;        //收藏时间
	private ArrayList<String> _tabs;  //标签
	private Date _borrowTime;         //借出时间
	private String _returnTime;       //归还时间
	private boolean _isAvailible;     //是否允许借出
	private String _place;
	
	public Book() {
		setName(null);
		setNumber(null);
		setAuthor(null);
		setAutherCountry(null);
		setPublishingHouse(null);
		setCollectDate(new Date());
		setTabs(new ArrayList<String>());
		setBorrowTime(new Date());
		setIsAvailible(false);
	}
	
	//setter and getter
	public String getName() {
		return _name;
	}
	
	public void setName(String _name) {
		this._name = _name;
	}
	
	public String getNumber() {
		return _number;
	}
	
	public void setNumber(String _number) {
		this._number = _number;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String _author) {
		this._author = _author;
	}

	public String getAutherCountry() {
		return _autherCountry;
	}

	public void setAutherCountry(String _autherCountry) {
		this._autherCountry = _autherCountry;
	}

	public String getPublishingHouse() {
		return _publishingHouse;
	}

	public void setPublishingHouse(String _publishingHouse) {
		this._publishingHouse = _publishingHouse;
	}

	public Date getCollectDate() {
		return _collectDate;
	}

	public void setCollectDate(Date _collectDate) {
		this._collectDate = _collectDate;
	}

	public ArrayList<String> getTabs() {
		return _tabs;
	}

	public void setTabs(ArrayList<String> _tabs) {
		this._tabs = _tabs;
	}

	public Date getBorrowTime() {
		return _borrowTime;
	}

	public void setBorrowTime(Date _borrowTime) {
		this._borrowTime = _borrowTime;
	}

	public boolean getIsAvailible() {
		return _isAvailible;
	}

	public void setIsAvailible(boolean _isAvailible) {
		this._isAvailible = _isAvailible;
	}

	public String getReturnTime() {
		return _returnTime;
	}

	public void setReturnTime(String _returnTime) {
		this._returnTime = _returnTime;
	}

	public String getPlace() {
		return _place;
	}

	public void setPlace(String _place) {
		this._place = _place;
	}
}
