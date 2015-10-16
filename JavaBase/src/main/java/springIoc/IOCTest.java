package springIoc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class IOCTest {

	public static void main(String[] args) throws Exception{
		Properties prop = new Properties();
		InputStream is = IOCTest.class.getClassLoader().getResourceAsStream("javaBean.properties");
		prop.load(is);
		is.close();
		//User user = (User)Class.forName((String)prop.getProperty("beanName")).newInstance();
		System.out.println(prop.getProperty("BeanName"));
	}

}
