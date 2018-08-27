/**
 * Grade.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 成绩信息基础类
 */
package edu.seu.vcampus.util;

public class Grade implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _grade;				//？
	private int _courseNumber;		//课程编号
	private int _EcardNumber;		//一卡通编号
	private String _courseSemeter;	//课程学期
	private String _gradeCharacter;	//？
	
	//setter and getter
	public int getGrade() {
		return _grade;
	}
	public void setGrade(int grade) {
		this._grade = grade;
	}
	public int getCourseNumber() {
		return _courseNumber;
	}
	public void setCourseNumber(int gradeNumber) {
		this._courseNumber = gradeNumber;
	}
	public int getEcardNumber() {
		return _EcardNumber;
	}
	public void setEcardNumber(int EcardNumber) {
		this._EcardNumber = EcardNumber;
	}
	public String getCourseSemeter() {
		return _courseSemeter;
	}
	public void setCourseSemeter(String _courseSemeter) {
		this._courseSemeter = _courseSemeter;
	}
	public String getGradeCharacter() {
		return _gradeCharacter;
	}
	public void setGradeCharacter(String _gradeCharacter) {
		this._gradeCharacter = _gradeCharacter;
	}	
}
