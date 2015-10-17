package practice.other.enume;

/**
 * 利用抽象内部类模拟枚举的实现
 * 
 * @author ldm
 *
 */
public abstract class Sex {
	private Sex() {
	} // 只有内部类可以构造实例

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

	public abstract Sex reverse();

	public abstract String toString();
}
