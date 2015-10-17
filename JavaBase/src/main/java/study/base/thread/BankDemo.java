package study.base.thread;

class Bank {
	private int sum;

	public synchronized void add(int n) {
		sum = sum + n;
		System.out.println("sum=" + sum);
	}
}

class Cus implements Runnable {
	private Bank b = new Bank();

	public void run() {
		for (int x = 0; x < 3; x++) {
			b.add(100);
		}
	}
}

class BankDemo {
	public static void main(String[] args) {
		Cus c = new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}
