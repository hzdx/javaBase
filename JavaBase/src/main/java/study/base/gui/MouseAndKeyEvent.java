package study.base.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MouseAndKeyEvent {
	private Frame f;
	private Button b;
	private TextField tf;

	MouseAndKeyEvent() {
		init();
	}

	public void init() {
		f = new Frame("abc");
		f.setBounds(400, 100, 500, 300);
		f.setLayout(new FlowLayout());

		tf = new TextField(20);

		b = new Button("haha");
		f.add(b);
		f.add(tf);

		myEvent();
		f.setVisible(true);

	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// keyAdapter keyPressed
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if (!((code) >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)) {
					System.out.println(code + "key pressed");
					e.consume();
				}
			}
		});

		//
		b.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
					// System.exit(0);
					System.out.println("ctrl+enter is run");
				System.out.println(KeyEvent.getKeyText(e.getKeyCode()) + "..."
						+ e.getKeyCode());
			}

		});

		// ActionListener actionPerformed
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("button actived");
			}
		});

		// mouseAdapter
		b.addMouseListener(new MouseAdapter() {
			private int count = 1;
			private int clickCount = 1;

			public void mouseEntered(MouseEvent e) {
				System.out.println("mouser enter" + count++);
			}

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
					System.out.println("mouse click" + clickCount++);
			}
		});
	}

	public static void main(String[] args) {
		new MouseAndKeyEvent();
	}
}