/**
 * BasicInfoTab.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * ������Ϣ������
 */

package edu.seu.vcampus.util;

import java.util.Date;

public class BasicInfo implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _EcardNumber;      //һ��ͨ��
	private String _nameString;	   //��������
	private String _nameSpelling;  //����ƴ��
	private String _birthday;        //��������
	private String _IDNumber;      //���֤��
	private String _sNumber;       //ѧ�Ż�ְ����
	private int _gender;       	   //�Ա� 0Ϊ��,1ΪŮ
	private String _picturePath;   //��Ƭ
	private String _school;        //Ժϵ
	private String _major;         //רҵ
	private String _Email;         //����
	private String _telephone;     //�绰����
	private String _homeAddress;   //��ͥסַ
	private int _identity;		   //��ݣ�1Ϊѧ����2Ϊ����Ա
	
	public BasicInfo() {
		setEcardNumber(0);
		setNameSpelling(null);
		setBirthday(null);
		setIDNumber(null);
		setSNumber(null);
		setGender(0);
		setPicturePath(null);
		setSchool(null);
		setMajor(null);
		setEmail(null);
		setIdentity(1);
	}
	
	//setter
	public void setEcardNumber(int _EcardNumber) {
		this._EcardNumber = _EcardNumber;
	}
	
	public void setNameSpelling(String _nameSpelling) {
		this._nameSpelling = _nameSpelling;
	}
	
	public void setNameString(String _nameString) {
		this._nameString = _nameString;
	}
	
	public void setBirthday(String _birthday) {
		this._birthday = _birthday;
	}
	
	public void setIDNumber(String _IDNumber) {
		this._IDNumber = _IDNumber;
	}
	
	public void setSNumber(String _sNumber) {
		this._sNumber = _sNumber;
	}
	
	public void setGender(int _gender) {
		this._gender = _gender;
	}
	
	public void setPicturePath(String _picturePath) {
		this._picturePath = _picturePath;
	}
	
	public void setSchool(String _school) {
		this._school = _school;
	}
	
	public void setMajor(String _major) {
		this._major = _major;
	}
	
	public void setEmail(String _Email) {
		this._Email = _Email;
	}
	
	public void setTelephone(String _telephone) {
		this._telephone = _telephone;
	}
	
	public void setHomeAddress(String _homeAddress) {
		this._homeAddress = _homeAddress;
	}
	
	public void setIdentity(int _identity) {
		this._identity = _identity;
	}
	
	//getter
	public int getEcardNumber() {
		return _EcardNumber;
	}
	
	public String getNameSpelling() {
		return _nameSpelling;
	}
	
	public String getNameString() {
		return _nameString;
	}
	
	public String getBirthday() {
		return _birthday;
	}
	
	public String getIDNumber() {
		return _IDNumber;
	}
	
	public String getSNumber() {
		return _sNumber;
	}
	
	public int getGender() {
		return _gender;
	}
	
	public String getPicturePath() {
		return _picturePath;
	}
	
	public String getSchool() {
		return _school;
	}
	
	public String getMajor() {
		return _major;
	}
	
	public String getEmail() {
		return _Email;
	}

	public String getTelephone() {
		return _telephone;
	}

	public String getHomeAddress() {
		return _homeAddress;
	}

	public int getIdentity() {
		return _identity;
	}
}
