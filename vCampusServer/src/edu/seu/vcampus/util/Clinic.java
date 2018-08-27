/**
 * Clinic.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 医院信息基础类
 */

package edu.seu.vcampus.util;

public class Clinic implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _doctorName;		//医生名称
	private String _clinicName;		//医院名称
	private String _clinicPlace;	//医院地址
	private String _clinicTime;		//就诊时间
	
	public Clinic() {}
	public String getDoctorName() {
		return _doctorName;
	}
	public void setDoctorName(String _doctorName) {
		this._doctorName = _doctorName;
	}
	public String getClinicName() {
		return _clinicName;
	}
	public void setClinicName(String _clinicName) {
		this._clinicName = _clinicName;
	}
	public String getClinicPlace() {
		return _clinicPlace;
	}
	public void setClinicPlace(String _clinicPlace) {
		this._clinicPlace = _clinicPlace;
	}
	public String getClinicTime() {
		return _clinicTime;
	}
	public void setClinicTime(String _clinicTime) {
		this._clinicTime = _clinicTime;
	}
}
