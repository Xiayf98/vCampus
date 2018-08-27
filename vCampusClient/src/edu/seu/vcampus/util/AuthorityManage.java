/**
 * AuthorityManage.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * ����Ȩ����Ϣ������
 */

package edu.seu.vcampus.util;

public class AuthorityManage implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _EcardNumber;            //һ��ͨ��
	private boolean _bookAuthority;      //ͼ�����Ȩ��
	private boolean _bankAuthority;      //���й���Ȩ��
	private boolean _courseAuthority;    //�γ̹���Ȩ��
	private boolean _medicionAuthority;  //ҽ�ƹ���Ȩ��
	private boolean _storeAuthority;     //�̵����Ȩ��
	private boolean _dormitoryAuthority; //�������Ȩ��
	
	public AuthorityManage() {
		setEcardNumber(0);
		setBookAuthority(false);
		setBankAuthority(false);
		setCourseAuthority(false);
		setMedicionAuthority(false);
		setStoreAuthority(false);
		setDormitoryAuthority(false);
	}
	
	//setter and getter
	public boolean getBookAuthority() {
		return _bookAuthority;
	}
	public void setBookAuthority(boolean bookAuthority) {
		this._bookAuthority = bookAuthority;
	}
	public boolean getBankAuthority() {
		return _bankAuthority;
	}
	public void setBankAuthority(boolean bankAuthority) {
		this._bankAuthority = bankAuthority;
	}
	public boolean getCourseAuthority() {
		return _courseAuthority;
	}
	public void setCourseAuthority(boolean courseAuthority) {
		this._courseAuthority = courseAuthority;
	}
	public boolean getMedicionAuthority() {
		return _medicionAuthority;
	}
	public void setMedicionAuthority(boolean medicionAuthority) {
		this._medicionAuthority = medicionAuthority;
	}
	public boolean getStoreAuthority() {
		return _storeAuthority;
	}
	public void setStoreAuthority(boolean storeAuthority) {
		this._storeAuthority = storeAuthority;
	}
	public boolean get_dormitoryAuthority() {
		return _dormitoryAuthority;
	}
	public void setDormitoryAuthority(boolean dormitoryAuthority) {
		this._dormitoryAuthority = dormitoryAuthority;
	}
	public int getEcardNumber() {
		return _EcardNumber;
	}
	public void setEcardNumber(int _EcardNumber) {
		this._EcardNumber = _EcardNumber;
	}
}
