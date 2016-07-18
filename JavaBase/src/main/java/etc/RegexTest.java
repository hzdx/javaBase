package etc;

public class RegexTest {

	public static void main(String[] args) {
		String regex = "^[a-zA-Z]\\w{5,17}@(126|163)\\.com|(yeah\\.net)$"; // 注意,
																			// String中\进行转义
																			// //
																			// ^,$加不加一样？
		String mail = "hzdx102468@126.com";
		System.out.println(mail.matches(regex));

	}

}
