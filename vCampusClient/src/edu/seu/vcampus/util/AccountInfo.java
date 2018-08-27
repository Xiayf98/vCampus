/**
 * AccountInfo.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 购物账号信息基础类
 * ？？？
 */

package edu.seu.vcampus.util;

public class AccountInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _score;
	private String _address;
	
	public int getScore() {
		return _score;
	}
	public void setScore(int _score) {
		this._score = _score;
	}
	public String getAddress() {
		return _address;
	}
	public void setAddress(String _address) {
		this._address = _address;
	}
}