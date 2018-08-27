/**
 * 
 * TablePanelEdit_Goods.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.26
 * 商品表格按钮渲染器类
 *
 */

package edu.seu.vcampus.client.tablechange;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.only.OnlySpinner;
import edu.seu.vcampus.io.Client;
import edu.seu.vcampus.util.Message;
public class TablePanelEdit_Goods extends DefaultCellEditor{
	private static final long serialVersionUID = -1946453942442745999L;
	private JPanel panel;
	private OnlySpinner spnGoodsCount;
	private JLabel lblGoodsImage;
	private JLabel lblGoodsSinglePrice;
	private JButton btnGoodsDelete;
	private JLabel lblGoodsName;
	private JSeparator separator;

	public TablePanelEdit_Goods(final JTable table, final int Ecard) {
		super(new JTextField());
		// TODO Auto-generated constructor stub

		// 设置点击几次激活编辑。
		this.setClickCountToStart(1);

		this.panel = new JPanel();
		this.panel.setBackground(Color.WHITE);
		this.panel.setOpaque(false);
		this.panel.setBounds(0, 1, 811, 149);
		this.panel.setLayout(null);

		this.spnGoodsCount = new OnlySpinner();
		this.spnGoodsCount.setBounds(540, 55, 90, 40);
		spnGoodsCount.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Message messageSend = new Message(Ecard);
				messageSend.setType(1808);//修改件数
				messageSend.setData(lblGoodsImage.getText() + ";"
						+ spnGoodsCount.getValue());
				try {
					new Client().start(messageSend);
					System.out.println("更改" + lblGoodsImage.getText() + "商品数量为："
							+ spnGoodsCount.getValue());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.spnGoodsCount.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					table.getTableHeader().grabFocus();
				}
			}

			public void keyPressed(KeyEvent e) {

			}

			public void keyReleased(KeyEvent e) {
				table.getTableHeader().grabFocus();
			}
		});
		this.panel.add(spnGoodsCount);

		lblGoodsImage = new JLabel("");
		lblGoodsImage.setBackground(Color.WHITE);
		lblGoodsImage.setBounds(40, 15, 166, 120);
		panel.add(lblGoodsImage);

		this.lblGoodsSinglePrice = new JLabel("");
		this.lblGoodsSinglePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		this.lblGoodsSinglePrice.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.lblGoodsSinglePrice.setBounds(400, 55, 80, 40);
		this.panel.add(lblGoodsSinglePrice);

		this.btnGoodsDelete = new JButton("删除");
		this.btnGoodsDelete.setFont(new Font("Dialog", Font.PLAIN, 14));
		this.btnGoodsDelete.setBounds(680, 55, 80, 40);
		this.panel.add(btnGoodsDelete);

		this.btnGoodsDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 触发取消编辑的事件，不会调用tableModel的setValue方法。
				TablePanelEdit_Goods.this.fireEditingCanceled();

				String temp = (String) table.getValueAt(table.getSelectedRow(),
						0);
				String[] strTemp = temp.split("~");
				deleteGoods(strTemp[0], table, Ecard);
				System.out.println("删除商品" + strTemp[0]);
			}
			// 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。

		});

		this.lblGoodsName = new JLabel();
		this.lblGoodsName.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblGoodsName.setFont(new Font("Dialog", Font.PLAIN, 17));
		this.lblGoodsName.setBounds(230, 55, 120, 40);
		this.panel.add(lblGoodsName);

		this.separator = new JSeparator();
		this.separator.setForeground(new Color(230, 230, 230));
		this.separator.setBounds(0, 148, 811, 1);
		this.panel.add(separator);

	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// 只为按钮赋值即可。也可以作其它操作。
		String temp = value == null ? "~~~" : String.valueOf(value);
		String[] strTemp = temp.split("~");

		String number = strTemp[0];
		String name = strTemp[1];
		String price = strTemp[2];
		int count = Integer.parseInt(strTemp[3]);

		String path = new File("").getAbsolutePath().replace('\\', '/')
				+ "/smallImage/GoodsImage/";
		try {
			BufferedImage imageBuffered = ImageIO.read(new FileInputStream(path
					+ number + ".jpg"));
			BufferedImage imageBufferedSmall = new BufferedImage(166, 120,
					BufferedImage.TYPE_INT_BGR);
			Graphics2D graphics = (Graphics2D) imageBufferedSmall.getGraphics();
			graphics.drawImage(imageBuffered, 0, 0, 166, 120, null);
			graphics.dispose();
			imageBufferedSmall.flush();

			String newImgPath = new File("").getAbsolutePath().replace('\\',
					'/')
					+ "/smallImage/GoodsBasketImage/";
			File file = new File(newImgPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			ImageIO.write(imageBufferedSmall, "jpg", new File(newImgPath
					+ number + ".jpg"));
			this.lblGoodsImage.setIcon(new ImageIcon(
					(newImgPath + number + ".jpg")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.lblGoodsImage.setText(number);
		this.lblGoodsName.setText(name.equals("") ? "商品名称" : name);
		this.lblGoodsSinglePrice.setText(price.equals("") ? "0.00元" : price);
		this.spnGoodsCount.setValue(count > -1 ? count : 0);

		return this.panel;
	}

	@Override
	public Object getCellEditorValue() {
		String value = lblGoodsImage.getText() + "~" + lblGoodsName.getText()
				+ "~" + lblGoodsSinglePrice.getText() + "~"
				+ spnGoodsCount.getValue();
		return value;
	}

	private void deleteGoods(String number, JTable table, int Ecard) {

		Message messageSend = new Message(Ecard);
		messageSend.setType(1806);//退选商品
		messageSend.setData(number);
		try {
			Message messageBack = new Client().start(messageSend);
			if (messageBack.getType() == 1101) {
				if (table.getSelectedRow() > -1) {
					((DefaultTableModel) table.getModel()).removeRow(table
							.getSelectedRow());
				}
				System.out.println("删除商品" + number + "成功");
			} else {
				System.out.println("删除商品" + number + "失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
