package study.base.gui;

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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class MyIEByGUI {
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;
	private Dialog d;
	private Label lab;
	private Button okBut;

	MyIEByGUI() {
		init();
	}

	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());

		tf = new TextField(60);
		but = new Button("skip");
		ta = new TextArea(25, 70);

		d = new Dialog(f, "��ʾ��Ϣ-self", true);
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

	public void showDir() throws Exception {
		ta.setText("");
		String url = tf.getText();

		int index1 = url.indexOf("//") + 2;

		int index2 = url.indexOf("/", index1);

		String str = url.substring(index1, index2);
		String[] arr = str.split(":");
		String host = arr[0];
		int port = Integer.parseInt(arr[1]);
		String path = url.substring(index2);
		Socket s = new Socket(host, port);

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("GET " + path + " HTTP/1.1");
		out.println("Accept:*/*");
		out.println("Accept-Language:zh-cn");
		out.println("Host:192.168.183:11000");
		out.println("connection:closed");
		out.println();
		out.println();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		String line = null;
		while ((line = bufr.readLine()) != null) {
			ta.append(line);
		}
		s.close();

	}

	private void myEvent() {
		okBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}
		});

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showDir();
				} catch (Exception ex) {
				}
			}

			/*
			 * String text = tf.getText(); ta.setText(text);
			 * System.out.println(text); tf.setText("");
			 */

		});

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						showDir();
					} catch (Exception ex) {
					}
				}
			}
		});
	}

	public static void main(String[] args) throws Exception {
		new MyIEByGUI();
	}
}
