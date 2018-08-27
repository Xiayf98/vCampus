/**
 * ApartmentInfo.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * ������Ϣ������
 */
package edu.seu.vcampus.util;

import java.util.ArrayList;

public class ApartmentInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _position;  			//����ţ� M1-319
	private ArrayList<Integer> _grade;	//�꼶
	private ArrayList<Integer> _liveFee;//ס�޷�
	private int _EcardNumber;			//һ��ͨ��
	private int _ID;					//��
	
	//setter
	public void setID(int ID){
		this._ID = ID;
	}
	
	public void setEcardNumber(int num){
		this._EcardNumber = num;
	}
	
	public void setPosition(String _position) {
		this._position = _position;
	}
	
	public void setLiveFee(ArrayList<Integer> _liveFee) {
		this._liveFee = _liveFee;
	}
	
	public void setGrade(ArrayList<Integer> _grade) {
		this._grade = _grade;
	}
	
	//getter
	public int getID(){
		return this._ID;
	}

	public int getEcardNumber(){
		return this._EcardNumber;
	}
	
	public String getPosition() {
		return _position;
	}
	
	public ArrayList<Integer> getGrade() {
		return _grade;
	}
	
	public ArrayList<Integer> getLiveFee() {
		return _liveFee;
	}	
}
