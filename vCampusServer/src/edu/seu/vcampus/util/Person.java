/**
 * Person.java
 * @author gutingxuan
 * @version 1.0
 * 2018.8.21
 * �����û���Ϣ������
 */

package edu.seu.vcampus.util;

public class Person implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int _EcardNumber;		//һ��ͨ��
    protected int _identity;		//��ݣ�1Ϊѧ����2Ϊ����Ա
    private String _password;		//��������
    
    public Person(){
    	setEcardNumber(0);
    	setIdentity(1);
    	setPassword(null);
    }
    
    public Person(int EcardNumber, int identity, String password) {
    	setEcardNumber(EcardNumber);
    	setIdentity(identity);
    	setPassword(password);
    }
    
    //setter
    public void setEcardNumber(int EcardNumber){
    	this._EcardNumber = EcardNumber;
    }
    
    public void setIdentity(int identity) {
    	this._identity = identity;
    }
    
    public void setPassword(String password) {
    	this._password = password;
    }
    
    //getter
    public int getEcardNumber() {
    	return this._EcardNumber;
    }
    
    public int getIdentity() {
    	return this._identity;
    }
    
    public String getPassword() {
    	return this._password;
    }
}