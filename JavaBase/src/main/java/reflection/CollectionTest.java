package reflection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/**
 * 利用properties加载类名，然后创建实例
 * 
 *
 */
public class CollectionTest {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("src/main/java/reflect/config.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		// System.out.println(prop.get("className"));
		Collection colle = (Collection) Class.forName((String) prop.get("className")).newInstance();
		colle.add("bbb");
		colle.add(1);
		colle.add("bbb");
		System.out.println(colle.size());
	}

}
