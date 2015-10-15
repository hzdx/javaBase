package study.base.exception;

/*
����ʦ�õ����ϿΡ�
��ʼ˼���Ͽ��г��ֵ����⡣
���磺
��������
����ð��
Ҫ�����������������װ�ɶ���

*/

class LanPingException extends Exception
{
	LanPingException(String message)
	{
		super(message);
	}
}

class MaoYanException extends Exception
{
	MaoYanException(String message)
	{
		super(message);
	}
}

class NoPlanException extends Exception
{
	NoPlanException(String msg)
	{
		super(msg);
	}
}

class Computer
{
	private int state = 3;
	public void run() throws LanPingException,MaoYanException
	{
		if(state==2)
			throw new LanPingException("������");
		if(state==3)
			throw new MaoYanException("ð����");
		System.out.println("computer run");
	}
	public void reset()
	{
		state = 1;
		System.out.println("computer reset");
	}
}

class Teacher
{
	private String name;
	private Computer cmpt;
	Teacher(String name)
	{
		this.name = name;
		cmpt = new Computer();
	}
	public void prelect() throws NoPlanException
	{
		try
		{
			cmpt.run();
			
		}
		catch (LanPingException e)
		{
			cmpt.reset();

		}
		catch (MaoYanException e)
		{
			test();
			throw new NoPlanException("��ʱ�޷�����"+e.getMessage());
			
		}
		System.out.println("over");
		
	
	}
	public void test()
	{
		System.out.println("����ð��");
	}
}

class ExceptionTest 
{
	public static void main(String[] args) 
	{
		Teacher t = new Teacher("����ʦ");
		try
		{
			t.prelect();
		}
		catch (NoPlanException e)
		{
			System.out.println(e.toString());
			System.out.println("����ʦ���߷ż�");
		}
	}
}
