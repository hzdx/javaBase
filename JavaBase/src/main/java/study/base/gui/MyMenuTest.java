package study.base.gui;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * fileDialog
 * @author ldm
 *
 */
class MyMenuTest {
	private Frame f;
	private MenuBar bar;
	private TextArea ta;
	private Menu m;
	private MenuItem openItem, saveItem, closeItem;
	private FileDialog openDia, saveDia;
	private File file;

	MyMenuTest() {
		init();
	}

	public void init() {
		f = new Frame("My window");
		f.setBounds(300, 100, 500, 600);
		// f.setLayout(new FlowLayout();
		bar = new MenuBar();
		m = new Menu("Files");
		openItem = new MenuItem("open");
		saveItem = new MenuItem("save");
		closeItem = new MenuItem("exit");

		ta = new TextArea(50, 40);
		bar.add(m);
		m.add(openItem);
		m.add(saveItem);
		m.add(closeItem);

		f.setMenuBar(bar);
		f.add(ta);

		openDia = new FileDialog(f, "��", FileDialog.LOAD);
		saveDia = new FileDialog(f, "����", FileDialog.SAVE);
		myEvent();
		f.setVisible(true);

		m.add(closeItem);

	}

	private void myEvent() {
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (file == null) {
					saveDia.setVisible(true);
					String dirPath = saveDia.getDirectory();
					String fileName = saveDia.getFile();
					if (dirPath == null || fileName == null)
						return;
					file = new File(dirPath, fileName);
				}
				try {
					BufferedWriter bufw = new BufferedWriter(new FileWriter(
							file));
					String text = ta.getText();
					bufw.write(text);
					// bufw.flush();
					bufw.close();
				} catch (IOException ex) {
					throw new RuntimeException();
				}

			}

		});
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();
				String fileName = openDia.getFile();
				// System.out.println(dirPath+"..."+fileName);
				file = new File(dirPath, fileName);
				if (dirPath == null || fileName == null)
					return;
				ta.setText("");
				try {
					BufferedReader bufr = new BufferedReader(new FileReader(
							file));
					String line = null;
					while ((line = bufr.readLine()) != null) {
						ta.append(line + "\t\n");
					}
					bufr.close();
				} catch (IOException ex) {
					throw new RuntimeException("��ʧ��");
				}

			}
		});

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
		new MyMenuTest();
	}
}
