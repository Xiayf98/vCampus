/**
 * ServerThread.java
 * @author gutingxuan
 * @version 2.0
 * 2018.8.22
 * �������߳��࣬Ϊ������������߳�����50��
 * ����ִ�н��յ��Ķ˿ڵ���Ϊ
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
        	//�ӿͻ��˻�ȡ��Ϣ����
        	ObjectInputStream ois = new ObjectInputStream(
            		new BufferedInputStream(sock.getInputStream())); 
        	
        	//��ͻ��˷�����Ϣ����
        	ObjectOutputStream oos = new ObjectOutputStream(sock
					.getOutputStream());
        	
        	//�ѿͻ��˷�����������ȡ�ɶ�����ʽ 
            Message message =(Message) ois.readObject(); 
        	System.out.println("���յ���Ϣ����"+message.getType());
            if (message != null) {  
            	
            	String url;
            	String dbpath = System.getProperty("user.dir").replace('\\', '/')+"/vCampus.accdb";
            	url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+dbpath;

                Connection conn = null;
    		 
                try {
                	// ����JDBC-ODBC����������
        			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        			
                	conn=DriverManager.getConnection( "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+url);
                	Operation op = new Operation();	
                	
                	switch (message.getType()){
                	
                	//��¼
                	case 1201:
                		message.setType(op.Login(conn, message));
                		break;
                		
                	//ע��
                	case 1202:
                		message.setType(op.Register(conn,message));
                		break;
                		
                	//��ʾѧ����Ϣ
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
       
            //ִ�пͻ��˶˿ڴ������Ķ�����Ϊ�󻹵ô��ؿͻ���
			//�������, һ��Ҫflush���� 
			oos.writeObject(message);//��������Ѷ������
			System.out.println("������Ϣ���� "+message.getType());
			oos.flush();//ˢ�������
			
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
