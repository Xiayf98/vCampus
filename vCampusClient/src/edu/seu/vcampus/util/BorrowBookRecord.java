/**
 * BorrowBookRecord.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * ����鱾��Ϣ������
 */
package edu.seu.vcampus.util;

import java.util.Date;

public class BorrowBookRecord implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _EcardNumber;		//������һ��ͨ��
	private String _bookNumber;		//�鼮���
	private Date _borrowTime;		//���ʱ��
	private String _returnTime;		//�黹ʱ��
	
	//setter and getter
	public int getEcardNumber() {
		return _EcardNumber;
	}
	public void setEcardNumber(int _EcardNumber) {
		this._EcardNumber = _EcardNumber;
	}
	public String getBookNumber() {
		return _bookNumber;
	}
	public void setBookNumber(String _bookNumber) {
		this._bookNumber = _bookNumber;
	}
	public Date getBorrowTime() {
		return _borrowTime;
	}
	public void setBorrowTime(Date _borrowTime) {
		this._borrowTime = _borrowTime;
	}
	public String getReturnTime() {
		return _returnTime;
	}
	public void setReturnTime(String _returnTime) {
		this._returnTime = _returnTime;
	}
}
