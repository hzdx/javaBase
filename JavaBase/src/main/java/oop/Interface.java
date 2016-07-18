package oop;

class imageCard implements PCI {
	@Override
	public void close() {
		System.out.println("imageCard close");
	}

	@Override
	public void open() {
		System.out.println("imageCard open");
	}
}

public class Interface {
	public static void main(String[] args) {
		MainBoard mb = new MainBoard();
		mb.run();
		// mb.usePCI(null);
		mb.usePCI(new soundCard());
		mb.usePCI(new imageCard());
	}
}

class MainBoard {
	public void run() {
		System.out.println("MainBoard run");
	}

	public void usePCI(PCI p) {
		p.open();
		p.close();
	}
}

interface PCI {

	public void close();

	public void open();
}

class soundCard implements PCI {
	@Override
	public void close() {
		System.out.println("soundCard close");
	}

	@Override
	public void open() {
		System.out.println("soundCard open");
	}
}
