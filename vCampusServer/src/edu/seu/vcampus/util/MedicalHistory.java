/**
 * MedicalHistory.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * ҽ����ʷ��Ϣ������
 */

package edu.seu.vcampus.util;

public class MedicalHistory implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _date;			//��������
	private String _doctorName;		//ҽ������
	private String _content;		//��������
	private String _place;			//����ص�
	
	public MedicalHistory(){}
	
	//setter and getter
	public String getDate() {
		return _date;
	}
	public void setDate(String _date) {
		this._date = _date;
	}
	public String getDoctorName() {
		return _doctorName;
	}
	public void setDoctorName(String _doctorName) {
		this._doctorName = _doctorName;
	}
	public String getContent() {
		return _content;
	}
	public void setContent(String _content) {
		this._content = _content;
	}
	public String getPlace() {
		return _place;
	}
	public void setPlace(String _place) {
		this._place = _place;
	}

}
