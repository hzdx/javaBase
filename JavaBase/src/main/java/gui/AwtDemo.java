package gui;

/*
 

 */

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtDemo {
	public static void main(String[] args) {
		Frame f = new Frame("my awt");
		f.setSize(400, 300);
		f.setLocation(300, 200);
		f.setLayout(new FlowLayout());

		Button b = new Button("my bt");
		f.add(b);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("active.");
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("close window");
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("open window");
			}

		});

		f.setVisible(true);
		// System.out.println("hello world");
	}
}