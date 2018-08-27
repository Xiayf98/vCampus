/**
 * 
 * AddGoods.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.26
 * 添加商品功能类
 *
 */

package edu.seu.vcampus.admin.shop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.only.OnlyFileChooser;
import edu.seu.vcampus.io.Client;
import edu.seu.vcampus.util.ByteArray;
import edu.seu.vcampus.util.Goods;
import edu.seu.vcampus.util.Message;

public class AddGoods {
	JButton jb1, jb2;
	JPanel BigPanel = new JPanel();
	ByteArray byteArray = new ByteArray();
	JLabel _image = new JLabel();
	
	public AddGoods(int e, JPanel panel) {
		BigPanel = new JPanel();
		BigPanel.setBounds(0, 0, 811, 448);
		BigPanel.setOpaque(false);
		BigPanel.setLayout(null);
		panel.add(BigPanel);
		
		JLabel JLableGoodsNumber = new JLabel();
		JLableGoodsNumber.setLocation(75, 133);
		JLableGoodsNumber.setSize(81, 39);
		final JTextField JTextFieldGoodsNumber = new JTextField(15);
		JTextFieldGoodsNumber.setSize(108, 34);
		JTextFieldGoodsNumber.setLocation(162, 136);
		JLableGoodsNumber.setText("商品数量");
		BigPanel.add(JLableGoodsNumber);
		BigPanel.add(JTextFieldGoodsNumber);
		
		JLabel JLableGoodsID = new JLabel();
		JLableGoodsID.setLocation(75, 29);
		JLableGoodsID.setSize(81, 39);
		JLableGoodsID.setText("商品编号");			
		final JTextField JTextFieldGoodsID = new JTextField(30);
		JTextFieldGoodsID.setLocation(162, 32);
		JTextFieldGoodsID.setSize(108, 34);
		BigPanel.add(JLableGoodsID);
		BigPanel.add(JTextFieldGoodsID);
		
	
		JLabel JLableGoodsPrice = new JLabel();
		JLableGoodsPrice.setLocation(75, 223);
		JLableGoodsPrice.setSize(81, 39);
		final JTextField JTextFieldGoodsPrice = new JTextField(15);
		JTextFieldGoodsPrice.setLocation(162, 226);
		JTextFieldGoodsPrice.setSize(108, 34);
		JLableGoodsPrice.setText("单价");
		BigPanel.add(JLableGoodsPrice);
		BigPanel.add(JTextFieldGoodsPrice);
		
		JLabel JLableGoodsPic = new JLabel();
		JLableGoodsPic.setLocation(355, 29);
		JLableGoodsPic.setSize(81, 39);
		final JTextField JTextFieldGoodsPic = new JTextField();
		JTextFieldGoodsPic.setLocation(446, 74);
		JTextFieldGoodsPic.setSize(108, 34);
		JLableGoodsPic.setText("图片路径");
		BigPanel.add(JLableGoodsPic);
		BigPanel.add(JTextFieldGoodsPic);
		
		JButton btn_UploadPhoto = new JButton("\u4E0A\u4F20\u56FE\u7247");
		btn_UploadPhoto.setBounds(444, 37, 93, 23);
		BigPanel.add(btn_UploadPhoto);
		
		btn_UploadPhoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				JFileChooser chooser = new JFileChooser();
				BigPanel.add(chooser);
				chooser.setLocation(159, 112);
				chooser.setSize(510, 327);
		
				chooser.setFileFilter(new FileNameExtensionFilter("JPG","jpg"));
				String imgPath = null;
				int returnVal = chooser.showOpenDialog(BigPanel);
				if (returnVal == OnlyFileChooser.APPROVE_OPTION) {
					imgPath = chooser.getSelectedFile().getAbsolutePath();
					JTextFieldGoodsPic.setText(imgPath);
					_image.setIcon(new ImageIcon(imgPath));
				}
		
				byte[] imageData = null;
				try {
					BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(image, "jpg", baos);
					imageData = baos.toByteArray();
					byteArray.setImageData(imageData);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
			}  
			}
		});
		
		
		JLabel JLableGoodsContent = new JLabel();
		JLableGoodsContent.setSize(81, 39);
		JLableGoodsContent.setLocation(355, 133);
		final JTextField JTextFieldGoodsContent = new JTextField();
		JTextFieldGoodsContent.setLocation(446, 136);
		JTextFieldGoodsContent.setSize(108, 34);
		JLableGoodsContent.setText("商品内容");
		BigPanel.add(JLableGoodsContent);
		BigPanel.add(JTextFieldGoodsContent);
		
		JLabel JLableGoodsName= new JLabel();
		JLableGoodsName.setLocation(355, 223);
		JLableGoodsName.setSize(81, 39);
		final JTextField JTextFieldGoodsName = new JTextField(15);
		JTextFieldGoodsName.setLocation(446, 226);
		JTextFieldGoodsName.setSize(108, 34);
		JLableGoodsName.setText("商品描述");
		BigPanel.add(JLableGoodsName);
		BigPanel.add(JTextFieldGoodsName);
		

		jb1 = new JButton("确认");
		jb1.setBounds(146, 339, 137, 39);
		BigPanel.add(jb1);
		jb2 = new JButton("取消");
		jb2.setBounds(355, 339, 137, 39);
		BigPanel.add(jb2);
			
		_image.setBounds(595, 29, 137, 143);
		BigPanel.add(_image);
				

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Goods mygood = new Goods();
				mygood.setID(Integer.parseInt(JTextFieldGoodsID.getText()));
				mygood.setNumber(Integer.parseInt(JTextFieldGoodsNumber.getText()));
				mygood.setPrice(Double.parseDouble(JTextFieldGoodsPrice.getText()));
				mygood.setPicturePath(JTextFieldGoodsPic.getText());
				mygood.setContent(JTextFieldGoodsContent.getText());
				mygood.setName(JTextFieldGoodsName.getText());

				Message msg = new Message();
				msg.setByteArray(byteArray);
				msg.setgood(mygood);
				msg.setType(2007);

				try {
					Message message = new Client().start(msg);
					if (message.getType() == 2101) {
						JOptionPane.showMessageDialog(null, "操作成功！");
					} else {
						JOptionPane.showMessageDialog(null, "Error：网络错误，请重试");
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		});
	}


}
