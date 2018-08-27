/**
 * Register.java
 * @author gutingxuan
 * @version 2.0
 * 2018.8.23
 * 注册界面类
 */
package edu.seu.vcampus.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Transparency;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import edu.seu.vcampus.io.Client;
import edu.seu.vcampus.util.Message;
import edu.seu.vcampus.util.Person;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {
	private JFrame frame;
	private JTextField _textEcardNumber;
	private JPasswordField _textPassword;
	private JPasswordField _textPasswordCon;
	private JButton _btnLogin;
	private JButton _btnRegister;
	String type = null;
	private long[] starts;
	private long start;
	private Timer t;
	private Person _person = new Person();

	//类构造函数：初始化窗体并显示
	public Register() {
		Initial();
		this.frame.setVisible(true);
	}

	//注销整个窗体
	public void disposeMe() {
		frame.dispose();
	}

	//设置登录按钮响应代码
	public void setLoginAction(ActionListener al) {
		_btnLogin.addActionListener(al);
	}
	
	//设置注册按钮响应代码
	public void setRegisterAction(ActionListener al) {
		_btnRegister.addActionListener(al);
	}

	//获取填写的用户ID
	public String getUserId() {
		return _textEcardNumber.getText();
	}

	//获取填写的密码
	public String getPassword() {
		return new String(_textPassword.getPassword());
	}
	    
	 //是否启用全部按钮、文本框
	public void setAllEnabled(boolean isEnabled) {
		_textEcardNumber.setEnabled(isEnabled);
		_textPassword.setEnabled(isEnabled);
		_btnLogin.setEnabled(isEnabled);
		_btnRegister.setEnabled(isEnabled);
		setAnimationEnabled(!isEnabled);
	}
	    
	//是否启用动画
	public void setAnimationEnabled(boolean isEnabled) {
		if (isEnabled && !t.isRunning()) {
			start = System.currentTimeMillis();
			for (int i = 0; i < 5; ++i) {
				starts[i] = start - i * 100;
			}
			t.start();
		}
	    if (!isEnabled && t.isRunning()) {
	    	t.stop();
	    }
	 }

	//初始化窗体内容
	private void Initial() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SEU vCampus");
		frame.setIconImage(frame.getGraphicsConfiguration().createCompatibleImage(frame.getWidth(), frame.getHeight(), Transparency.BITMASK));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.getContentPane().setBackground(Color.WHITE);
		
	    // 控制界面居中
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension framesize = frame.getSize();
		int x = (int) screensize.getWidth() / 2 - (int) framesize.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - (int) framesize.getHeight() / 2;
		frame.setLocation(x, y);

		JLabel lblNewLabel = new JLabel("东南大学虚拟校园系统");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(110, 60, 420, 60);
	 	frame.getContentPane().add(lblNewLabel);

	 	JLabel lbl_User = new JLabel("一卡通号：");
	 	lbl_User.setFont(new Font("微软雅黑", Font.PLAIN, 18));
	 	lbl_User.setForeground(Color.BLACK);
	 	lbl_User.setBounds(178, 160, 90, 30);
	 	lbl_User.setHorizontalAlignment(SwingConstants.RIGHT);
	 	frame.getContentPane().add(lbl_User);
	 	
	 	JLabel lblPassword = new JLabel("密       码：");
	 	lblPassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
	 	lblPassword.setForeground(Color.BLACK);
	 	lblPassword.setBounds(178, 215, 90, 30);
	 	lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
	 	frame.getContentPane().add(lblPassword);
	 	
        JLabel lblPasswordCon = new JLabel("确认密码：");
        lblPasswordCon.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblPasswordCon.setForeground(Color.BLACK);
        lblPasswordCon.setBounds(178, 275, 90, 30);
        lblPasswordCon.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(lblPasswordCon);
	 	
	 	 //密码UI
        _textPassword = new JPasswordField("");
        _textPassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        _textPassword.setBounds(274, 215, 160, 40);
        frame.getContentPane().add(_textPassword);
        
        _textPasswordCon = new JPasswordField("");
        _textPasswordCon.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        _textPasswordCon.setBounds(274, 275, 160, 40);
        frame.getContentPane().add(_textPasswordCon);

        _textEcardNumber = new JTextField("");
        _textEcardNumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        _textEcardNumber.setBounds(274, 155, 160, 40);
        frame.getContentPane().add(_textEcardNumber);

        
        _btnRegister = new JButton("注册");
        _btnRegister.setFont(new Font("微软雅黑", Font.PLAIN, 18));
	    _btnRegister.setBounds(262, 350, 120, 50);
	    _btnRegister.setContentAreaFilled(false);
	    _btnRegister.setBorderPainted(true);
	    _btnRegister.setFocusable(false);
	    frame.getContentPane().add(_btnRegister);
	       
	    
	    //注册按钮相应代码
        _btnRegister.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                //点击按钮后执行的代码
        		final Message senderMessage = new Message();
        		senderMessage.setEcardNumber(Integer.valueOf(
						_textEcardNumber.getText()).intValue());
				_person.setEcardNumber(Integer.valueOf(
						_textEcardNumber.getText()).intValue());
				_person.setPassword(String.valueOf(_textPassword.getPassword()));
				senderMessage.setPerson(_person);
				senderMessage.setType(1202);
				
				if(!String.valueOf(_textPassword.getPassword()).equals(String.valueOf(_textPasswordCon.getPassword())))
				{
					JOptionPane.showMessageDialog(null,
							"两次密码不一致，请重新输入！");
						disposeMe();
						new Register();
						return;
				}
				
				//异步处理
				{
					new Thread(new Runnable() {
						public void run() {
							while (true) {
								try {
									//开始传送对象，并接收服务器返回的对象
									Message message = new Client().start(senderMessage);
									if(message.getType()==1101)
									{
										JOptionPane.showMessageDialog(null,
											"注册成功！");
										disposeMe();
										new Login();
									}
									else if(message.getType()==1102)
									{
										JOptionPane.showMessageDialog(null,
												"用户已存在！注册失败!");
										disposeMe();
										new Register();
									}
									break;
								}catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
							}
						}
					}).start();
				}

        	}
        });
        
	}
	    
}