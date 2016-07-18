package jdk8features;

import java.awt.Button;
import java.awt.Frame;

public class FrameLambdaTest {

	public static void main(String[] args) {
		Frame frame = new Frame("我的窗口");
		frame.setBounds(200, 500, 500, 400);
		// frame.setLayout(null);
		frame.setVisible(true);

		Button but = new Button("test button");
		but.setBounds(100, 100, 100, 100);
		but.addActionListener((e) -> {
			System.out.println("按钮被点击了");
		});
		frame.add(but);

	}

}
