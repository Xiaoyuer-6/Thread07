package thread.thread_0527;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-27
 * Time: 19:27
 */
public class ThreadDemo91 {
    public static void main(String[] args) {

        AtomicInteger count  = new AtomicInteger(0);
        count.getAndIncrement();
        count.incrementAndGet();
        System.out.println(count.incrementAndGet());

    }
}
