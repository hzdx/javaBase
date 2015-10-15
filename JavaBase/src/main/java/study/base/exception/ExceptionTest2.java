package study.base.exception;

/*
��һ��Բ�κͳ����Ρ�
�����Ի�ȡ�����������ַǷ�ֵ����Ϊ��ȡ���������⡣

����ͨ���쳣����ʾ��
���ж����������л���ơ�

*/

class NoValueException extends RuntimeException
{
	NoValueException(String msg)
	{
		super(msg);
	}
}

interface Shape
{
	void getArea();
}

class Rec implements Shape
{
	private int len,wid;
	Rec(int len, int wid)
	{
		if(len <= 0||wid<=0)	
			throw new NoValueException("���ַǷ�ֵ");
		
		
		this.len = len;
		this.wid = wid;
		
	}
	public void getArea()
	{
		System.out.println(len*wid);
	}
}



class ExceptionTest2
{
	public static void main(String[] args) 
	{
		
		try
		{
			Rec r = new Rec(3,-4);
			r.getArea();

		}
		catch (NoValueException e)
		{
			System.out.println(e.toString());
		}
		System.out.println("over");
	}
}
