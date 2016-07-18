package gui;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class MyWindowDemo {
	public static void main(String[] args) {
		new MyWindowDemo();
	}

	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;
	private Dialog d;
	private Label lab;

	private Button okBut;

	MyWindowDemo() {
		init();
	}

	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());

		tf = new TextField(60);
		but = new Button("skip");
		ta = new TextArea(25, 70);

		d = new Dialog(f, "my dialog", true);
		d.setBounds(400, 200, 200, 100);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("yes");

		d.add(lab);
		d.add(okBut);

		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();

		f.setVisible(true);
	}

	private void myEvent() {
		okBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
		d.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}
		});

		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showDir();
			}

			/*
			 * String text = tf.getText(); ta.setText(text);
			 * System.out.println(text); tf.setText("");
			 */

		});

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					showDir();
			}
		});
	}

	public void showDir() {
		String dirPath = tf.getText();
		File dir = new File(dirPath);
		if (dir.exists() && dir.isDirectory()) {
			ta.setText("");
			String[] names = dir.list();
			for (String name : names) {
				ta.append(name + "\r\n");
			}
		} else {
			String info = "<" + dirPath + ">";
			lab.setText(info);
			d.setVisible(true);
		}
	}
}
