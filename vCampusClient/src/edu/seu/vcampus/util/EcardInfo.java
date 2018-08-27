/**
 * EcardInfo.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 一卡通信息基础类
 */

package edu.seu.vcampus.util;

public class EcardInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _state;  		// 1为正常,2为挂失中，3为被冻结
	private double _balance;	//余额
	
	public EcardInfo() {
		setState(1);
	}
	
	//setter and getter
	public int getState() {
		return _state;
	}

	public void setState(int _state) {
		this._state = _state;
	}

	public double getBalance() {
		return _balance;
	}

	public void setBalance(double _balance) {
		this._balance = _balance;
	}
	
	public void changeBalance(double money) {
		if (_state == 1)
			this._balance += money;
	}
}
