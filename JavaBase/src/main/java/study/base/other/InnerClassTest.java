package study.base.other;

/*
��main�����еĵ�����մ��롣
*/

interface Inter
{
	void method();
}

class Test
{
	/*
	static class Inner implements Inter
	{
		public method()
		{
			System.out.println("method run");
		}
	}
	*/
	static Inter function()
	{	
		return new Inter()
		{
			public void method()
			{
				System.out.println("method run");
			}
		};
	}
		
	
}
class  InnerClassTest
{
	public static void main(String[] args) 
	{
		Test.function().method();
		//Test.function():Test����һ����̬�ķ���function��
		//method():function�ⷽ�������Ľ����һ�����󡣶�����һ��Inter���͵Ķ���
		//��Ϊֻ����Inter���͵Ķ��󣬲ſ��Ե���method������
	}
}

