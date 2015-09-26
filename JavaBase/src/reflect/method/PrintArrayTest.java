package reflect.method;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * 打印数组
 * @author ldm
 *
 */
public class PrintArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("bbb");
		print(new String[]{"eee","ccc"});
		print(new Object[]{1,"bbbb",true});
		System.out.println(Arrays.asList(
				new Object[]{1,"bbbb",true}));  //Arrays.asList
	}

	private static void print(Object obj){
		if(obj.getClass().isArray()){				//利用class的isArray()方法判断是否为数组
			int len = Array.getLength(obj);			
			//利用Array的getLength和get(obj,i)方法获取长度和每个元素的值
			for(int i=0;i<len;i++){
				System.out.println(Array.get(obj, i));
			}
		}else{
			System.out.println(obj);
		}
	}
}
