/**
 * ShopRecord.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * �����¼��Ϣ������
 */

package edu.seu.vcampus.util;

import java.util.Date;

public class ShopRecord  implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _EcardNumber;		//һ��ͨ��
	private int _GoodsID;			//��Ʒ���
	private int _GoodsNumber;		//��Ʒ����
	private Date _time;				//��������
	
	//setter and getter
	public int getEcardNumber() {
		return _EcardNumber;
	}
	public void setEcardNumber(int _EcardNumber) {
		this._EcardNumber = _EcardNumber;
	}
	public int getGoodsID() {
		return _GoodsID;
	}
	public void setGoodsID(int _GoodsID) {
		this._GoodsID = _GoodsID;
	}
	public int getGoodsNumber() {
		return _GoodsNumber;
	}
	public void setGoodsNumber(int _GoodsNumber) {
		this._GoodsNumber = _GoodsNumber;
	}
	public Date getTime() {
		return _time;
	}
	public void setTime(Date _time) {
		this._time = _time;
	}
}
