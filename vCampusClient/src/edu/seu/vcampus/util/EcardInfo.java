/**
 * EcardInfo.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * һ��ͨ��Ϣ������
 */

package edu.seu.vcampus.util;

public class EcardInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _state;  		// 1Ϊ����,2Ϊ��ʧ�У�3Ϊ������
	private double _balance;	//���
	
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
