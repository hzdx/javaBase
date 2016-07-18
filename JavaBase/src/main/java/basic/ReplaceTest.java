package basic;

public class ReplaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc".replace("b", "a");
		String s1 = "abcbbaabbba".replaceAll("b", "a");
		System.out.println(s1);
	}

}
