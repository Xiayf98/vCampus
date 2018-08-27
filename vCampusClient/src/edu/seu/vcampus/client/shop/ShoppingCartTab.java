/***
 * 
 * ShoppingCartTab.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.26
 * �̵깺�ﳵ������
 *
 */

package edu.seu.vcampus.client.shop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.only.OnlyScrollPane;
import com.only.OnlyTable;
import edu.seu.vcampus.client.tablechange.TablePanelEdit_Goods;
import edu.seu.vcampus.client.tablechange.TablePanelRender;
import edu.seu.vcampus.io.Client;
import edu.seu.vcampus.util.Goods;
import edu.seu.vcampus.util.Message;
import edu.seu.vcampus.util.ShopBasket;


public class ShoppingCartTab {
	private JPanel pnlShoppingCart;

	private OnlyTable tableShoppingCart;
	private OnlyScrollPane scrShoppingCartList;
	private DefaultTableModel tableShoppingCartEdit;
	private JLabel lblTotalPrice;
	private JButton btnConfirmPurchase;
	private int Ecard;
	private JLabel lblNewLabel;

	public ShoppingCartTab(int ecard, JPanel pnl) {
		// TODO Auto-generated constructor stub
		this.Ecard = ecard;

		pnlShoppingCart = new JPanel();
		pnlShoppingCart.setBounds(0, 0, 811, 422);
		pnlShoppingCart.setLayout(null);
		pnlShoppingCart.setOpaque(false);
		pnl.add(pnlShoppingCart);

		lblTotalPrice = new JLabel("0.00Ԫ");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTotalPrice.setBounds(550, 400, 109, 31);
		pnlShoppingCart.add(lblTotalPrice);

		final String[] tableColumnNames = { "" };
		tableShoppingCart = new OnlyTable();

		tableShoppingCart
				.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {

						int rowCount = tableShoppingCart.getRowCount();
						double allPrica = 0.0;
						for (int i = 0; i < rowCount; ++i) {
							String temp = (String) tableShoppingCart
									.getValueAt(i, 0);
							String[] strTemp = temp.split("~");
							double price = Double.parseDouble(strTemp[2]
									.replace("Ԫ", ""))
									* Double.parseDouble(strTemp[3]);
							allPrica += price;

						}
						allPrica = new BigDecimal(allPrica).setScale(1,
								BigDecimal.ROUND_HALF_UP).doubleValue();
						lblTotalPrice.setText(allPrica + "Ԫ");
					}
				}

				);
		tableShoppingCart.setRowHeight(150);
		scrShoppingCartList = new OnlyScrollPane();
		scrShoppingCartList.setViewportView(this.tableShoppingCart);
		scrShoppingCartList.setBounds(0, 0, 811, 390);

		pnlShoppingCart.add(scrShoppingCartList);

		tableShoppingCartEdit = new DefaultTableModel(null, tableColumnNames);
		tableShoppingCart.setModel(this.tableShoppingCartEdit);

		tableShoppingCart.getColumnModel().getColumn(0)
				.setCellRenderer(new TablePanelRender());
		tableShoppingCart
				.getColumnModel()
				.getColumn(0)
				.setCellEditor(
						new TablePanelEdit_Goods(tableShoppingCart, ecard));

		btnConfirmPurchase = new JButton("ȷ�Ϲ���");
		btnConfirmPurchase.setBounds(718, 399, 93, 23);
		btnConfirmPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Message messageSend = new Message(Ecard);
				messageSend.setType(1807);//������Ʒ
				try {
					Message messageBack = new Client().start(messageSend);
					if (messageBack.getType() == 1101) {
						tableShoppingCartEdit.setRowCount(0);// ��ձ��
						JOptionPane.showMessageDialog(null, "����ɹ���");
					} else {
						if (messageBack.getType() == 1810) {//��������
							JOptionPane.showMessageDialog(null, "���㣡");
						} else {
							JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
						}
					}
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}

			}
		});
		pnlShoppingCart.add(btnConfirmPurchase);
		
		lblNewLabel = new JLabel("\u603B\u4EF7\uFF1A");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(535, 400, 54, 31);
		pnlShoppingCart.add(lblNewLabel);
	}

	void fresh() {
		Message messageSend = new Message(Ecard);
		messageSend.setType(1802);//��ʾ���ﳵ��Ϣ
		try {
			Message messageBack = new Client().start(messageSend);
			if (messageBack.getType() == 1101) {
				tableShoppingCartEdit.setRowCount(0);// ��ձ��
				ArrayList<ShopBasket> shopbasketList = messageBack
						.getShopbasketList();
				ArrayList<Goods> goodsList = messageBack.getGoodsList();
				for (int i = 0; i < shopbasketList.size(); ++i) {
					String value = goodsList.get(i).getID() + "~"
							+ goodsList.get(i).getName() + "~"
							+ goodsList.get(i).getPrice() + "Ԫ~"
							+ shopbasketList.get(i).getGoodNumber();
					tableShoppingCartEdit.addRow(new Object[] { value });
				}

			} else {
				JOptionPane.showMessageDialog(null, "Error����ȡ���ﳵ����ʧ�ܣ�");
			}
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
	}

}
