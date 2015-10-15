package study.base.gui;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * MenuBar�� Menu ,MenuItem�����Ӳ˵�
 * @author ldm
 *
 */
class MyMenuDemo {
	private Frame f;
	private MenuBar mb;
	private Menu m, subMenu;
	private MenuItem closeItem, subItem;

	MyMenuDemo() {
		init();
	}

	public void init() {
		f = new Frame("My window");
		f.setBounds(300, 100, 500, 600);
		f.setLayout(new FlowLayout());
		mb = new MenuBar();
		m = new Menu("Files");
		subMenu = new Menu("subFiles");
		subItem = new MenuItem("open");
		closeItem = new MenuItem("exit");

		mb.add(m);
		m.add(subMenu);
		subMenu.add(subItem);
		m.add(closeItem);

		f.setMenuBar(mb);
		myEvent();
		f.setVisible(true);

		m.add(closeItem);

	}

	private void myEvent() {
		closeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new MyMenuDemo();
	}
}
