/**
 * Login.java
 * 登录界面类
 * @author gutingxuan
 * @version 2.0
 * 实现登录注册功能
 * 2018.8.23
 */

package edu.seu.vcampus.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Transparency;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.seu.vcampus.util.Person;
import edu.seu.vcampus.client.Register;
import edu.seu.vcampus.util.*;
import edu.seu.vcampus.io.Client;

public class Login {

	private Person _person = new Person();	//当前用户
	private JFrame frame;					//登陆框
    private JTextField _textEcardNumber;	//一卡通号
    private JPasswordField _textPassword;	//密码
    private JButton _btnLogin;				//登录按钮
    private JButton _btnRegister;			//注册按钮
    
	//类构造函数：初始化窗体并显示
    public Login() {
        Initial();
        this.frame.setVisible(true);
    }

    //注销整个窗体
    public void disposeMe() {
        frame.dispose();
    }

    //初始化窗体内容
    private void Initial() {
    	frame = new JFrame();
    	
    	//frame左上角的坐标为(100,100),宽为640,高为480
        frame.setBounds(100, 100, 640, 480);
        
        //关闭窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //框框标题
        frame.setTitle("SEU vCampus");
        
        //把左上角本来的java logo变透明
        frame.setIconImage(frame.getGraphicsConfiguration().createCompatibleImage(frame.getWidth(), frame.getHeight(), Transparency.BITMASK));
        
        //将组件按照规定的位置显示，否则按照默认的FlowLayout布局显示
        frame.getContentPane().setLayout(null);
        
        //不可调整大小
        frame.setResizable(false);
        
        //让Frame窗口失去边框和标题栏的修饰，感觉没什么效果
        frame.setUndecorated(false);
        
        //改框的背景颜色，默认灰色
        //frame.getContentPane().setBackground(Color.WHITE);

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

        //一卡通号框UI
        JLabel lbl_User = new JLabel("一卡通号：");
        lbl_User.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lbl_User.setForeground(Color.BLACK);
        lbl_User.setBounds(178, 175, 90, 30);
        lbl_User.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(lbl_User);

        //密码框UI
        JLabel lblPassword = new JLabel("密       码：");
        lblPassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBounds(178, 236, 90, 30);
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(lblPassword);

        //一卡通号UI
        _textEcardNumber = new JTextField("");
        _textEcardNumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        _textEcardNumber.setBounds(274, 170, 160, 40);
        frame.getContentPane().add(_textEcardNumber);

        //密码UI
        _textPassword = new JPasswordField("");
        _textPassword.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        _textPassword.setBounds(274, 231, 160, 40);
        frame.getContentPane().add(_textPassword);
        
        //登录按钮UI
        _btnLogin = new JButton("登录");
        _btnLogin.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        _btnLogin.setBounds(358, 323, 120, 50);
        _btnLogin.setFocusable(false);
        frame.getContentPane().add(_btnLogin);

        //注册按钮UI
        _btnRegister = new JButton("注册");
        _btnRegister.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        _btnRegister.setBounds(178, 323, 120, 50);
        _btnRegister.setFocusable(false);
        frame.getContentPane().add(_btnRegister);

        //登录按钮相应代码
        _btnLogin.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                //点击按钮后执行的代码
        		
        		final Message senderMessage = new Message();
				senderMessage.setEcardNumber(Integer.valueOf(
						_textEcardNumber.getText()).intValue());
				_person.setEcardNumber(Integer.valueOf(
						_textEcardNumber.getText()).intValue());
				_person.setPassword(String.valueOf(_textPassword.getPassword()));
				senderMessage.setPerson(_person);
				senderMessage.setType(1201);
				
				//异步处理
				{
					new Thread(new Runnable() {
						public void run() {
							while (true) {
								try {
									//开始传送对象，并接收服务器返回的对象
									Message message = new Client().start(senderMessage);
									
									//接收身份码判断是学生还是管理员，0为学生，1为管理员
									if(message.getType()==0)
									{
										disposeMe();
										new MainPage(message);
										break;
									}
									else {JOptionPane.showMessageDialog(null,
											"Error:密码或一卡通号错误");break;}
								}catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
							}
						}
					}).start();
				}

				// 异步处理
			}
		});
        
        //注册按钮相应代码
        _btnRegister.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                //点击按钮后执行的代码
        		disposeMe();
                new Register();
        	}
        });
    }
    
    public Person getPerson() {
		return this._person;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}
}
