/**
 * ServerThread.java
 * @author gutingxuan
 * @version 2.0
 * 2018.8.22
 * 服务器线程类，为服务器类服务，线程上限50个
 * 用来执行接收到的端口的行为
 */

package edu.seu.vcampus.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.seu.vcampus.database.Operation;
import edu.seu.vcampus.util.Message;
 

public class ServerThread extends Thread {
    static String hello = "From Server: Hello world";
    Socket sock;
    public ServerThread(Socket s)
    {
        sock =s ;
    }
    public void run()
    {
        try{
        	//从客户端获取信息的流
        	ObjectInputStream ois = new ObjectInputStream(
            		new BufferedInputStream(sock.getInputStream())); 
        	
        	//向客户端发送信息的流
        	ObjectOutputStream oos = new ObjectOutputStream(sock
					.getOutputStream());
        	
        	//把客户端发过来的流读取成对象形式 
            Message message =(Message) ois.readObject(); 
        	System.out.println("接收到消息类型"+message.getType());
            if (message != null) {  
            	
            	String url;
            	String dbpath = System.getProperty("user.dir").replace('\\', '/')+"/vCampus.accdb";
            	url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+dbpath;

                Connection conn = null;
    		 
                try {
                	// 加载JDBC-ODBC桥驱动程序
        			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        			
                	conn=DriverManager.getConnection( "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+url);
                	Operation op = new Operation();	
                	
                	switch (message.getType()){
                	
                	//登录
                	case 1201:
                		message.setType(op.Login(conn, message));
                		break;
                		
                	//注册
                	case 1202:
                		message.setType(op.Register(conn,message));
                		break;
                		
                	//显示学生信息
                	case 1301:
                		message.setType(op.ShowBasicInfo(conn,message));
                		
                	default:
                		break;
                	}               	
                }catch (ClassNotFoundException e) {
    	  	       	e.printStackTrace();
                } catch (SQLException e) {
                	e.printStackTrace();
                }finally {               	
                	if (null != conn){
                		try {
                			conn.close();
                		} catch (SQLException e) {
                			e.printStackTrace();
                		}
                	}	
                }
            }
       
            //执行客户端端口传过来的对象行为后还得传回客户端
			//输入对象, 一定要flush（） 
			oos.writeObject(message);//用输出流把对象输出
			System.out.println("返回消息类型 "+message.getType());
			oos.flush();//刷新输出流
			
			oos.close();
            ois.close();
            sock.close();
        }
        catch(IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
