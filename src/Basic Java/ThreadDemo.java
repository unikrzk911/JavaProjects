import java.util.Date;

/*Thread States
 * 1. New
 * 2. Runnable
 * 3. Running
 * 4. Blocked/Suspended
 * 5. Terminated
 * */

class ThreadTest implements Runnable {

    String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(name + ":" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Program started @" + new Date());
        ThreadTest threadTest1 = new ThreadTest("First Thread");
        Thread thread1 = new Thread(threadTest1);
        thread1.start();
        ThreadTest threadTest2 = new ThreadTest("Second Thread");
        Thread thread2 = new Thread(threadTest2);
        thread2.start();
        System.out.println("Program ended @" + new Date());
        System.out.println("main thread running ...");


    }
}
