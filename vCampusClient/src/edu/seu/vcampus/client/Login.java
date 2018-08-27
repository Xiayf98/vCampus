/**
 * Login.java
 * ��¼������
 * @author gutingxuan
 * @version 2.0
 * ʵ�ֵ�¼ע�Ṧ��
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

	private Person _person = new Person();	//��ǰ�û�
	private JFrame frame;					//��½��
    private JTextField _textEcardNumber;	//һ��ͨ��
    private JPasswordField _textPassword;	//����
    private JButton _btnLogin;				//��¼��ť
    private JButton _btnRegister;			//ע�ᰴť
    
	//�๹�캯������ʼ�����岢��ʾ
    public Login() {
        Initial();
        this.frame.setVisible(true);
    }

    //ע����������
    public void disposeMe() {
        frame.dispose();
    }

    //��ʼ����������
    private void Initial() {
    	frame = new JFrame();
    	
    	//frame���Ͻǵ�����Ϊ(100,100),��Ϊ640,��Ϊ480
        frame.setBounds(100, 100, 640, 480);
        
        //�رմ���
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //������
        frame.setTitle("SEU vCampus");
        
        //�����ϽǱ�����java logo��͸��
        frame.setIconImage(frame.getGraphicsConfiguration().createCompatibleImage(frame.getWidth(), frame.getHeight(), Transparency.BITMASK));
        
        //��������չ涨��λ����ʾ��������Ĭ�ϵ�FlowLayout������ʾ
        frame.getContentPane().setLayout(null);
        
        //���ɵ�����С
        frame.setResizable(false);
        
        //��Frame����ʧȥ�߿�ͱ����������Σ��о�ûʲôЧ��
        frame.setUndecorated(false);
        
        //�Ŀ�ı�����ɫ��Ĭ�ϻ�ɫ
        //frame.getContentPane().setBackground(Color.WHITE);

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

        //һ��ͨ�ſ�UI
        JLabel lbl_User = new JLabel("һ��ͨ�ţ�");
        lbl_User.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        lbl_User.setForeground(Color.BLACK);
        lbl_User.setBounds(178, 175, 90, 30);
        lbl_User.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(lbl_User);

        //�����UI
        JLabel lblPassword = new JLabel("��       �룺");
        lblPassword.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBounds(178, 236, 90, 30);
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.getContentPane().add(lblPassword);

        //һ��ͨ��UI
        _textEcardNumber = new JTextField("");
        _textEcardNumber.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        _textEcardNumber.setBounds(274, 170, 160, 40);
        frame.getContentPane().add(_textEcardNumber);

        //����UI
        _textPassword = new JPasswordField("");
        _textPassword.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        _textPassword.setBounds(274, 231, 160, 40);
        frame.getContentPane().add(_textPassword);
        
        //��¼��ťUI
        _btnLogin = new JButton("��¼");
        _btnLogin.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        _btnLogin.setBounds(358, 323, 120, 50);
        _btnLogin.setFocusable(false);
        frame.getContentPane().add(_btnLogin);

        //ע�ᰴťUI
        _btnRegister = new JButton("ע��");
        _btnRegister.setFont(new Font("΢���ź�", Font.PLAIN, 18));
        _btnRegister.setBounds(178, 323, 120, 50);
        _btnRegister.setFocusable(false);
        frame.getContentPane().add(_btnRegister);

        //��¼��ť��Ӧ����
        _btnLogin.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                //�����ť��ִ�еĴ���
        		
        		final Message senderMessage = new Message();
				senderMessage.setEcardNumber(Integer.valueOf(
						_textEcardNumber.getText()).intValue());
				_person.setEcardNumber(Integer.valueOf(
						_textEcardNumber.getText()).intValue());
				_person.setPassword(String.valueOf(_textPassword.getPassword()));
				senderMessage.setPerson(_person);
				senderMessage.setType(1201);
				
				//�첽����
				{
					new Thread(new Runnable() {
						public void run() {
							while (true) {
								try {
									//��ʼ���Ͷ��󣬲����շ��������صĶ���
									Message message = new Client().start(senderMessage);
									
									//����������ж���ѧ�����ǹ���Ա��0Ϊѧ����1Ϊ����Ա
									if(message.getType()==0)
									{
										disposeMe();
										new MainPage(message);
										break;
									}
									else {JOptionPane.showMessageDialog(null,
											"Error:�����һ��ͨ�Ŵ���");break;}
								}catch (ClassNotFoundException e) {
									e.printStackTrace();
								}
							}
						}
					}).start();
				}

				// �첽����
			}
		});
        
        //ע�ᰴť��Ӧ����
        _btnRegister.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
                //�����ť��ִ�еĴ���
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
