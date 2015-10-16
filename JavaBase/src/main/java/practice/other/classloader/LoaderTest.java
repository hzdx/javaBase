package practice.other.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 类加载器
 * AppClassLoader 默认加载classPath下的类
 * ExtClassLoader 默认加载 jre/lib/ext/下的类
 * BootStrap? 最高级加载器，java无法获取
 * 还可以自定义类加载器，加载指定的类，
 * 比如tomcat就有一个自定义的WebappClassLoader加载Servlet类。
 * @author ldm
 *
 */
public class LoaderTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = LoaderTest.class.getClassLoader()
				.getResourceAsStream("reflect/config.properties");
		//用classloader加载不要加/,都是从classPath根目录下查找
//		InputStream is1 = LoaderTest.class
//				.getResourceAsStream("/reflect/config.properties");
		// 直接用class加载，带 / 绝对路径，从classPath根目录下查找，不带是相对路径
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		System.out.println(prop.get("className"));
		System.out.println(LoaderTest.class.getClassLoader());
		System.out.println(LoaderTest.class.getClassLoader().getParent());
		System.out.println(LoaderTest.class.getClassLoader().getParent().getParent());
//		/System.out.println(System.class.getClassLoader().getClass());		//顶级加载器无法获取
	}

}
