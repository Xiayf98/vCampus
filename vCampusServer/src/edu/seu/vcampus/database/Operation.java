/**
 * Operation.java
 * 客户端数据库操作类
 * 这个类包含各种操作对应的函数，这些函数都是调用DataBase
 * 进行数据库的操作
 * @author gutingxuan
 * @version 2.0
 * 实现注册和登录功能
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
			  //查询操作
			  stmt = conn.prepareStatement("select password,identity,nameString from BasicInfo where EcardNumber  = ?");
			  System.out.println(Ecard);
			  System.out.println(message.getPerson().getPassword());
			  
			  //占位符？设为当前一卡通号
			  stmt.setInt(1, Ecard);
			  
			  //这两句大概是使得开始进行select操作
			  ResultSet re = stmt.executeQuery();
			  re.next();
			
			  //1代表password，2代表identity，3代表nameString，和上面顺序相同
			  //判断密码是否一致
			  if (re.getString(1).equals(password)){
				  	//返回当前登录者身份，与一般返回的操作码可能不同
					statecode = re.getInt(2);
					message.setData(re.getString(3));
			  } else {
				  //密码不一致则返回失败的操作码
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
			 //判断用户是否存在
			 stmt = conn.prepareStatement("select EcardNumber from BasicInfo where EcardNumber = ?");
			 stmt.setInt(1, Ecard);
			 ResultSet re = stmt.executeQuery();
			 if(re.next())	statecode=1102;
			 else statecode=1101;
			
			 //若用户不存在，对数据库进行插入操作
			 if(statecode == 1101)
			 {
				 //插入操作
				 stmt = conn.prepareStatement("Insert into BasicInfo(EcardNumber,password) values(?,?)");
			
				 //1代表EcardNumber，2代表password
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
