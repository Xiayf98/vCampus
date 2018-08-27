/**
 * Server.java
 * �������ֱ࣬�ӵ��÷������̣߳����������ʵ���˶��̴߳���
 * @author gutingxuan
 * @version 2.0
 * ʵ�ֶ�����
 * 2018.8.23
 * @author zhousihai
 * @version 2.0
 * ���Server�Ի���������,������ֹ��ť����ʵ��,ȱ��IP���롢�˿ں���Ļ�ȡ
 * 2018.8.22
 */


package edu.seu.vcampus.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Server extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIP;
	private JTextField textPort;
	private JTextArea txtpnn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Server frame = new Server();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		});
	}

	/**
	 * Create the frame.
	 */
	public Server() {
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//��ȡIP��ַ
		InetAddress addr;
		String IP = null;
		try {
			addr = InetAddress.getLocalHost();
			IP = addr.getHostAddress().toString();// ��ñ���IP
			System.out.println(IP);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		JLabel lbIP = new JLabel("��ǰIP��ַ��");
		lbIP.setFont(new Font("΢���ź�", Font.BOLD, 15));
		lbIP.setHorizontalAlignment(SwingConstants.CENTER);
		lbIP.setBounds(20, 10, 144, 35);
		contentPane.add(lbIP);
		
		textIP = new JTextField(IP);
		textIP.setEditable(false);
		textIP.setBounds(144, 18, 123, 21);
		contentPane.add(textIP);
		textIP.setColumns(10);
		textIP.setBorder(null);
		textIP.setBackground(Color.white);
		
		JLabel lbPort = new JLabel("�����˿ںţ�");
		lbPort.setHorizontalAlignment(SwingConstants.CENTER);
		lbPort.setFont(new Font("΢���ź�", Font.BOLD, 15));
		lbPort.setBounds(20, 55, 144, 35);
		contentPane.add(lbPort);
		
		textPort = new JTextField("6666");
		textPort.setEditable(false);
		textPort.setColumns(10);
		textPort.setBounds(144, 62, 123, 21);
		textPort.setBorder(null);
		contentPane.add(textPort);	
		
		
		final JButton btnEnd = new JButton("��ֹ");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnEnd){
					String tmp = ("����������ֹ\n");
					txtpnn.setText(txtpnn.getText() + tmp);
					btnEnd.setEnabled(false);
					System.exit(0);
				}
			}
		});
		btnEnd.setEnabled(false);
		btnEnd.setFont(new Font("΢���ź�", Font.BOLD, 15));
		btnEnd.setBounds(294, 61, 93, 23);
		contentPane.add(btnEnd);
		
		final JButton btnStart = new JButton("����");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						txtpnn.setText("������������\n");
						//exit = false;
						btnStart.setEnabled(false);
						btnEnd.setEnabled(true);
						
						//���������˿�
						start(6666);
					}
				}).start();
			}
		});
		btnStart.setFont(new Font("΢���ź�", Font.BOLD, 15));
		btnStart.setBounds(294, 16, 93, 23);
		contentPane.add(btnStart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 100, 343, 150);
		contentPane.add(scrollPane);

		txtpnn = new JTextArea();
		scrollPane.setViewportView(txtpnn);

		setVisible(true);
	}
	
	@SuppressWarnings("resource")
	public void start(int port) {
		
		//�����˿�
		ServerSocket s = null;
		
		try {
			//�ö˿ںŽ��������������˿�
			s = new ServerSocket(port);
		} catch (IOException e) {
			txtpnn.setText(txtpnn.getText() + "\n" + e.toString());
			System.exit(1);
		}
		int curRequestCount = 0;
		while (true) {
			try {
				//csΪ���������յ��Ŀͻ��˶˿�
				Socket cs = s.accept();
				
				//ִ�н��յ��Ŀͻ��˶˿ڵ���Ϊ		
				new ServerThread(cs).start();
				
				txtpnn.setText(txtpnn.getText() + "\n" + "���յ��� ��" + (++curRequestCount) + "������");
				//cs.close();
			} catch (IOException e) {
				txtpnn.setText(txtpnn.getText() + "\n" + e.toString());
			}
		}
	}
}
		





