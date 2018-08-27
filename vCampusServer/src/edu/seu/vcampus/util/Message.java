/**
 * Message.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * 数据传送打包类
 * ？？？
 */

package edu.seu.vcampus.util;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static public String _IP;
    private int _EcardNumber;			
    private int _type;
    private BasicInfo _basicInfo;
    private Person _person;
    private String _data;//为辅助实现功能所留的变量（图书馆借书还书的编号等）
    private ArrayList<Book> _booklist;
    private ArrayList<BorrowBookRecord> _borrowBookRecordList;
    private ArrayList<Course> _courseList;
    private ArrayList<Grade> _gradeList;
    private EcardInfo _EcardInfo;
    private ArrayList<EcardRecord> _EcardRecordList;
    private ApartmentInfo _apartmentInfo;
    // private AccountInfo _accountInfo;
    private ArrayList<ShopBasket> _shopBasketList;
    private ArrayList<Goods> _goodsList;
    private ArrayList<ShopRecord> _shopRecord;
    private ByteArray _byteArray;
    private ArrayList<ByteArray> _byteArrayList;
    private Course _course;
    private ArrayList<Clinic> _clinicList;
    private ArrayList<MedicalHistory> _medicalHistoryList;
    private ArrayList<String> _Authority;
    private int _stunum;
    private int _coursenum;
    private ArrayList<BasicInfo> _allinfo;
    private ArrayList<Course> _allcourse;
    private Goods _good;
    private Book _book;
    private ArrayList<Book> _allbook;
    private int _booknum;
    private ArrayList<String> _stringList;
    
    public Message() {
    	_basicInfo = new BasicInfo();
    	_booklist = new ArrayList<Book>();
    	_courseList = new ArrayList<Course>();
    	_EcardInfo = new EcardInfo();
    	setApartmentInfo(new ApartmentInfo());
    	setGradeList(new ArrayList<Grade>());
    	//_accountInfo = new AccountInfo();
    	setGoodsList(new ArrayList<Goods>());
    	_shopBasketList = new ArrayList<ShopBasket>();
    	_shopRecord = new ArrayList<ShopRecord>();
    	_borrowBookRecordList = new ArrayList<BorrowBookRecord>();
    	setByteArray(new ByteArray());
    	_byteArrayList = new ArrayList<ByteArray>();
    	_EcardRecordList = new ArrayList<EcardRecord>();
    	_clinicList = new ArrayList<Clinic>();
    	setMedicalHistoryList(new ArrayList<MedicalHistory>());
    	_Authority = new ArrayList<String>();
    	_stringList = new ArrayList<String>();
    }
    
    public Message(int Ecard) {
    	_EcardNumber = Ecard;
    	_basicInfo = new BasicInfo();
    	_booklist = new ArrayList<Book>();
    	_courseList = new ArrayList<Course>();
    	_EcardInfo = new EcardInfo();
    	setApartmentInfo(new ApartmentInfo());
    	setGradeList(new ArrayList<Grade>());
    	//_accountInfo = new AccountInfo();
    	setGoodsList(new ArrayList<Goods>());
    	_shopBasketList = new ArrayList<ShopBasket>();
    	_shopRecord = new ArrayList<ShopRecord>();
    	_borrowBookRecordList = new ArrayList<BorrowBookRecord>();
    	setByteArray(new ByteArray());
    	_byteArrayList = new ArrayList<ByteArray>();
    	_EcardRecordList = new ArrayList<EcardRecord>();
    	_clinicList = new ArrayList<Clinic>();
    	setMedicalHistoryList(new ArrayList<MedicalHistory>());
    	_Authority = new ArrayList<String>();
    	_stringList = new ArrayList<String>();
    }
    
    //setter and getter
    public void setEcardNumber(int data){
    	this._EcardNumber = data;
    }
    
    public int getEcardNumber(){
    	return _EcardNumber;
    }
    
    public void setType(int data){
    	this._type = data;
    }
    
    public int getType(){
    	return _type;
    }
    
    public void setBasicInfo(BasicInfo data){
    	this._basicInfo = data;
    }
    public BasicInfo getBasicInfo(){
    	return _basicInfo;
    }
    
    public void setPerson(Person data){
    	this._person =  data;
    }
    
    public Person getPerson(){
    	return _person;
    }

	public String getData() {
		return _data;
	}

	public void setData(String _data) {
		this._data = _data;
	}

	public ArrayList<Book> getBooklist() {
		return _booklist;
	}

	public void setBooklist(ArrayList<Book> _booklist) {
		this._booklist = _booklist;
	}

	public ArrayList<Course> getCourseList() {
		return _courseList;
	}

	public void setCourseList(ArrayList<Course> _courseList) {
		this._courseList = _courseList;
	}

	public ArrayList<Grade>  getGradeList() {
		return _gradeList;
	}

	public void setGradeList(ArrayList<Grade>  _gradeList) {
		this._gradeList = _gradeList;
	}

	public EcardInfo getEcardInfo() {
		return _EcardInfo;
	}

	public void setEcardInfo(EcardInfo _EcardInfo) {
		this._EcardInfo = _EcardInfo;
	}

	public ArrayList<EcardRecord> getEcardRecordList() {
		return _EcardRecordList;
	}

	public void setEcardRecordList(ArrayList<EcardRecord> _EcardRecordList) {
		this._EcardRecordList = _EcardRecordList;
	}

	public ApartmentInfo getApartmentInfo() {
		return _apartmentInfo;
	}

	public void setApartmentInfo(ApartmentInfo _apartmentInfo) {
		this._apartmentInfo = _apartmentInfo;
	}

	public ArrayList<ShopBasket> getShopbasketList() {
		return _shopBasketList;
	}

	public void setShopbasketList(ArrayList<ShopBasket> _shopBasketList) {
		this._shopBasketList = _shopBasketList;
	}

	public ArrayList<Goods> getGoodsList() {
		return _goodsList;
	}

	public void setGoodsList(ArrayList<Goods> _goodsList) {
		this._goodsList = _goodsList;
	}

	public ArrayList<ShopRecord> getShopRecord() {
		return _shopRecord;
	}

	public void setShopRecord(ArrayList<ShopRecord> _shopRecord) {
		this._shopRecord = _shopRecord;
	}

	public ArrayList<BorrowBookRecord> getBorrowBookRecordList() {
		return _borrowBookRecordList;
	}

	public void setBorrowBookRecordList(ArrayList<BorrowBookRecord> _borrowBookRecordList) {
		this._borrowBookRecordList = _borrowBookRecordList;
	}

	public ByteArray getByteArray() {
		return _byteArray;
	}

	public void setByteArray(ByteArray _byteArray) {
		this._byteArray = _byteArray;
	}

	public ArrayList<ByteArray> getByteArrayList() {
		return _byteArrayList;
	}

	public void setByteArrayList(ArrayList<ByteArray> _byteArrayList) {
		this._byteArrayList = _byteArrayList;
	}

	public Course getCourse() {
		return _course;
	}

	public void setCourse(Course _course) {
		this._course = _course;
	}

	public ArrayList<Clinic> getClinicList() {
		return _clinicList;
	}

	public void setClinicList(ArrayList<Clinic> _clinicList) {
		this._clinicList = _clinicList;
	}

	public ArrayList<MedicalHistory> getMedicalHistoryList() {
		return _medicalHistoryList;
	}

	public void setMedicalHistoryList(ArrayList<MedicalHistory> _medicalHistoryList) {
		this._medicalHistoryList = _medicalHistoryList;
	}

	public ArrayList<String> getAuthority() {
		return _Authority;
	}

	public void setAuthority(ArrayList<String> _Authority) {
		this._Authority = _Authority;
	}
    
	/*
	 * for admin part
	 */
	
	public void setbook(Book book){
    	this._book = book;
    }
    
    public Book getbook(){
    	return this._book;
    }
    
    public void setgood(Goods good){
    	this._good = good;
    }
    
    public Goods getgood(){
    	return this._good;
    }
    
    public void setCoursenum(ArrayList<Course> a){
    	this._coursenum = a.size();
    }
    
    public int getCoursenum(){
    	return this._coursenum;
    }
    
    public void setStudentnum(ArrayList<BasicInfo> a){
    	this._stunum = a.size();
    }
    
    public int getStudentnum(){
    	return this._stunum;
    }
    
    public void setAllInfo(ArrayList<BasicInfo> ab){
    	this._allinfo = ab;
    }
    
    public ArrayList<BasicInfo> getAllInfo(){
    	return this._allinfo;
    }
    
    public ArrayList<Course> getAllCourse(){
    	return this._allcourse;
    }
    
    public void setAllCourse(ArrayList<Course> c){
    	this._allcourse = c;
    }
    
    public void setbooknum(int num){
    	this._booknum = num;
    }
    
    public int getbooknum(){
    	return this._booknum;
    }
    
    public void setAllBook(ArrayList<Book> mybook){
    	this._allbook = mybook;
    }
    
    public ArrayList<Book> getAllBook(){
    	return this._allbook;
    }
	public ArrayList<String> getStringList() {
		return _stringList;
	}

	public void setStringList(ArrayList<String> _stringList) {
		this._stringList = _stringList;
	}

	public String getIP() {
		return _IP;
	}
}
