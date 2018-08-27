/**
 * BasicInfoTab.java
 * 个人信息界面
 * @author sujinmiao
 * @version 1.0
 * 2018.8.24
 * @author gutingxuan
 * @version 2.0
 * 2018.8.25
 * 添加界面刷新函数
 */
package edu.seu.vcampus.client;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import edu.seu.vcampus.io.Client;
import edu.seu.vcampus.util.Message;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Group;

public class BasicInfoTab extends ApplicationWindow {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text_11;
	private static int Ecard;

	/**
	 * Create the application window.
	 */
	public BasicInfoTab(int EcardNumber) {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
		Ecard = EcardNumber;
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		Button button = new Button(container, SWT.NONE);
		button.setBounds(88, 188, 80, 27);
		button.setText("\u4E0A\u4F20\u5934\u50CF");
		
		Button button_1 = new Button(container, SWT.NONE);
		button_1.setBounds(539, 346, 80, 27);
		button_1.setText("\u7EF4\u62A4\u4FE1\u606F");
		
		Button button_2 = new Button(container, SWT.NONE);
		button_2.setBounds(680, 346, 80, 27);
		button_2.setText("\u786E\u8BA4\u4FEE\u6539");
		
		Label label = new Label(container, SWT.NONE);
		label.setBounds(276, 49, 61, 17);
		label.setText("\u59D3\u540D");
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setBounds(539, 49, 61, 17);
		label_1.setText("\u62FC\u97F3");
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setBounds(276, 97, 61, 17);
		label_2.setText("\u5B66\u53F7");
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setBounds(539, 97, 61, 17);
		label_3.setText("\u4E00\u5361\u901A");
		
		Label label_4 = new Label(container, SWT.NONE);
		label_4.setBounds(276, 145, 61, 17);
		label_4.setText("\u6027\u522B");
		
		Label label_5 = new Label(container, SWT.NONE);
		label_5.setBounds(539, 145, 61, 17);
		label_5.setText("\u751F\u65E5");
		
		Label label_6 = new Label(container, SWT.NONE);
		label_6.setBounds(276, 198, 61, 17);
		label_6.setText("\u8EAB\u4EFD\u8BC1\u53F7");
		
		Label label_7 = new Label(container, SWT.NONE);
		label_7.setBounds(539, 198, 61, 17);
		label_7.setText("\u5730\u5740");
		
		Label label_8 = new Label(container, SWT.NONE);
		label_8.setBounds(276, 251, 61, 17);
		label_8.setText("\u7535\u8BDD");
		
		Label label_9 = new Label(container, SWT.NONE);
		label_9.setBounds(539, 304, 61, 17);
		label_9.setText("\u4E13\u4E1A");
		
		Label label_10 = new Label(container, SWT.NONE);
		label_10.setBounds(276, 304, 61, 17);
		label_10.setText("\u9662\u7CFB");
		
		Label label_11 = new Label(container, SWT.NONE);
		label_11.setBounds(539, 251, 61, 17);
		label_11.setText("\u90AE\u7BB1");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(343, 49, 159, 23);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(343, 97, 159, 23);
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(343, 145, 159, 23);
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setBounds(343, 198, 159, 23);
		
		text_4 = new Text(container, SWT.BORDER);
		text_4.setBounds(343, 251, 159, 23);
		
		text_5 = new Text(container, SWT.BORDER);
		text_5.setBounds(343, 304, 159, 23);
		
		text_6 = new Text(container, SWT.BORDER);
		text_6.setBounds(605, 49, 159, 23);
		
		//一卡通
		text_7 = new Text(container, SWT.BORDER);
		text_7.setBounds(606, 97, 158, 23);
		text_7.setText(String.valueOf(Ecard));
		
		text_8 = new Text(container, SWT.BORDER);
		text_8.setBounds(606, 145, 158, 23);
		
		text_9 = new Text(container, SWT.BORDER);
		text_9.setBounds(605, 198, 159, 23);
		
		text_10 = new Text(container, SWT.BORDER);
		text_10.setBounds(605, 251, 159, 23);
		
		text_11 = new Text(container, SWT.BORDER);
		text_11.setBounds(606, 304, 158, 23);
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setBounds(71, 49, 116, 116);

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			BasicInfoTab window = new BasicInfoTab(Ecard);
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(902, 512);
	}
	
	/*
	 * 界面刷新函数
	 */
	public void fresh() {
		final Message senderMessage = new Message();
		senderMessage.setType(1301);
		senderMessage.setEcardNumber(Ecard);
		//异步处理
		{
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							//开始传送对象，并接收服务器返回的对象，这句不用改
							Message message = new Client().start(senderMessage);
							break;
						}catch (ClassNotFoundException e) {e.printStackTrace();}
					}
				}
			}).start();
		}
	
	}

}
