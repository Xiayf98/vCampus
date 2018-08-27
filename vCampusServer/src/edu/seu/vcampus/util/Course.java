/**
 * Course.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 课程信息基础类
 */

package edu.seu.vcampus.util;

public class Course implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _courseNumber;     //课程编号
	private String _courseName;    //课程名称
	private double _courseCredit;  //学分
	private String _courseTeacher; //讲师
	private String _courseTime;    //(星期-开始节数-结束节数);()...
	private String _coursePlace;   //课程地点 3101->J3-101
    private String _examTime;      //考试时间20180809-14:00-16:00
    private String _examPlace;     //考试地点 3101->J3-101
    private String _courseCharacter;//？
    private Boolean _state;        //已选是1,没选是0
    private int _max;              //课程人数上限
    private int _now;			   //课程当前已选人数
    
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
