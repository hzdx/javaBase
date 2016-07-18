package etc;

/**
 * 枚举基本应用
 * 
 * @author ldm
 *
 */
public class EnumTest {

	public enum WeekDay {
		/* SUM,MON,THI,THU,FRI,SUM */
		SUM {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		MON {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		THI {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		THU {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		FRI {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "星期五";
			}
		},
		SUN {
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		// 调用的无参构造方法
		@Override
		public abstract String toString();
	}

	public static void main(String[] args) {
		System.out.println(WeekDay.MON);
		System.out.println(WeekDay.FRI.name());
		System.out.println(WeekDay.valueOf("FRI"));
		System.out.println(WeekDay.values().length);
		System.out.println(WeekDay.FRI.ordinal());

	}

}
