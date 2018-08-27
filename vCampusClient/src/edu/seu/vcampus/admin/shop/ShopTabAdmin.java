/**
 * 
 * ShopTabAdmin.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.26
 * 管理商品模块功能类
 *
 */

package edu.seu.vcampus.admin.shop;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.only.OnlyButton;
import edu.seu.vcampus.client.Login;

public class ShopTabAdmin implements ActionListener{
	private JPanel shopTab;
	private JPanel switchPane;
	private CardLayout cardLayout;

	private JPanel pnlAdd;
	private JPanel pnlDelete;


	public AddGoods addGoods;
	private OnlyButton btnAdd;
	private OnlyButton btnDelete;


	private int Ecard;

	public ShopTabAdmin(JPanel tempPane,int e) {
		this.Ecard = e;
		
		shopTab = new JPanel();
		shopTab.setBounds(0, 0, 811, 448);
		shopTab.setOpaque(false);
		shopTab.setLayout(null);
		tempPane.add(shopTab);
		
		
		// 初始化切换面板
		switchPane = new JPanel();
		switchPane.setBounds(0, 26, 811, 422);
		switchPane.setOpaque(false);
		cardLayout = new CardLayout();
		switchPane.setLayout(cardLayout);
		shopTab.add(switchPane);
		
		pnlAdd = new JPanel();
		pnlAdd.setBounds(0, 0, 811, 422);
		pnlAdd.setOpaque(false);
		switchPane.add("pnlAdd", pnlAdd);
		pnlAdd.setLayout(null);

		addGoods = new AddGoods(Ecard, pnlAdd);

		pnlDelete = new JPanel();
		pnlDelete.setBounds(0, 0, 811, 422);
		pnlDelete.setOpaque(false);
		switchPane.add("pnlDelete", pnlDelete);
		pnlDelete.setLayout(null);


		//添加上方Tab
		btnAdd = new OnlyButton();
		btnAdd.setActionCommand("btnAdd");
		btnAdd.setBounds(0, 0, 170, 26);
		btnAdd.setIcon(new ImageIcon(ShopTabAdmin.class.getResource("/ImageShopTab/goodsAdd.png")));
		btnAdd.addActionListener(this);
		shopTab.add(btnAdd);

		btnDelete = new OnlyButton();
		btnDelete.setActionCommand("btnDelete");
		btnDelete.setBounds(170, 0, 170, 26);
		btnDelete.setIcon(new ImageIcon(Login.class
				.getResource("/ImageShopTab/goodsDelete.png")));
		btnDelete.addActionListener(this);
		shopTab.add(btnDelete);
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "btnAdd":
			System.out.println("添加商品");
			cardLayout.show(switchPane, "pnlAdd");
			break;
		case "btnDelete":
			System.out.println("删除商品");
			cardLayout.show(switchPane, "pnlDelete");
			new DeleteGoods(Ecard, pnlDelete);
			break;

		}
		
	}

}