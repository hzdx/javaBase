package practice.interview.other;
/**
 * ++号在后面的意思是先赋值然后自身加1；++在前面的是先自身加1后赋值；
 * @author ldm
 *
 */
public class Inc {
	public static void main(String[] args) {
		//Inc inc = new Inc();
		int i = 0;
		//inc.fermin(i);
		fermin(i);
		System.out.println(i);
		i = i++;    //先赋值在加一
		System.out.println(i); // 输出结果为0
	}

	static void fermin(int i) {
		//i++;
		//i = ++i;
		//i = i+1;
		i = 5;
	}
}