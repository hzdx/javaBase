package etc;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

/**
 * 转码工具
 */
public class TransEncodeUtil {
	public static final String UTF8 = "UTF-8";
	public static final String GBK = "GBK";
	public static final String ISO = "ISO-8859-1";

	public static void main(String[] args) throws Exception {

		String path = "E:\\github\\javaBase\\JavaBase\\src\\main\\java\\study\\base\\gui\\AwtDemo.java";
		System.out.println(transToAssignedFileString(path, GBK));
	}

	public static String transToAssignedFileString(String path, String newEncode) throws Exception {
		FileInputStream inputStream = new FileInputStream(path);
		byte[] buf = new byte[1024 * 1024];
		inputStream.read(buf);
		inputStream.close();
		return new String(buf, newEncode);
	}

	public static String transToAssignedString(String oldString, String oldEnCode, String newEncode)
			throws UnsupportedEncodingException {
		byte[] buf = oldString.getBytes(oldEnCode);
		return new String(buf, newEncode);
	}
}
