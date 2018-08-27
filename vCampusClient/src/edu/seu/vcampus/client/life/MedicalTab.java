/**
 * MedicalTab.java
 * @author wuwenjun
 * @version 1.0
 * 2018.8.24
 * 医疗界面类 
 */
package edu.seu.vcampus.client.life;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import com.only.OnlyScrollPane;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MedicalTab extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalTab frame = new MedicalTab();
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
	public MedicalTab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(173, 49, 218, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u533B\u4FDD\u5361\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(44, 33, 119, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u75C5\u53F2");
		btnNewButton.setBounds(173, 80, 93, 23);
		contentPane.add(btnNewButton);
		
		OnlyScrollPane onlyScrollPane = new OnlyScrollPane((Component) null);
		onlyScrollPane.setBounds(173, 105, 439, 133);
		contentPane.add(onlyScrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("\u9884\u7EA6\u8BCA\u5BA4");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(44, 288, 93, 21);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u95E8\u8BCA\u90E8", "\u53E3\u8154\u79D1", "\u5185\u79D1", "\u9AA8\u79D1", "\u5987\u79D1"}));
		comboBox.setBounds(173, 290, 158, 21);
		contentPane.add(comboBox);
		
		OnlyScrollPane onlyScrollPane_1 = new OnlyScrollPane((Component) null);
		onlyScrollPane_1.setBounds(173, 338, 439, 133);
		contentPane.add(onlyScrollPane_1);
	}
}
