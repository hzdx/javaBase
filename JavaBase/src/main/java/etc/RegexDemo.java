package etc;

/*
 1，匹配：string matches方法。  正则表达式
 splitDemo("zhangsan.lisi.wangwu","\\.");
 splitDemo("c:\\abc\\a.txt","\\\\");
 splitDemo("erkktyqquizzo","(.)\\1+");//按照叠词完成切割，为了可以让规则的结果被重用。
 //可以将规则封装成一个组。用()完成，组的出现都有编号。


 //从1开始，想要使用已有的组可以通过 \n(n就是组的编号)的形式获取。
 replaceAll(str,"\\d{5,}","#"};
 replaceAll(str1,"(.)\\1+","&");
 好处：简化对字符串的复杂操作。
 弊端：符号定义越多，正则越长，阅读性越差。
 */
public class RegexDemo {
	public static void checkQQ() {
		String qq = "";
		int len = qq.length();
		if (len >= 5 && len <= 15) {
			if (!qq.startsWith("0")) {
				char[] arr;
			} else {
				System.out.println("不可以以0开头");
			}
		}
	}
}