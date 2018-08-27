/**
 * Register.java
 * @author gutingxuan
 * @version 2.0
 * 2018.8.23
 * ע�������
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

	//�๹�캯������ʼ�����岢��ʾ
	public Register() {
		Initial();
		this.frame.setVisible(true);
	}

	//ע����������
	public void disposeMe() {
		frame.dispose();
	}

	//���õ�¼��ť��Ӧ����
	public void setLoginAction(ActionListener al) {
		_btnLogin.addActionListener(al);
	}
	
	//����ע�ᰴť��Ӧ����
	public void setRegisterAction(ActionListener al) {
		_btnRegister.addActionListener(al);
	}

	//��ȡ��д���û�ID
	public String getUserId() {
		return _textEcardNumber.getText();
	}

	//��ȡ��д������
	public String getPassword() {
		return new String(_textPassword.getPassword());
	}
	    
	 //�Ƿ�����ȫ����ť���ı���
	public void setAllEnabled(boolean isEnabled) {
		_textEcardNumber.setEnabled(isEnabled);
		_textPassword.setEnabled(isEnabled);
		_btnLogin.setEnabled(isEnabled);
		_btnRegister.setEnabled(isEnabled);
		setAnimationEnabled(!isEnabled);
	}
	    
	//�Ƿ����ö���
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

	//��ʼ����������
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
		
	    // ���ƽ������
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension framesize = frame.getSize();
		int x = (int) screensize.getWidth() / 2 - (int) framesize.getWidth() / 2;
		int y = (int) screensize.getHeight() / 2 - (int) framesize.getHeight() / 2;
		frame.setLocation(x, y);

		JLabel lblNewLabel = new JLabel("���ϴ�ѧ����У԰ϵͳ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 32));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(110, 60, 420, 60);
	 	frame.getContentPane().add(lblNewLabel);

	 	JLabel lbl_User = new JLabel("һ��ͨ�ţ�");
	 	lbl_User.setFont(new Font("΢���ź�", Font.PLAIN, 18));
	 	lbl_User.setForeground(Color.BLACK);
	 	lbl_User.setBounds(178, 160, 90, 30);
	 	lbl_User.setHorizontalAlignment(SwingConstants.RIGHT);
	 	frame.getContentPane().add(lbl_User);
	 	
	 	JLabel lblPassword = new JLabel("��       �룺");
	 	lblPassword.setFont(new Font("΢���ź�", Font.PLAIN, 18));
	 	lblPassword.setForeground(Color.BLACK);
	 	lblPassword.setBounds(178, 215, 90, 30);
	 	lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
	 	frame.getContentPane().add(lblPassword);
	 	
        JLabel lblPasswordCon = new JLabel("ȷ�����룺");
        lblPasswordCon.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        lblPasswordCon.setForeground(Color.BLACK);
        lblPasswordCon.setBounds(178, 275, 90, 30);
        lblPasswordCon.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(lblPasswordCon);
	 	
	 	 //����UI
        _textPassword = new JPasswordField("");
        _textPassword.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        _textPassword.setBounds(274, 215, 160, 40);
        frame.getContentPane().add(_textPassword);
        
        _textPasswordCon = new JPasswordField("");
        _textPasswordCon.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        _textPasswordCon.setBounds(274, 275, 160, 40);
        frame.getContentPane().add(_textPasswordCon);

        _textEcardNumber = new JTextField("");
        _textEcardNumber.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        _textEcardNumber.setBounds(274, 155, 160, 40);
        frame.getContentPane().add(_textEcardNumber);

        
        _btnRegister = new JButton("ע��");
        _btnRegister.setFont(new Font("΢���ź�", Font.PLAIN, 18));
	    _btnRegister.setBounds(262, 350, 120, 50);
	    _btnRegister.setContentAreaFilled(false);
	    _btnRegister.setBorderPainted(true);
	    _btnRegister.setFocusable(false);
	    frame.getContentPane().add(_btnRegister);
	       
	    
	    //ע�ᰴť��Ӧ����
        _btnRegister.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                //�����ť��ִ�еĴ���
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
							"�������벻һ�£����������룡");
						disposeMe();
						new Register();
						return;
				}
				
				//�첽����
				{
					new Thread(new Runnable() {
						public void run() {
							while (true) {
								try {
									//��ʼ���Ͷ��󣬲����շ��������صĶ���
									Message message = new Client().start(senderMessage);
									if(message.getType()==1101)
									{
										JOptionPane.showMessageDialog(null,
											"ע��ɹ���");
										disposeMe();
										new Login();
									}
									else if(message.getType()==1102)
									{
										JOptionPane.showMessageDialog(null,
												"�û��Ѵ��ڣ�ע��ʧ��!");
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