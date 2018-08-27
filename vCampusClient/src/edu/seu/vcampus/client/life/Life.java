/**
 * Life.java
 * @author huangxinyao
 * @version 1.0
 * 2018.8.24
 * 生活服务界面类 
 */
package edu.seu.vcampus.client.life;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Life extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Life frame = new Life();
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
	public Life() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4E1C\u5357\u5927\u5B66\u865A\u62DF\u6821\u56ED\u7CFB\u7EDF");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		label.setBounds(82, 13, 420, 60);
		contentPane.add(label);
		
		JButton btMedicine = new JButton("\u533B\u7597\u4E2D\u5FC3");
		btMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalTab frame1=new MedicalTab();
				frame1.setVisible(true);
			}
		});
		btMedicine.setBounds(64, 140, 113, 27);
		contentPane.add(btMedicine);
		
		JButton btEcard = new JButton("\u4E00\u5361\u901A\u4E2D\u5FC3");
		btEcard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EcardTab frame1=new EcardTab();
				frame1.setVisible(true);
			}
		});
		btEcard.setBounds(64, 196, 113, 27);
		contentPane.add(btEcard);
		
		JButton btDom = new JButton("\u5BBF\u820D");
		btDom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DormTab frame1=new DormTab();
				frame1.setVisible(true);
			}
		});
		btDom.setBounds(64, 86, 113, 27);
		contentPane.add(btDom);
	}
}
