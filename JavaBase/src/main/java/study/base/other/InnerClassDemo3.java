package study.base.other;

/*
1.�����ڲ�����ʵ�����ڲ���ļ�д��ʽ��
2.���������ڲ����ǰ�᣺
	�ڲ�������Ǽ̳�һ�������ʵ�ֽӿڡ�
3.�����ڲ���ĸ�ʽ�� new ������߽ӿ�(){�������������}
4.��ʵ�����ڲ������һ������������󡣶�����������е��֡�
	�������Ϊ�����ݵĶ���
5.�����ڲ����ж���ķ�����ò�Ҫ����3����
*/

abstract class AbsDemo
{
	abstract void show();
}

class Outer2
{
	//int x = 3;
	/*
	class Inner
	{
		void method() extends AbsDemo
		{
			System.out.show("x="+x);
		}
	}
	*/
	public void function()
	{
		//new Inner().show();
		AbsDemo d = new AbsDemo()                         //new AbsDemo(){}.show();    //�����������
		{
			int num=9;
			void show()
			{
				System.out.println("x="+num);
			}
			void abc()	//��������
			{
				System.out.println("haha");  
			}
		};
		d.show();
	}
}

class  InnerClassDemo3
{
	public static void main(String[] args) 
	{
		new Outer2().function();
	}
}
