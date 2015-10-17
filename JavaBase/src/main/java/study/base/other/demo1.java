package study.base.other;

class demo1 {
	public static void main(String[] args) {
		toHex(-60);

	}

	public static void toHex(int num) {
		char[] chs = { '0', '1' };
		// char []
		// chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char[] arr = new char[32];
		int pos = 0;
		while (num != 0) {
			int temp = num & 1;
			/*
			 * if(temp>9) sb.append((char)(temp-10+'A')); else sb.append(temp);
			 * num=num>>>4;
			 */
			arr[pos++] = chs[temp];
			num = num >>> 1;
		}
		for (int x = pos - 1; x >= 0; x--) {
			System.out.print(arr[x]);
		}
		System.out.println();

	}

}