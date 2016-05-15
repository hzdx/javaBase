package enhance;

public class VolatileTest {
    private static int number;
    private static volatile boolean ready;
    //boolean类型的变量，默认是false

    private static class ReadThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
        new ReadThread().start();
        number = 42;
        ready = true;
    }
}