/**
 * Clinic.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * ҽԺ��Ϣ������
 */

package edu.seu.vcampus.util;

public class Clinic implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _doctorName;		//ҽ������
	private String _clinicName;		//ҽԺ����
	private String _clinicPlace;	//ҽԺ��ַ
	private String _clinicTime;		//����ʱ��
	
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
