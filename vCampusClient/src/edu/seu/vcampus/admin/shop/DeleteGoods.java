/**
 * 
 * DeleteGoods.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.26
 * 删除商品功能类
 *
 */

package edu.seu.vcampus.admin.shop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.seu.vcampus.io.Client;
import edu.seu.vcampus.util.Goods;
import edu.seu.vcampus.util.Message;

public class DeleteGoods {
	JTextField Info = new JTextField(20);
	JLabel jLabel = new JLabel("商品编号");
	JButton jb1;
	JPanel BigPanel = new JPanel();
	//private int Ecard;

	public DeleteGoods(int e, JPanel panel) {
		
		//this.Ecard = e;
		
		BigPanel = new JPanel();
		BigPanel.setBounds(0, 0, 811, 448);
		BigPanel.setOpaque(false);
		BigPanel.setLayout(null);
		BigPanel.setLayout(null);
		panel.add(BigPanel);
		jb1 = new JButton("确认");
		jb1.setFont(new Font("华文楷体", Font.PLAIN, 18));
		jb1.setBounds(516, 138, 106, 40);
		BigPanel.add(jb1);
		jLabel.setFont(new Font("华文楷体", Font.PLAIN, 18));
		jLabel.setBounds(109, 138, 106, 40);
		BigPanel.add(jLabel);
		Info.setBounds(242, 140, 204, 40);
		BigPanel.add(Info);

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Goods mc = new Goods();
				String num = new String();
				num = Info.getText();
				mc.setID(Integer.parseInt(num));
				Message msg = new Message();
				msg.setgood(mc);
				msg.setType(2008);

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
