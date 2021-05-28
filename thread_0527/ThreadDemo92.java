package thread.thread_0527;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-27
 * Time: 19:49
 */
public class ThreadDemo92 {
    private  static AtomicReference many = new AtomicReference(100);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = many.compareAndSet(100,0);
                System.out.println("第一次转账"+result);
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = many.compareAndSet(100,0);
                System.out.println("第一次转账"+result);

            }
        });
        t2.start();

    }
}
