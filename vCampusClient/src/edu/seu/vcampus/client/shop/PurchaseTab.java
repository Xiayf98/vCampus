/***
 * 
 * PurchaseTab.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.24
 * 商店购买功能类
 *
 */
package edu.seu.vcampus.client.shop;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.seu.vcampus.io.Client;
import edu.seu.vcampus.util.ByteArray;
import edu.seu.vcampus.util.Goods;
import edu.seu.vcampus.util.Message;
public class PurchaseTab {
	static int count = 0;
	private int Ecard;
	private JPanel panel_Shop_Purchase;
	private JPanel panel_Goods;
	private JLabel lbl_Image;
	private JLabel lbl_Name;
	
	public PurchaseTab(final int EcardNumber,JPanel panel){
		this.Ecard = EcardNumber;
		panel_Shop_Purchase = new JPanel();
		panel_Shop_Purchase.setBounds(0, 0, 800, 400);
		panel.add(panel_Shop_Purchase);
		panel_Shop_Purchase.setLayout(null);
		panel_Shop_Purchase.setBackground(Color.WHITE);
		
		lbl_Image = new JLabel();
		lbl_Image.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Image.setBounds(30, 20, 351, 254);
		panel_Shop_Purchase.add(lbl_Image);
		
		lbl_Name = new JLabel();
		lbl_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Name.setBounds(30, 292, 351, 95);
		panel_Shop_Purchase.add(lbl_Name);
		
		panel_Goods = new JPanel();
		panel_Goods.setPreferredSize(new Dimension(380,500));
		panel_Shop_Purchase.add(panel_Goods);
		
		JScrollPane sp_Goods = new JScrollPane(panel_Goods);
		panel_Goods.setLayout(null);
		sp_Goods.setBounds(401, 22, 400, 362);
		panel_Shop_Purchase.add(sp_Goods);
		sp_Goods.getVerticalScrollBar().setUnitIncrement(50);
	}
	
	public void fresh() {
		if (count == 0) { //只接收图片一次 
			++count;
		try {
			Message senderMessage = new Message(Ecard);
			senderMessage.setType(1809);//显示商品信息
			final Message messageOM =  new Client().start(senderMessage);
			if (messageOM.getType() == 1101) {
				ArrayList<ByteArray> byteArrayList = messageOM.getByteArrayList();
				ArrayList<Goods> goodsList = messageOM.getGoodsList();
				int itemNumber = goodsList.size();
				
				
				
					for (int index = 0; index < byteArrayList.size(); ++index) {
				
						BufferedImage imageBuffered = ImageIO.read(new ByteArrayInputStream(byteArrayList.get(index).getImageData()));
						BufferedImage imageBufferedSmall = new BufferedImage(352, 254, BufferedImage.TYPE_INT_BGR);
						Graphics2D graphics = (Graphics2D)imageBufferedSmall.getGraphics();
						graphics.drawImage(imageBuffered, 0, 0, 352, 254, null);
						graphics.dispose();
						imageBufferedSmall.flush();			
					
						String newImgPath = new File("").getAbsolutePath().replace('\\', '/') + "/smallImage/GoodsImage/";
						File file = new File(newImgPath);
						if (!file.exists()) {
							file.mkdirs();
						}
						ImageIO.write(imageBufferedSmall, "jpg", new File(newImgPath+goodsList.get(index).getID()+".jpg"));
					}
				
				
				if(itemNumber > 5){
					panel_Goods.setPreferredSize(new Dimension(380,100*itemNumber));
				}
				
				for(int index = 0; index < itemNumber; ++index){
					final int x = index;
					
					final JPanel pane_Items = new JPanel();
					pane_Items.setBounds(0, index*100, 380, 100);
					pane_Items.setBorder(BorderFactory.createTitledBorder("")); //设置面板边框，实现分组框的效果
					pane_Items.setBorder(BorderFactory.createLineBorder(Color.black));//设置面板边框颜色
					pane_Items.setBackground(Color.WHITE);
					panel_Goods.add(pane_Items);
					pane_Items.setLayout(null);
					pane_Items.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							pane_Items.setBounds(5, x*100+5, 370, 90);
							pane_Items.setBackground(Color.LIGHT_GRAY);
						}
						@Override
						public void mouseReleased(MouseEvent e) {
							int number = messageOM.getGoodsList().get(x).getID();
							String path = new File("").getAbsolutePath().replace('\\', '/') + "/smallImage/GoodsImage/";
							lbl_Image.setIcon(new ImageIcon(path+number+".jpg"));
							
							lbl_Name.setText(messageOM.getGoodsList().get(x).getContent());
							pane_Items.setBounds(0, x*100, 380, 100);
							pane_Items.setBackground(Color.WHITE);
						}
					});
					
					JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setBounds(15, 15, 81, 21);
					pane_Items.add(label);
					
					JTextField txt_Name = new JTextField();
					txt_Name.setEditable(false);
					txt_Name.setBounds(94, 15, 96, 27);
					pane_Items.add(txt_Name);
					txt_Name.setColumns(10);
					txt_Name.setText(messageOM.getGoodsList().get(index).getName());
					
					JLabel label_1 = new JLabel("\u5546\u54C1\u4EF7\u683C");
					label_1.setHorizontalAlignment(SwingConstants.CENTER);
					label_1.setBounds(15, 61, 81, 21);
					pane_Items.add(label_1);
					
					JTextField txt_Price = new JTextField();
					txt_Price.setEditable(false);
					txt_Price.setBounds(94, 61, 96, 27);
					pane_Items.add(txt_Price);
					txt_Price.setColumns(10);
					txt_Price.setText(""+messageOM.getGoodsList().get(index).getPrice());
					
					final JTextField txt_Number = new JTextField();
					txt_Number.setBounds(287, 12, 57, 27);
					pane_Items.add(txt_Number);
					txt_Number.setColumns(10);
					
					
					JButton btn_Add = new JButton("\u52A0\u5165\u8D2D\u7269\u8F66");
					btn_Add.setBounds(236, 57, 123, 29);
					pane_Items.add(btn_Add);
					btn_Add.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							final String items_Number = txt_Number.getText();
							
							if( !Pattern.compile("[0-9]*").matcher(items_Number).matches() || items_Number.equals("")){
								JOptionPane.showMessageDialog(null, "请输入数字");
								txt_Number.setText("1");
							    return ;
							}
							   
							Message senderMessage = new Message(Ecard);
							senderMessage.setType(1805);					
							senderMessage.setData(messageOM.getGoodsList().get(x).getID()+";"+items_Number);
							
							try {
								Message message =  new Client().start(senderMessage);
								if (message.getType() == 1101) {
									JOptionPane.showMessageDialog(null, "加入购物车成功");
								} else {
									JOptionPane.showMessageDialog(null, "Error：加入购物车失败了"); 
								}
							} catch (ClassNotFoundException e2) {
								e2.printStackTrace();
							}	
						}
					});
					
					JLabel label_2 = new JLabel("\u6570\u91CF");
					label_2.setHorizontalAlignment(SwingConstants.CENTER);
					label_2.setBounds(203, 15, 81, 21);
					pane_Items.add(label_2);
				}
				
				if(itemNumber==0){
					JLabel lblNewLabel_7 = new JLabel("\u8FD8\u6CA1\u6709\u5546\u54C1\u53EF\u4EE5\u4E70\u3012_\u3012");
					lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_7.setBounds(0, 174, 398, 158);
					panel_Goods.add(lblNewLabel_7);
				} 
				
			} else {
				JOptionPane.showMessageDialog(null, "Error：接收数据出现问题"); 
			}
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
}
	
