import java.util.Date;

/*Thread States
 * 1. New
 * 2. Runnable
 * 3. Running
 * 4. Blocked/Suspended
 * 5. Terminated
 * */

class ThreadTestClass extends Thread {

    String name;

    public ThreadTestClass(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                System.out.println(name + ":" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadExtendingClass {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Program started @" + new Date());
        ThreadTestClass thread1 = new ThreadTestClass("Thread1");
        thread1.start();
        ThreadTestClass thread2 = new ThreadTestClass("Thread2");
        thread2.start();
        System.out.println("Program ended @" + new Date());
        System.out.println("main thread running ...");
        System.out.println("main thread running ...");
        System.out.println("main thread running ...");

    }
}

