package study.base.exception;

/*
����������쳣RuntimeException ����ʱ�쳣��
����ں��������׳����쳣�������Ͽ��Բ���������
������������˸��쳣�������߿��Բ��ý��д��?
֮���Բ����ں���������������Ϊ����Ҫ�õ����ߴ��?

�Զ����쳣ʱ�������쳣�ķ����޷�����������㡣
�����Զ����쳣�̳�RuntimeException

�쳣�ֱ���ʱ�������쳣����������쳣������ʱ�쳣��RuntimeException�Լ����ࣩ��
*/

class ExceptionDemo31
{
	int div (int a ,int b)
	{
		if(b==0)
			throw new RuntimeException("�����");
		return a/b;
	}
}

class  ExceptionDemo3
{
	public static void main(String[] args) throws MyFuShuException 
	{
		Demo d = new Demo();
		int x = d.div(3,0);
		System.out.println("x="+x);
	}
}
