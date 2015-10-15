package study.base.gui;

/*
 ����ͼ�λ����棺
 1������Frame���塣
 2���Դ���������á�
 �����С��λ�ã����֡�
 3�����������
 4�������ͨ�����add������ӵ������С�
 5���ô�����ʾ��ͨ��setVisible(true)������


 �¼�������Ƶ��ص㣺
 1���¼�Դ������awt�����swing������Щͼ�ν��������
 2���¼���ÿһ���¼������Լ����еĶ�Ӧ�¼��͹����¼���
 3���������������Դ���ĳһ���¼��Ķ�������ֹһ�������Ѿ���װ���˼������С�
 4���¼����?�������ߣ�java�ж��Ѷ�����ˡ�
 ����Ҫ���ģ����ǶԲ���Ķ������д��?
 ��� Frame , WindowListner ��WindowAdapter

 */

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class AwtDemo {
	public static void main(String[] args) {
		Frame f = new Frame("my awt");
		f.setSize(400, 300);
		f.setLocation(300, 200);
		f.setLayout(new FlowLayout());

		Button b = new Button("һ����ť");
		f.add(b);

		f.addWindowListener(new WindowAdapter() // WindowAdapter��д��WindowListener��ȫ�����󷽷���
		{
			public void windowClosing(WindowEvent e) {
				System.out.println("close window");
				System.exit(0);
			}

			public void windowActivated(WindowEvent e) {
				System.out.println("active.");
			}

			public void windowOpened(WindowEvent e) {
				System.out.println("open window");
			}

		});

		f.setVisible(true);
		// System.out.println("hello world");
	}
}