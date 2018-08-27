/**
 * Course.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * �γ���Ϣ������
 */

package edu.seu.vcampus.util;

public class Course implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _courseNumber;     //�γ̱��
	private String _courseName;    //�γ�����
	private double _courseCredit;  //ѧ��
	private String _courseTeacher; //��ʦ
	private String _courseTime;    //(����-��ʼ����-��������);()...
	private String _coursePlace;   //�γ̵ص� 3101->J3-101
    private String _examTime;      //����ʱ��20180809-14:00-16:00
    private String _examPlace;     //���Եص� 3101->J3-101
    private String _courseCharacter;//��
    private Boolean _state;        //��ѡ��1,ûѡ��0
    private int _max;              //�γ���������
    private int _now;			   //�γ̵�ǰ��ѡ����
    
    public Course(){
    	_state = false;
    }
    
    //setter and getter
	public int getCourseNumber() {
		return _courseNumber;
	}
	public void setCourseNumber(int _courseNumber) {
		this._courseNumber = _courseNumber;
	}
	public String getCourseName() {
		return _courseName;
	}
	public void setCourseName(String _courseName) {
		this._courseName = _courseName;
	}
	public double getCourseCredit() {
		return _courseCredit;
	}
	public void setCourseCredit(double _courseCredit) {
		this._courseCredit = _courseCredit;
	}
	public String getCourseTeacher() {
		return _courseTeacher;
	}
	public void setCourseTeacher(String _courseTeacher) {
		this._courseTeacher = _courseTeacher;
	}
	public String getCourseTime() {
		return _courseTime;
	}
	public void setCourseTime(String _courseTime) {
		this._courseTime = _courseTime;
	}
	public String getCoursePlace() {
		return _coursePlace;
	}
	public void setCoursePlace(String _coursePlace) {
		this._coursePlace = _coursePlace;
	}
	public String getExamTime() {
		return _examTime;
	}
	public void setExamTime(String _examTime) {
		this._examTime = _examTime;
	}
	public String getExamPlace() {
		return _examPlace;
	}
	public void setExamPlace(String _examPlace) {
		this._examPlace = _examPlace;
	}
	public String getCourseCharacter() {
		return _courseCharacter;
	}
	public void setCourseCharacter(String _courseCharacter) {
		this._courseCharacter = _courseCharacter;
	}
	public Boolean getState() {
		return _state;
	}
	public void setState(Boolean _state) {
		this._state = _state;
	}
	public int getMax() {
		return _max;
	}
	public void setMax(int _max) {
		this._max = _max;
	}
	public int getNow() {
		return _now;
	}
	public void setNow(int _now) {
		this._now = _now;
	}
}
