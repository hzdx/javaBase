package practice.other.enume;

/**
 * 枚举内部类测试
 * 
 * @author ldm
 *
 */
public class SexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sex s = Sex.female;
		System.out.println(s);
		System.out.println(s.male); // 存在问题：实例的对象可以引用对立的对象
		System.out.println(s.reverse());
	}

}
