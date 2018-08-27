/***
 * Client.java
 * @author gutingxuan
 * 2018.8.22
 * 用来向服务端传送打包的Message对象，start即开始传送
 */
package edu.seu.vcampus.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import edu.seu.vcampus.util.Message;

public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("finally")
	public Message start(Message clientobj)
			throws ClassNotFoundException {
		Object obj = null;
		try {
			//创建客户端端口
			Socket socket = new Socket(clientobj.getIP(), 6666);
			
			// 建立输出流，向服务器端输出
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			
			// 建立输入流，接收服务器端发送的信息
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(socket.getInputStream()));

			// 输入对象, 一定要flush（）
		    oos.writeObject((Message) clientobj);// 用输出流把对象传递到服务器
			oos.flush();
			obj = ois.readObject();// 读取输入流所接收的 对象
							
			ois.close();
			oos.close();
			socket.close();
	
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error:登入失败，请查看网络是否正常！");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error:登入失败，请查看网络是否正常！");
			e.printStackTrace();
		} finally {
			return (Message) obj;
		} 
	}
}