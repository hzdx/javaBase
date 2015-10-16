package practice.other.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //保留时间,一般Runtime, overRide等是Source
@Target(ElementType.TYPE)			//注解放置的地方，这里是类名上，可以是方法上，包上，变量上。
public @interface MyAnnotation {
	String color() default "red";	
	String value();		
}
