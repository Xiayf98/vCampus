/***
 * 
 * ShopTab.java
 * @author XiaYifan
 * @version 1.0
 * 2018.8.24
 * 商店功能跳转管理类
 *
 */
package edu.seu.vcampus.client.shop;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.only.OnlyButton;
import edu.seu.vcampus.client.Login;


public class ShopTab implements ActionListener{
	private JPanel shopTab;
	private JPanel switchPane;
	private CardLayout cardLayout;
	private JPanel pnlShoppingCart;
	private JPanel pnlOrderHistory;
	
	public PurchaseTab objPurchase;
	public ShoppingCartTab objShopbasket;
	public OrderHistoryTab objRecord;

	private OnlyButton btnMarket;
	private OnlyButton btnShoppingCart;
	private OnlyButton btnOrderHistory;

	private int Ecard;

	public ShopTab(JPanel tempPane,int e) {
		this.Ecard = e;
		
		shopTab = new JPanel();
		shopTab.setBounds(0, 0, 811, 448);
		shopTab.setOpaque(false);
		shopTab.setLayout(null);
		tempPane.add(shopTab);
		
		
		// 初始化切换面板
		switchPane = new JPanel();
		switchPane.setBounds(0, 44, 811, 404);
		switchPane.setOpaque(false);
		cardLayout = new CardLayout();
		switchPane.setLayout(cardLayout);
		shopTab.add(switchPane);

		pnlShoppingCart = new JPanel();
		pnlShoppingCart.setBounds(0, 0, 811, 422);
		pnlShoppingCart.setOpaque(false);
		switchPane.add("pnlShoppingCart", pnlShoppingCart);
		pnlShoppingCart.setLayout(null);
		objShopbasket = new ShoppingCartTab(Ecard, pnlShoppingCart);

		pnlOrderHistory = new JPanel();
		pnlOrderHistory.setBounds(0, 0, 811, 422);
		pnlOrderHistory.setOpaque(false);
		switchPane.add("pnlBuyLog", pnlOrderHistory);
		pnlOrderHistory.setLayout(null);
		objRecord = new OrderHistoryTab(Ecard, pnlOrderHistory);

		//添加上方Tab
		btnMarket = new OnlyButton();
		btnMarket.setActionCommand("btnMarket");
		btnMarket.setBounds(68, 0, 170, 40);
		btnMarket.setIcon(new ImageIcon(Login.class
				.getResource("/ImageShopTab/main_marketTab.png")));
		btnMarket.addActionListener(this);
		shopTab.add(btnMarket);

		btnShoppingCart = new OnlyButton();
		btnShoppingCart.setActionCommand("btnShoppingCart");
		btnShoppingCart.setBounds(323, 0, 170, 40);
		btnShoppingCart.setIcon(new ImageIcon(Login.class
				.getResource("/ImageShopTab/main_ShoppingCartTab.png")));
		btnShoppingCart.addActionListener(this);
		shopTab.add(btnShoppingCart);
		
		btnOrderHistory = new OnlyButton();
		btnOrderHistory.setActionCommand("btnOrderHistory");
		btnOrderHistory.setBounds(572, 0, 170, 40);
		btnOrderHistory.setIcon(new ImageIcon(Login.class
				.getResource("/ImageShopTab/main_OrderHistoryTab.png")));
		btnOrderHistory.addActionListener(this);
		shopTab.add(btnOrderHistory);
		tempPane.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		switch (cmd) {
		case "btnMarket":
			System.out.println("显示商场");
			cardLayout.show(switchPane, "pnlMarket");
			objPurchase.fresh();
			break;
		case "btnShoppingCart":
			System.out.println("显示购物车");
			cardLayout.show(switchPane, "pnlShoppingCart");
			objShopbasket.fresh();
			break;
		case "btnOrderHistory":
			System.out.println("显示历史订单");
			cardLayout.show(switchPane, "pnlOrderHistory");
			objRecord.fresh();
			break;
		}
	}
}
