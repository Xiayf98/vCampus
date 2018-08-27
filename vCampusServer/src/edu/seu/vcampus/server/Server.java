/**
 * Server.java
 * 服务器类，直接调用服务器线程，在这个类里实现了多线程传输
 * @author gutingxuan
 * @version 2.0
 * 实现对象传输
 * 2018.8.23
 * @author zhousihai
 * @version 2.0
 * 完成Server对话框主界面,启动终止按钮功能实现,缺少IP号码、端口号码的获取
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
		
		//获取IP地址
		InetAddress addr;
		String IP = null;
		try {
			addr = InetAddress.getLocalHost();
			IP = addr.getHostAddress().toString();// 获得本机IP
			System.out.println(IP);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		JLabel lbIP = new JLabel("当前IP地址：");
		lbIP.setFont(new Font("微软雅黑", Font.BOLD, 15));
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
		
		JLabel lbPort = new JLabel("启动端口号：");
		lbPort.setHorizontalAlignment(SwingConstants.CENTER);
		lbPort.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lbPort.setBounds(20, 55, 144, 35);
		contentPane.add(lbPort);
		
		textPort = new JTextField("6666");
		textPort.setEditable(false);
		textPort.setColumns(10);
		textPort.setBounds(144, 62, 123, 21);
		textPort.setBorder(null);
		contentPane.add(textPort);	
		
		
		final JButton btnEnd = new JButton("终止");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource() == btnEnd){
					String tmp = ("服务器已终止\n");
					txtpnn.setText(txtpnn.getText() + tmp);
					btnEnd.setEnabled(false);
					System.exit(0);
				}
			}
		});
		btnEnd.setEnabled(false);
		btnEnd.setFont(new Font("微软雅黑", Font.BOLD, 15));
		btnEnd.setBounds(294, 61, 93, 23);
		contentPane.add(btnEnd);
		
		final JButton btnStart = new JButton("启动");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {
					public void run() {
						txtpnn.setText("服务器已启动\n");
						//exit = false;
						btnStart.setEnabled(false);
						btnEnd.setEnabled(true);
						
						//开启监听端口
						start(6666);
					}
				}).start();
			}
		});
		btnStart.setFont(new Font("微软雅黑", Font.BOLD, 15));
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
		
		//监听端口
		ServerSocket s = null;
		
		try {
			//用端口号建立服务器监听端口
			s = new ServerSocket(port);
		} catch (IOException e) {
			txtpnn.setText(txtpnn.getText() + "\n" + e.toString());
			System.exit(1);
		}
		int curRequestCount = 0;
		while (true) {
			try {
				//cs为服务器接收到的客户端端口
				Socket cs = s.accept();
				
				//执行接收到的客户端端口的行为		
				new ServerThread(cs).start();
				
				txtpnn.setText(txtpnn.getText() + "\n" + "接收到了 第" + (++curRequestCount) + "个请求");
				//cs.close();
			} catch (IOException e) {
				txtpnn.setText(txtpnn.getText() + "\n" + e.toString());
			}
		}
	}
}
		





