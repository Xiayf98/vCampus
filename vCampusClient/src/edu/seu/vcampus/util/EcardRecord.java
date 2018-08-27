/**
 * EcardRecord.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 一卡通交易信息基础类
 */
package edu.seu.vcampus.util;

import java.util.Date;

public class EcardRecord implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _content;	//交易内容
	private Date _date;			//交易日期
	private double _money;		//交易金额
	private double _balance;	//卡内余额
		
	public EcardRecord() {
		setDate(new Date());
	}
	
	//setter and getter
	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		this._content = content;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		this._date = date;
	}

	public double getmoney() {
		return _money;
	}

	public void setmoney(double money) {
		this._money = money;
	}

	public double getBalance() {
		return _balance;
	}

	public void setBalance(double balance) {
		this._balance = balance;
	}
}
