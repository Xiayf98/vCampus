/**
 * MainPage.java
 * @author yangyuesen
 * @version 2.0
 * 2018.8.24
 * 用户主页类 
 * @author gutingxuan
 * @version 2.1
 * 2018.8.25
 * 实现界面跳转，个人信息一卡通显示
 */
package edu.seu.vcampus.client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.swt.widgets.Display;

import javax.swing.JLabel;
import javax.swing.JButton;

import com.only.OnlyFrame;

import edu.seu.vcampus.client.shop.ShopTab;
import edu.seu.vcampus.client.course.CourseFrame;
import edu.seu.vcampus.client.library.Library;
import edu.seu.vcampus.client.life.Life;
import edu.seu.vcampus.util.Message;

public class MainPage extends OnlyFrame implements ActionListener {
	private JPanel contentPane;
	private static final long serialVersionUID = -3379062529026457786L;

	private int Ecard;
	private String name;
	
	public MainPage(Message ms) {
		Ecard = ms.getEcardNumber();
		name = ms.getData();
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage(Ecard);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainPage(final int EcardNumber) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("退出登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				new Login();
			}
		});
		btnNewButton.setBounds(50, 80, 100, 80);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("图书查询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library frame = new Library();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(50, 170, 100, 80);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("课程管理");
		btnNewButton_2.setBounds(50, 260, 100, 80);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseFrame frame = new CourseFrame();
				frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_3 = new JButton("生活服务");
		btnNewButton_3.setBounds(50, 350, 100, 80);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Life frame = new Life();
				frame.setVisible(true);
			}
		});
		
	
		JButton btnNewButton_4 = new JButton("在线商店");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShopTab(contentPane,Ecard);
			}
		});
		btnNewButton_4.setBounds(50, 440, 100, 80);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("个人信息");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicInfoTab window = new BasicInfoTab(EcardNumber);
				window.setBlockOnOpen(true);
				window.open();
				Display.getCurrent().dispose();
				window.fresh();
			}
		});
		btnNewButton_5.setBounds(500, 80, 100, 80);
		contentPane.add(btnNewButton_5);
		
		JLabel label = new JLabel("\u771F\u76AE\u6C99\u53D1\uFF0C\u4F60\u597D\u3002\u6B22\u8FCE\u6765\u5230\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		label.setForeground(Color.BLUE);
		label.setBounds(233, 44, 507, 52);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
	
		contentPane.add(lblNewLabel);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}