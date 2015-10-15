package study.base.other;

class  Ticket extends Thread
{
	private static int tick = 100;
	public void run()
	{
		while(true)
		{
			if(tick>0)
			{
				System.out.println(Thread.currentThread().getName()+"...sale:"+tick--);
			}
		}
	}
}

class TicketDemo
{
	public static void main(String[] args)
	{
		Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();
		Ticket t3 = new Ticket();
		t1.start();
		t2.start();
		t3.start();
	}
}