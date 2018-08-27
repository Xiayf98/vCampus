/**
 * 
 * TablePanelRender.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.26
 * 表格按钮渲染器类
 *
 */
package edu.seu.vcampus.client.tablechange;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import com.only.OnlySpinner;

public class TablePanelRender implements TableCellRenderer {
	private JPanel panel;
	private OnlySpinner spnGoodsCount;
	private JLabel lblGoodsImage;
	private JLabel lblGoodsSinglePrice;
	private JButton btnGoodsDelete;
	private JLabel lblGoodsName;
	private JSeparator separator;

	public TablePanelRender() {

		this.panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setOpaque(false);
		this.panel.setBounds(0, 1, 811, 149);
		panel.setLayout(null);

		spnGoodsCount = new OnlySpinner();
		spnGoodsCount.setBounds(540, 55, 90, 40);
		panel.add(spnGoodsCount);

		lblGoodsImage = new JLabel("");
		lblGoodsImage.setBackground(Color.WHITE);
		lblGoodsImage.setBounds(40, 15, 166, 120);
		panel.add(lblGoodsImage);

		lblGoodsSinglePrice = new JLabel("");
		lblGoodsSinglePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGoodsSinglePrice.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblGoodsSinglePrice.setBounds(400, 55, 80, 40);
		panel.add(lblGoodsSinglePrice);

		btnGoodsDelete = new JButton("删除");
		btnGoodsDelete.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnGoodsDelete.setBounds(680, 55, 80, 40);
		panel.add(btnGoodsDelete);

		lblGoodsName = new JLabel();
		lblGoodsName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoodsName.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblGoodsName.setBounds(230, 55, 120, 40);
		panel.add(lblGoodsName);

		separator = new JSeparator();
		separator.setForeground(new Color(230, 230, 230));
		separator.setBounds(0, 148, 811, 1);
		panel.add(separator);

	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {		String temp = value == null ? "~~~" : String.valueOf(value);
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

			return this.panel;}

}
