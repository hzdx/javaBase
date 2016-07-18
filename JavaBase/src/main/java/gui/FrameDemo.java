package gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {
	public static void main(String[] args) {
		new Frameshow();
	}
}

class Frameshow {
	private Frame f;
	private Button b;

	Frameshow() {
		init();
	}

	public void init() {
		f = new Frame("abc");
		f.setBounds(400, 100, 500, 300);
		f.setLayout(new FlowLayout());
		b = new Button("haha");
		f.add(b);

		myEvent();
		f.setVisible(true);

	}

	private void myEvent() {
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("click the button then window is closed");
				System.exit(0);
			}
		});

	}
}
