/**
 * BorrowBookRecord.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 借出书本信息基础类
 */
package edu.seu.vcampus.util;

import java.util.Date;

public class BorrowBookRecord implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _EcardNumber;		//借阅者一卡通号
	private String _bookNumber;		//书籍编号
	private Date _borrowTime;		//借出时间
	private String _returnTime;		//归还时间
	
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
