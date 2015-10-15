package study.base.other;



class Outer
{
	int x = 3;
	void method()
	{
		final int y = 4;
		class Inner
		{
			void function()
			{
				System.out.println(y); //�ڲ��ඨ���ھֲ�ʱ�����ɱ���Ա���η����Σ����Է����ⲿ���еĳ�Ա��
									   //�������Է��������ڵľֲ��еı�����ֻ�ܷ��ʱ�final���εľֲ�������
			}
		}
		new Inner().function();
	}
}

class  InnerClassDemo2
{
	public static void main(String[] args) 
	{
		new Outer().method();
	}
}
