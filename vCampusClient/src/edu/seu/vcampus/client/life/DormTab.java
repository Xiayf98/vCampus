/**
 * DormTab.java
 * @author huangxinyao
 * @version 1.0
 * 2018.8.24
 * 宿舍界面类 
 */
package edu.seu.vcampus.client.life;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class DormTab extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DormTab frame = new DormTab();
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
	public DormTab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		label.setBounds(26, 13, 105, 46);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1\u6708", "2\u6708", "3\u6708", "4\u6708", "5\u6708", "6\u6708", "7\u6708", "8\u6708", "9\u6708", "10\u6708", "11\u6708", "12\u6708"}));
		comboBox.setBounds(232, 87, 45, 24);
		contentPane.add(comboBox);
		
		JLabel label_1 = new JLabel("\u5BBF\u820D\u53F7");
		label_1.setBounds(160, 31, 72, 18);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(240, 28, 130, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\uFF08\u586B\u5199\u6570\u5B57\u5982611\uFF09");
		label_2.setBounds(412, 31, 130, 18);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("\u6C34\u7535\u8D39\u67E5\u8BE2");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(26, 72, 120, 46);
		contentPane.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u6C34\u7535\u8D39");
		label_3.setBounds(333, 90, 72, 18);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(426, 87, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BBF\u820D\u536B\u751F\u67E5\u8BE2");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(26, 131, 144, 65);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1\u6708", "2\u6708", "3\u6708", "4\u6708", "5\u6708", "6\u6708", "7\u6708", "8\u6708", "9\u6708", "10\u6708", "11\u6708", "12\u6708"}));
		comboBox_1.setBounds(232, 155, 45, 24);
		contentPane.add(comboBox_1);
		
		JLabel label_4 = new JLabel("\u536B\u751F\u5206");
		label_4.setBounds(333, 158, 72, 18);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(426, 155, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_5 = new JLabel("\u5BBF\u820D\u62A5\u4FEE");
		label_5.setFont(new Font("宋体", Font.PLAIN, 24));
		label_5.setBackground(new Color(240, 240, 240));
		label_5.setBounds(26, 193, 144, 57);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u6545\u969C\u4FE1\u606F");
		label_6.setBounds(202, 216, 72, 18);
		contentPane.add(label_6);
		
		JButton button = new JButton("\u67E5\u770B\u62A5\u4FEE\u60C5\u51B5");
		button.setBounds(392, 212, 150, 27);
		contentPane.add(button);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(204, 260, 338, 95);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.setBounds(429, 378, 113, 27);
		contentPane.add(btnNewButton);

	}
}
