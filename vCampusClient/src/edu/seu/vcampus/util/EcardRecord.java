/**
 * EcardRecord.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * һ��ͨ������Ϣ������
 */
package edu.seu.vcampus.util;

import java.util.Date;

public class EcardRecord implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _content;	//��������
	private Date _date;			//��������
	private double _money;		//���׽��
	private double _balance;	//�������
		
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
