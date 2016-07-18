package etc;

/**
 * 注解相对于特殊的类，是一种标记，可以有各种属性
 * 如果属性只有一个value，或者其他属行有默认值，则可以只写一个值，如@MyAnnotation("aaaa")
 * 
 * @author ldm
 *
 */
@MyAnnotation("aaaa")
public class AnnotationTest {
	// @SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// System.runFinalizersOnExit(true);
		// AnnotationTest.sayHi();
		if (AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
			MyAnnotation anno = AnnotationTest.class.getAnnotation(MyAnnotation.class);
			System.out.println(anno);
			System.out.println(anno.color());
			System.out.println(anno.value());
		}
	}

	@Deprecated
	public static void sayHi() {
		System.out.println("hello");
	}
}
