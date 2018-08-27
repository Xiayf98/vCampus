/**
 * MainFrame.java
 * øŒ≥Ã±Ì£¨≤È—ØøŒ≥Ã£¨—°øŒœµÕ≥£¨“——°øŒ≥ÃΩÁ√Ê…Ëº∆ÕÍ≥…
 * ΩÁ√Ê∞¥≈•÷ª”–µ„ª˜œ‡”¶£¨π¶ƒ‹œ‡”¶‘›Œﬁ
 * @author zhousihai
 * @version 1.0
 * 2018.8.25
 */
package edu.seu.vcampus.client.course;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class CourseFrame extends JFrame {

	private JPanel contentPane;
	private JTable tblCur;
	private JTextField txtTotalScore;
	private JTextField txtGradePoint;
	private JTextField txtAvg;
	private JTable tblInqry;
	private JTable tblSelSym;
	private JTable tblSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseFrame frame = new CourseFrame();
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
	public CourseFrame() {
		setTitle("\u8BFE\u7A0B\u6A21\u5757");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel cardpanel = new JPanel();
		cardpanel.setBounds(60, 140, 650, 420);
		contentPane.add(cardpanel);
		cardpanel.setLayout(new CardLayout(0, 0));
		
		JPanel panelCur = new JPanel();
		cardpanel.add(panelCur, "name_8882031165754");
		panelCur.setLayout(null);
		
		tblCur = new JTable();
		tblCur.setBounds(0, 0, 650, 420);
		panelCur.add(tblCur);
		tblCur.setColumnSelectionAllowed(true);
		tblCur.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		tblCur.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tblCur.setRowHeight(28);
		tblCur.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u65F6\u95F4/\u65E5\u671F", "\u661F\u671F\u4E00", "\u661F\u671F\u4E8C", "\u661F\u671F\u4E09", "\u661F\u671F\u56DB", "\u661F\u671F\u4E94"},
				{"1", null, null, null, null, null},
				{"2", null, null, null, null, null},
				{"3", null, null, null, null, null},
				{"4", null, null, null, null, null},
				{"5", null, null, null, null, null},
				{"\u5348\u4F11\u65F6\u95F4", null, null, null, null, null},
				{"6", null, null, null, null, null},
				{"7", null, null, null, null, null},
				{"8", null, null, null, null, null},
				{"9", null, null, null, null, null},
				{"10", null, null, null, null, null},
				{"\u665A\u996D\u65F6\u95F4", null, null, null, null, null},
				{"11", null, null, null, null, null},
				{"12", null, null, null, null, null},
			},
			new String[] {
				"\u65F6\u95F4/\u65E5\u671F", "\u661F\u671F\u4E00", "\u661F\u671F\u4E8C", "\u661F\u671F\u4E09", "\u661F\u671F\u56DB", "\u661F\u671F\u4E94"
			}
		));
		
		JPanel panelInqry = new JPanel();
		cardpanel.add(panelInqry, "name_8928236770408");
		panelInqry.setLayout(null);
		
		
		JLabel lbl01 = new JLabel("\u5F53\u524D\u5B66\u671F");
		lbl01.setBounds(30, 23, 56, 19);
		panelInqry.add(lbl01);
		lbl01.setVerticalAlignment(SwingConstants.TOP);
		lbl01.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JComboBox cbBoxSem = new JComboBox();
		cbBoxSem.setBounds(96, 20, 82, 25);
		panelInqry.add(cbBoxSem);
		cbBoxSem.setModel(new DefaultComboBoxModel(new String[] {"16-17-1", "16-17-2", "16-17-3", "17-18-1", "17-18-2", "17-18-3", "18-19-1", "18-19-2", "18-19-3"}));
		cbBoxSem.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		
		JButton btnStartInqry = new JButton("\u67E5\u8BE2");
		btnStartInqry.setHorizontalAlignment(SwingConstants.LEADING);
		btnStartInqry.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnStartInqry.setBounds(190, 22, 65, 23);
		panelInqry.add(btnStartInqry);
		
		JLabel lbl02 = new JLabel("\u603B\u5B66\u5206");
		lbl02.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lbl02.setBounds(260, 23, 47, 19);
		panelInqry.add(lbl02);
		
		txtTotalScore = new JTextField();
		txtTotalScore.setEditable(false);
		txtTotalScore.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		txtTotalScore.setBounds(306, 21, 66, 23);
		panelInqry.add(txtTotalScore);
		txtTotalScore.setColumns(10);
		
		JLabel lbl03 = new JLabel("\u7EE9\u70B9");
		lbl03.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lbl03.setBounds(382, 23, 47, 19);
		panelInqry.add(lbl03);
		
		txtGradePoint = new JTextField();
		txtGradePoint.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		txtGradePoint.setEditable(false);
		txtGradePoint.setColumns(10);
		txtGradePoint.setBounds(416, 21, 66, 23);
		panelInqry.add(txtGradePoint);
		
		JLabel lbl04 = new JLabel("\u5E73\u5747\u5206");
		lbl04.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lbl04.setBounds(492, 23, 47, 19);
		panelInqry.add(lbl04);
		
		txtAvg = new JTextField();
		txtAvg.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		txtAvg.setEditable(false);
		txtAvg.setColumns(10);
		txtAvg.setBounds(549, 21, 66, 23);
		panelInqry.add(txtAvg);
		
		tblInqry = new JTable();
		tblInqry.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tblInqry.setRowHeight(28);
		tblInqry.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u5E8F\u53F7", "\u5B66\u5E74\u5B66\u671F", "\u8BFE\u7A0B\u540D\u79F0", "\u5B66\u5206", "\u6210\u7EE9", "\u6210\u7EE9\u6027\u8D28", "\u8BFE\u7A0B\u6027\u8D28"},
				{"1", null, null, null, null, null, null},
				{"2", null, null, null, null, null, null},
				{"3", null, null, null, null, null, null},
				{"4", null, null, null, null, null, null},
				{"5", null, null, null, null, null, null},
				{"6", null, null, null, null, null, null},
				{"7", null, null, null, null, null, null},
				{"8", null, null, null, null, null, null},
				{"9", null, null, null, null, null, null},
				{"10", null, null, null, null, null, null},
			},
			new String[] {
				"\u5E8F\u53F7", "\u5B66\u5E74\u5B66\u671F", "\u8BFE\u7A0B\u540D\u79F0", "\u5B66\u5206", "\u6210\u7EE9", "\u6210\u7EE9\u6027\u8D28", "\u8BFE\u7A0B\u6027\u8D28"
			}
		));
		tblInqry.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblInqry.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		tblInqry.setBounds(30, 66, 586, 308);
		panelInqry.add(tblInqry);
		
		JPanel panelSelSym = new JPanel();
		cardpanel.add(panelSelSym, "name_9794129206305");
		panelSelSym.setLayout(null);
		
		tblSelSym = new JTable();
		tblSelSym.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tblSelSym.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		tblSelSym.setRowHeight(28);
		tblSelSym.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u6027\u8D28", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u6559\u5E08", "\u6388\u8BFE\u65F6\u95F4", "\u4E0A\u8BFE\u5730\u70B9", "\u5B66\u5206", "\u4EBA\u6570"},
				{"1", null, null, null, null, null, null, null},
				{"2", null, null, null, null, null, null, null},
				{"3", null, null, null, null, null, null, null},
				{"4", null, null, null, null, null, null, null},
				{"5", null, null, null, null, null, null, null},
				{"6", null, null, null, null, null, null, null},
				{"7", null, null, null, null, null, null, null},
				{"8", null, null, null, null, null, null, null},
				{"9", null, null, null, null, null, null, null},
				{"0", null, null, null, null, null, null, null},
				{"11", null, null, null, null, null, null, null},
				{"12", null, null, null, null, null, null, null},
				{"13", null, null, null, null, null, null, null},
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u6027\u8D28", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u6559\u5E08", "\u6388\u8BFE\u65F6\u95F4", "\u4E0A\u8BFE\u5730\u70B9", "\u5B66\u5206", "\u4EBA\u6570"
			}
		));
		tblSelSym.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblSelSym.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblSelSym.getColumnModel().getColumn(6).setPreferredWidth(35);
		tblSelSym.setBounds(0, 10, 580, 392);
		panelSelSym.add(tblSelSym);
		
		final JButton btnSel01 = new JButton("\u9009\u8BFE");
		btnSel01.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel01.setBounds(579, 37, 71, 28);
		btnSel01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel01)
				btnSel01.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel01);
		
		final JButton btnSel02 = new JButton("\u9009\u8BFE");
		btnSel02.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel02.setBounds(579, 67, 71, 28);
		btnSel02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel02)
				btnSel02.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel02);
		
		final JButton btnSel03 = new JButton("\u9009\u8BFE");
		btnSel03.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel03.setBounds(579, 95, 71, 28);
		btnSel03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel03)
				btnSel03.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel03);
		
		final JButton btnSel04 = new JButton("\u9009\u8BFE");
		btnSel04.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel04.setBounds(579, 122, 71, 28);
		btnSel04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel04)
				btnSel04.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel04);
		
		final JButton btnSel05 = new JButton("\u9009\u8BFE");
		btnSel05.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel05.setBounds(579, 149, 71, 28);
		btnSel05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel05)
				btnSel05.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel05);
		
		final JButton btnSel06 = new JButton("\u9009\u8BFE");
		btnSel06.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel06.setBounds(579, 178, 71, 28);
		btnSel06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel06)
				btnSel06.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel06);
		
		final JButton btnSel07 = new JButton("\u9009\u8BFE");
		btnSel07.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel07.setBounds(579, 206, 71, 28);
		btnSel07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel07)
				btnSel07.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel07);
		
		final JButton btnSel08 = new JButton("\u9009\u8BFE");
		btnSel08.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel08.setBounds(579, 234, 71, 28);
		btnSel08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel08)
				btnSel08.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel08);
		
		final JButton btnSel09 = new JButton("\u9009\u8BFE");
		btnSel09.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel09.setBounds(579, 261, 71, 28);
		btnSel09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel09)
				btnSel09.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel09);
		
		final JButton btnSel10 = new JButton("\u9009\u8BFE");
		btnSel10.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel10.setBounds(579, 289, 71, 28);
		btnSel10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel10)
				btnSel10.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel10);
		
		final JButton btnSel11 = new JButton("\u9009\u8BFE");
		btnSel11.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel11.setBounds(579, 319, 71, 28);
		btnSel11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel11)
				btnSel11.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel11);
		
		final JButton btnSel12 = new JButton("\u9009\u8BFE");
		btnSel12.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel12.setBounds(579, 346, 71, 28);
		btnSel12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel12)
				btnSel12.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel12);
		
		final JButton btnSel13 = new JButton("\u9009\u8BFE");
		btnSel13.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnSel13.setBounds(579, 374, 71, 28);
		btnSel13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSel13)
				btnSel13.setEnabled(false);
				}
			});
		panelSelSym.add(btnSel13);
		
		JLabel lbl05 = new JLabel("\u9009\u8BFE");
		lbl05.setHorizontalAlignment(SwingConstants.CENTER);
		lbl05.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		lbl05.setBounds(579, 9, 71, 28);
		panelSelSym.add(lbl05);
		
		JPanel panelSelected = new JPanel();
		panelSelected.setLayout(null);
		cardpanel.add(panelSelected, "name_11415828355869");
		
		tblSelected = new JTable();
		tblSelected.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u6027\u8D28", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u8001\u5E08", "\u6388\u8BFE\u65F6\u95F4", "\u4E0A\u8BFE\u5730\u70B9", "\u5B66\u5206"},
				{"1", null, null, null, null, null, null},
				{"2", null, null, null, null, null, null},
				{"3", null, null, null, null, null, null},
				{"4", null, null, null, null, null, null},
				{"5", null, null, null, null, null, null},
				{"6", null, null, null, null, null, null},
				{"7", null, null, null, null, null, null},
				{"8", null, null, null, null, null, null},
				{"9", null, null, null, null, null, null},
				{"10", null, null, null, null, null, null},
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u6027\u8D28", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u8001\u5E08", "\u6388\u8BFE\u65F6\u95F4", "\u4E0A\u8BFE\u5730\u70B9", "\u5B66\u5206"
			}
		));
		tblSelected.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblSelected.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblSelected.getColumnModel().getColumn(6).setPreferredWidth(35);
		tblSelected.setRowHeight(28);
		tblSelected.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		tblSelected.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tblSelected.setBounds(0, 10, 580, 308);
		panelSelected.add(tblSelected);
		
		final JButton btnCcl01 = new JButton("\u9000\u8BFE");
		btnCcl01.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl01.setBounds(579, 37, 71, 28);
		btnCcl01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl01)
				btnCcl01.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl01);
		
		final JButton btnCcl02 = new JButton("\u9000\u8BFE");
		btnCcl02.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl02.setBounds(579, 67, 71, 28);
		btnCcl02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl02)
				btnCcl02.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl02);
		
		final JButton btnCcl03 = new JButton("\u9000\u8BFE");
		btnCcl03.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl03.setBounds(579, 95, 71, 28);
		btnCcl03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl03)
				btnCcl03.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl03);
		
		final JButton btnCcl04 = new JButton("\u9000\u8BFE");
		btnCcl04.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl04.setBounds(579, 122, 71, 28);
		btnCcl04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl04)
				btnCcl04.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl04);
		
		final JButton btnCcl05 = new JButton("\u9000\u8BFE");
		btnCcl05.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl05.setBounds(579, 149, 71, 28);
		btnCcl05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl05)
				btnCcl05.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl05);
		
		final JButton btnCcl06 = new JButton("\u9000\u8BFE");
		btnCcl06.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl06.setBounds(579, 178, 71, 28);
		btnCcl06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl06)
				btnCcl06.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl06);
		
		final JButton btnCcl07 = new JButton("\u9000\u8BFE");
		btnCcl07.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl07.setBounds(579, 206, 71, 28);
		btnCcl07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl07)
				btnCcl07.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl07);
		
		final JButton btnCcl08 = new JButton("\u9000\u8BFE");
		btnCcl08.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl08.setBounds(579, 234, 71, 28);
		btnCcl08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl08)
				btnCcl08.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl08);
		
		final JButton btnCcl09 = new JButton("\u9000\u8BFE");
		btnCcl09.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl09.setBounds(579, 261, 71, 28);
		btnCcl09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl09)
				btnCcl09.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl09);
		
		final JButton btnCcl10 = new JButton("\u9000\u8BFE");
		btnCcl10.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		btnCcl10.setBounds(579, 289, 71, 28);
		btnCcl10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCcl10)
				btnCcl10.setEnabled(false);
				}
			});
		panelSelected.add(btnCcl10);
		
		JLabel label = new JLabel("\u9000\u8BFE");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 14));
		label.setBounds(579, 9, 71, 28);
		panelSelected.add(label);
		
		final CardLayout card = new CardLayout();
		cardpanel.setLayout(card);
		
		
		cardpanel.add("Cur", panelCur);
		cardpanel.add("Inqry",panelInqry);
		cardpanel.add("SelSym", panelSelSym);
		cardpanel.add("Selected", panelSelected);
		
		final JButton btnCur = new JButton("\u8BFE\u7A0B\u8868");
		btnCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCur){
//					btnCur.setEnabled(false);
					card.show(cardpanel, "Cur");
				}
			}
		});
		btnCur.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnCur.setBounds(60, 70, 110, 40);
		contentPane.add(btnCur);
		
		final JButton btnInqry = new JButton("\u6210\u7EE9\u67E5\u8BE2");
		btnInqry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnInqry){
//					btnInqry.setEnabled(false);
					card.show(cardpanel, "Inqry");
				}
			}
		});
		btnInqry.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnInqry.setBounds(240, 70, 110, 40);
		contentPane.add(btnInqry);
		
		final JButton btnSelSym = new JButton("\u9009\u8BFE\u7CFB\u7EDF");
		btnSelSym.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSelSym){
//					btnSelSym.setEnabled(false);
					card.show(cardpanel, "SelSym");
				}
			}
		});
		btnSelSym.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnSelSym.setBounds(420, 70, 110, 40);
		contentPane.add(btnSelSym);
		
		final JButton btnSelected = new JButton("\u5DF2\u9009\u8BFE\u7A0B");
		btnSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSelected){
//					btnSelected.setEnabled(false);
					card.show(cardpanel, "Selected");
				}
			}
		});
		btnSelected.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15));
		btnSelected.setBounds(600, 70, 110, 40);
		contentPane.add(btnSelected);
	}
}