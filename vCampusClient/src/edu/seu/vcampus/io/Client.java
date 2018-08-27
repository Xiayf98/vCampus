/***
 * Client.java
 * @author gutingxuan
 * 2018.8.22
 * ���������˴��ʹ����Message����start����ʼ����
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
			//�����ͻ��˶˿�
			Socket socket = new Socket(clientobj.getIP(), 6666);
			
			// �����������������������
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			
			// ���������������շ������˷��͵���Ϣ
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(socket.getInputStream()));

			// �������, һ��Ҫflush����
		    oos.writeObject((Message) clientobj);// ��������Ѷ��󴫵ݵ�������
			oos.flush();
			obj = ois.readObject();// ��ȡ�����������յ� ����
							
			ois.close();
			oos.close();
			socket.close();
	
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Error:����ʧ�ܣ���鿴�����Ƿ�������");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error:����ʧ�ܣ���鿴�����Ƿ�������");
			e.printStackTrace();
		} finally {
			return (Message) obj;
		} 
	}
}