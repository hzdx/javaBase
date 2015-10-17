package study.base.other;

class demo2 {
	public static void main(String[] args) {
		toBin(8);
		toFour(0);
		toEight(45);
		toHex(60);

	}

	public static void toBin(int num) {
		TransNum(num, 2, 1);
	}

	public static void toFour(int num) {
		TransNum(num, 4, 2);
	}

	public static void toEight(int num) {
		TransNum(num, 8, 3);
	}

	public static void toHex(int num) {
		TransNum(num, 16, 4);
	}

	public static void TransNum(int num, int base, int offset) {

		System.out.print(num + "ת��Ϊ" + base + "������=");
		if (num == 0) {
			System.out.println(0);
			return;
		}
		char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] arr = new char[32];
		int pos = 0;
		// int offset=base/2;
		while (num != 0) {
			int temp = num & (base - 1);
			arr[pos++] = chs[temp];
			num = num >>> offset;
		}
		for (int x = pos - 1; x >= 0; x--) {
			System.out.print(arr[x]);
		}
		System.out.println();

	}
}