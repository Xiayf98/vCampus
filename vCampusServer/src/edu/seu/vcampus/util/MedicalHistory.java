/**
 * MedicalHistory.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 医疗历史信息基础类
 */

package edu.seu.vcampus.util;

public class MedicalHistory implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _date;			//就诊日期
	private String _doctorName;		//医生名字
	private String _content;		//就诊内容
	private String _place;			//就诊地点
	
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
