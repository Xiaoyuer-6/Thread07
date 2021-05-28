package thread.thread_0527;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-27
 * Time: 19:49
 */
public class ThreadDemo93 {
    private  static AtomicReference many = new AtomicReference(100);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = many.compareAndSet(100,0);
                System.out.println("第一次转账"+result);
            }
        });
        t1.start();
        t1.join();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = many.compareAndSet(0,100);
                System.out.println("转入100元: "+result);
            }
        });
        t3.start();
        t3.join();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = many.compareAndSet(100,0);
                System.out.println("第二次转账"+result);

            }
        });
        t2.start();

    }
}
