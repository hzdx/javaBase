package study.base.util;

class RuntimeDemo {
	public static void main(String[] args) throws Exception {
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("D:\\QQ\\Bin\\QQ.exe");
		// Thread.sleep(4000);
		p.destroy();
	}
}