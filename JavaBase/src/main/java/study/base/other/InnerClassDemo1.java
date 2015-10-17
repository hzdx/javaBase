package study.base.other;

/*
 1,�ڲ������ֱ�ӷ����ⲿ���еĳ�Ա������˽�С�
 ��Ϊ�ڲ�������ⲿ������á���ʽ���ⲿ��Ŀ.this
 2,�ⲿ��Ҫ�����ڲ��࣬���뽨���ڲ������


 ���ʸ�ʽ��
 1���ڲ���������ⲿ��ĳ�Աλ�ã��ҷ�˽�У����Գ������ⲿ��������,����ֱ�ӽ����ڲ������
 ��ʽ��Outer.Inner in  = new Outer().new Inner();
 2���ڲ���������ⲿ��ĳ�Աλ�ã��Ϳ��Ա���Ա���η������Ρ�
 ��private�����ڲ������ⲿ���н��з�װ��
 static :�ڲ������static �����ԡ�ֻ�ܷ����ⲿ���е�static��Ա�����ַ��ʾ��ޡ�

 ���ⲿ�������У����ֱ�ӷ��ʾ�̬�ڲ���ķǾ�̬��Ա��
 new Outer.Inner().function();
 ���ⲿ�������У����ֱ�ӷ��ʾ�̬�ڲ���ľ�̬��Ա��
 Outer.Inner().function();

 ���ڲ��ඨ���˾�̬��Ա���ڲ�������Ǿ�̬�ġ�
 ���ⲿ���еľ�̬���������ڲ��У��ڲ������Ҳ�Ǿ�̬�ġ�

 ����������ʱ��������ڲ�����������������ڲ�����������
 ��Ϊ�ڲ�������ʹ���ⲿ��������ݡ�
 ��ʽ����
 class Body
 {

 private class heart
 {

 }
 public void show()
 {
 new heart().
 }
 }



 */

class Outer1 {
	private int x = 3;
	private static int y = 4;

	class Inner // �ڲ���
	{
		int x = 4;

		void function() {
			int x = 6;
			System.out.println("inner:x=" + x); // x x=6
			// this.x x=4
			// Outer.this.x x=3
		}
	}

	void method() {
		Inner in = new Inner();
		in.function();
	}

	static class Inner2 {
		void show1() {
			System.out.println("inner2 show1:y=" + y);
		}

	}

}

class InnerClassDemo1 {
	public static void main(String[] args) {
		Outer1 out = new Outer1();
		out.method();

		// ֱ�ӷ����ڲ��ࡣ
		Outer1.Inner in = new Outer1().new Inner();
		in.function();

		new Outer1.Inner2().show1();

		// Outer.Inner().function();

	}
}