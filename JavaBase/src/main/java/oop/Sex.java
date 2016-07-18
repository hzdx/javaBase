package oop;

/**
 * 利用抽象内部类模拟枚举的实现
 * 
 */
public abstract class Sex {
	public final static Sex male = new Sex() {

		@Override
		public Sex reverse() {
			// TODO Auto-generated method stub
			return female;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "男";
		}

	};

	public final static Sex female = new Sex() {

		@Override
		public Sex reverse() {
			// TODO Auto-generated method stub
			return male;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "女";
		}

	};

	public static void main(String[] args) {
		Sex s = Sex.female;
		System.out.println(s);
		System.out.println(Sex.male); // 存在问题：实例的对象可以引用对立的对象
		System.out.println(s.reverse());
	}

	private Sex() {
	} // 只有内部类可以构造实例

	public abstract Sex reverse();

	@Override
	public abstract String toString();
}
