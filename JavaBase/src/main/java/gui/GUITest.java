package gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;

public class GUITest {

	public static void main(String[] args) {
		Frame frame = new Frame("我的窗口");
		frame.setBounds(400, 400, 500, 500);
		frame.setLayout(null);
		frame.setVisible(true);

		TextArea textArea = new TextArea();
		textArea.setBounds(300, 100, 200, 200);
		frame.add(textArea);

		Button but = new Button("Button1");
		but.setBounds(100, 100, 100, 100);
		but.addActionListener((e) -> {
			String text = textArea.getText();
			System.out.println(text);
			System.out.println("测试按钮1");
		});
		frame.add(but);

	}

}
