/***
 * 
 * 
 * OrderHistoryTab.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.25
 * 商店查看历史订单功能类
 *
 */
package edu.seu.vcampus.client.shop;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.only.OnlyScrollPane;
import com.only.OnlyTable;
import edu.seu.vcampus.io.Client;
import edu.seu.vcampus.util.Goods;
import edu.seu.vcampus.util.Message;
import edu.seu.vcampus.util.ShopRecord;

public class OrderHistoryTab {
	private JPanel pane_OnlineMarket_Record;
	private int Ecard;
	private DefaultTableModel defaultModel;
	private OnlyTable tblOMRecord;
	
	public OrderHistoryTab(int EcardNumber, JPanel panel){
		this.Ecard = EcardNumber;
		pane_OnlineMarket_Record = new JPanel();
		pane_OnlineMarket_Record.setBounds(0, 0, 811, 422);
		panel.add(pane_OnlineMarket_Record);
		pane_OnlineMarket_Record.setLayout(null);
		pane_OnlineMarket_Record.setBackground(Color.WHITE);
		
		String[] n = {"商品编号","商品名称","商品数量","商品价格(元)","购买时间","商品描述"};
		defaultModel = new DefaultTableModel(null,n) {
			private static final long serialVersionUID = 975854289835222403L;
			public boolean isCellEditable(int row, int column) {
					return false;
			}
		};
		tblOMRecord = new OnlyTable();
		tblOMRecord.setModel(this.defaultModel);
		OnlyScrollPane sp = new OnlyScrollPane(tblOMRecord);
		sp.setViewportView(tblOMRecord);
		sp.setBounds(0, 0, 811, 422);
		pane_OnlineMarket_Record.add(sp);
	}
	
	void fresh() {
		Message senderMessage = new Message(Ecard);
		senderMessage.setType(1803);
		try {
			Message messageOM =  new Client().start(senderMessage);
			ArrayList<ShopRecord> recordList = messageOM.getShopRecord();
			ArrayList<Goods> goodsList = messageOM.getGoodsList();
			if (messageOM.getType() == 1101) {//返回数据成功
				double totalPrice=0;
				
				int goodsNumber = recordList.size();
				if(goodsNumber == 0){
					JOptionPane.showMessageDialog(null, "Error：没有购物记录"); 
				} else {
					defaultModel.setRowCount(0);
					for (int index = 0; index < goodsNumber; ++index) {
						Vector<String> tempVector = new Vector<String>(6);
						tempVector.add(""+goodsList.get(index).getID());
						tempVector.add(""+goodsList.get(index).getName());
						tempVector.add(""+recordList.get(index).getGoodsNumber());
						tempVector.add(""+goodsList.get(index).getPrice());
						tempVector.add(recordList.get(index).getTime().toString());
						tempVector.add(goodsList.get(index).getContent());
						defaultModel.addRow(tempVector);
						totalPrice = totalPrice + goodsList.get(index).getPrice()*recordList.get(index).getGoodsNumber();
					}
				}
				Vector<String> tempVector = new Vector<String>(6);
				tempVector.add("总价格");tempVector.add("");tempVector.add("");
				tempVector.add(String.format("%.3f", totalPrice));tempVector.add("");tempVector.add("");
				defaultModel.addRow(tempVector);
			} else {
				JOptionPane.showMessageDialog(null, "Error：未接收到信息 "); 
			}
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
	}

}