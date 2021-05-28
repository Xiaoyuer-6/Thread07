package thread.thread_0527;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-27
 * Time: 19:49
 */
public class ThreadDemo94 {
    private  static AtomicStampedReference money = new AtomicStampedReference(100,1);//起始值和版本号

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100,0,1,2);
                System.out.println("第一次转账"+result);
            }
        });
        t1.start();
        t1.join();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(0,100,2,3);
                System.out.println("转入100元: "+result);
            }
        });
        t3.start();
        t3.join();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = money.compareAndSet(100,0,1,2);
                System.out.println("第二次转账"+result);

            }
        });
        t2.start();

    }
}
