/**
 * ShopBasket.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * ���ﳵ��Ϣ������
 */

package edu.seu.vcampus.util;

public class ShopBasket implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _goodID;		//��Ʒ���
	private int _goodNumber;	//��Ʒ����
	
	//setter and getter
	public int getGoodID() {	
		return _goodID;
	}
	public void setGoodID(int _goodID) {
		this._goodID = _goodID;
	}
	public int getGoodNumber() {
		return _goodNumber;
	}
	public void setGoodNumber(int _goodNumber) {
		this._goodNumber = _goodNumber;
	}
}
