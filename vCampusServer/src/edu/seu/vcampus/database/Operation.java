/**
 * Operation.java
 * �ͻ������ݿ������
 * �����������ֲ�����Ӧ�ĺ�������Щ�������ǵ���DataBase
 * �������ݿ�Ĳ���
 * @author gutingxuan
 * @version 2.0
 * ʵ��ע��͵�¼����
 * 2018.8.23
 */
package edu.seu.vcampus.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.seu.vcampus.util.BasicInfo;
import edu.seu.vcampus.util.Message;
import edu.seu.vcampus.util.Person;

public class Operation {
	private PreparedStatement stmt = null;
	private BasicInfo info;
	
	public int Login(Connection conn, Message message) {
		int Ecard = message.getPerson().getEcardNumber();
		int statecode = 0;
		String password = message.getPerson().getPassword();
		try{
			  //��ѯ����
			  stmt = conn.prepareStatement("select password,identity,nameString from BasicInfo where EcardNumber  = ?");
			  System.out.println(Ecard);
			  System.out.println(message.getPerson().getPassword());
			  
			  //ռλ������Ϊ��ǰһ��ͨ��
			  stmt.setInt(1, Ecard);
			  
			  //����������ʹ�ÿ�ʼ����select����
			  ResultSet re = stmt.executeQuery();
			  re.next();
			
			  //1����password��2����identity��3����nameString��������˳����ͬ
			  //�ж������Ƿ�һ��
			  if (re.getString(1).equals(password)){
				  	//���ص�ǰ��¼����ݣ���һ�㷵�صĲ�������ܲ�ͬ
					statecode = re.getInt(2);
					message.setData(re.getString(3));
			  } else {
				  //���벻һ���򷵻�ʧ�ܵĲ�����
				  statecode = 1102;
			  } 
	     }catch (SQLException e){
	    	 e.printStackTrace();
	    	 statecode = 1102; 
		}				 
		return statecode;
	}
	
	public int Register(Connection conn, Message message) {
		int Ecard = message.getPerson().getEcardNumber();
		int statecode = 0;
		String password = message.getPerson().getPassword();
		try{	
			 //�ж��û��Ƿ����
			 stmt = conn.prepareStatement("select EcardNumber from BasicInfo where EcardNumber = ?");
			 stmt.setInt(1, Ecard);
			 ResultSet re = stmt.executeQuery();
			 if(re.next())	statecode=1102;
			 else statecode=1101;
			
			 //���û������ڣ������ݿ���в������
			 if(statecode == 1101)
			 {
				 //�������
				 stmt = conn.prepareStatement("Insert into BasicInfo(EcardNumber,password) values(?,?)");
			
				 //1����EcardNumber��2����password
				 stmt.setInt(1, Ecard);
				 stmt.setString(2, password);
				 stmt.execute();
			}
		} catch(SQLException e){
			e.printStackTrace();
			statecode = 1102;}
		return statecode;
	}
	
	public int ShowBasicInfo(Connection conn, Message message) {
		int Ecard = message.getEcardNumber();
		int statecode = 1101;
		try{	
			 stmt = conn.prepareStatement("select nameString,nameSpelling,birthday,IDNumber,sNumber,gender,school,major,Email,Telephone,HomeAddress from BasicInfo where EcardNumber = ?");
			 stmt.setInt(1, Ecard);
			 ResultSet re = stmt.executeQuery();
			 re.next();
			 info.setNameString(re.getString(1));
			 info.setNameSpelling(re.getString(2));
			 info.setBirthday(re.getString(3));
			 info.setIDNumber(re.getString(4));
			 info.setSNumber(re.getString(5));
			 info.setGender(re.getInt(6));
			 info.setSchool(re.getString(7));
			 info.setMajor(re.getString(8));
			 info.setEmail(re.getString(9));
			 info.setTelephone(re.getString(10));
			 info.setHomeAddress(re.getString(11));
			 message.setBasicInfo(info);
			 
		} catch(SQLException e){
			e.printStackTrace();
			}
		return statecode;
	}
	
}
