/**
 * Library.java
 * @author yangyuesen
 * @version 1.0
 * 2018.8.24
 * 图书馆初始页面，显示的是未还的图书 
 */

package edu.seu.vcampus.client.library;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Library extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library frame = new Library();
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
	public Library() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u672A\u8FD8\u56FE\u4E66");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setBounds(50, 80, 120, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u56FE\u4E66\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
		    dispose();
            BookSearch frame2=new  BookSearch();
             frame2.setVisible(true);
             
			}
		});
		btnNewButton_1.setBounds(170, 80, 120, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5DF2\u8FD8\u56FE\u4E66");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			 ShowBook frame2=new  ShowBook();
             frame2.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(290, 80, 120, 40);
		contentPane.add(btnNewButton_2);
		
		table = new JTable();
		table.setFont(new Font("楷体", Font.PLAIN, 16));
	 
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"    \u5E8F\u53F7", "  \u56FE\u4E66\u7F16\u53F7", "    \u4E66\u540D", "  \u501F\u9605\u65F6\u95F4 ", "  \u8FC7\u671F\u65F6\u95F4", "  \u7EED\u501F\u56FE\u4E66"},
			},
			new String[] {
				"\u5E8F\u53F7", "\u56FE\u4E66\u7F16\u53F7", "\u4E66\u540D", "\u501F\u9605\u65F6\u95F4", "\u8FC7\u671F\u65F6\u95F4", "\u7EED\u501F\u56FE\u4E66"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.setBounds(50, 150, 600, 16);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setRowHeight(40);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
		
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(100);
		table_1.setBounds(50, 167, 600, 320);
		contentPane.add(table_1);
	}
}