package study.base.generic;

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

	public void open();

	public void close();
}

class soundCard implements PCI {
	public void open() {
		System.out.println("soundCard open");
	}

	public void close() {
		System.out.println("soundCard close");
	}
}

class imageCard implements PCI {
	public void open() {
		System.out.println("imageCard open");
	}

	public void close() {
		System.out.println("imageCard close");
	}
}

class Interface {
	public static void main(String[] args) {
		MainBoard mb = new MainBoard();
		mb.run();
		// mb.usePCI(null);
		mb.usePCI(new soundCard());
		mb.usePCI(new imageCard());
	}
}
