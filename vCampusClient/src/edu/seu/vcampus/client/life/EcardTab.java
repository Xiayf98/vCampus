/**
 * EcardTab.java
 * @author wuwenjun
 * @version 1.0
 * 2018.8.24
 * 一卡通界面类 
 */
package edu.seu.vcampus.client.life;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import com.only.OnlyScrollPane;
import java.awt.Component;
import javax.swing.SwingConstants;

public class EcardTab extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EcardTab frame = new EcardTab();
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
	public EcardTab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 482);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 10, 98, 46);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(105, 66, 66, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 107, 66, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 145, 66, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E00\u5361\u901A\u53F7");
		lblNewLabel_1.setBounds(20, 66, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E00\u5361\u901A\u72B6\u6001");
		lblNewLabel_2.setBounds(20, 108, 75, 18);
		getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u4F59\u989D");
		label.setBounds(20, 148, 54, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5143");
		label_1.setBounds(187, 148, 54, 15);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u4E00\u5361\u901A\u4E1A\u52A1");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 192, 128, 24);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u5145\u503C");
		btnNewButton.setBounds(10, 246, 93, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u89E3\u51BB");
		btnNewButton_1.setBounds(10, 296, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6302\u5931");
		btnNewButton_2.setBounds(10, 342, 93, 23);
		getContentPane().add(btnNewButton_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(137, 247, 66, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("\u4EA4\u6613\u8BB0\u5F55\u67E5\u8BE2");
		btnNewButton_3.setBounds(259, 246, 122, 21);
		getContentPane().add(btnNewButton_3);
		
		table = new JTable();
		table.setBounds(280, 331, 1, 1);
		getContentPane().add(table);
		
		OnlyScrollPane onlyScrollPane = new OnlyScrollPane((Component) null);
		onlyScrollPane.setToolTipText("dsvgg\r\n\r\n");
		onlyScrollPane.getHeaderLabel().setText("\u7F16\u53F7             \u65F6\u95F4               \u6D88\u8D39\u9879\u76EE                \u91D1\u989D                 \u4F59\u989D\r\n\r\n");
		onlyScrollPane.getHeaderLabel().setHorizontalAlignment(SwingConstants.CENTER);
		onlyScrollPane.setBounds(259, 286, 452, 197);
		getContentPane().add(onlyScrollPane);
	}
}
