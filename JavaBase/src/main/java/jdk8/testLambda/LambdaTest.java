package jdk8.testLambda;
/**
 * lambda表达式
 * 适用于传递一个只有一个抽象方法的匿名内部类
 * 如这里()->{}代替了new Runnable( public void run(){})
 * @author ldm
 *
 */
public class LambdaTest {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(int x=0;x<100;x++){
				System.out.println("run..."+x);
			}
		});
		t.start();

	}

}
