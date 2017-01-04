package algorithm;

public class SubSet {

	public static void main(String[] args) {
		String[] set = {"A","B","c","g"};
		new SubSet().handleAllSubSet(set);

	}

	public void handleAllSubSet(String[] set) {
		int len = set.length;
		int val = 0;
		for (int i = 0; i < len; i++) {
			val |= (1 << i);//将子集转换为二进制树
		}

		while (val >= 0) {
			printSetByBinary(val, set);
			val--;
		}
	}

	private void printSetByBinary(int val, String[] set) {
		StringBuilder sb = new StringBuilder("subset:{");
		for (int i = 0, len = set.length; i < len; i++) {
			if (isElementOn(val, i))
				sb.append(set[i] + ",");
		}
		sb.append("}");
		System.out.println(sb.toString());

	}

	private boolean isElementOn(int val, int idx) {
		int bit = (val >> idx) & 1;
		return bit == 1;
	}

}
