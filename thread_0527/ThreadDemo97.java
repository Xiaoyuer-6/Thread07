package thread.thread_0527;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-27
 * Time: 20:46
 */
public class ThreadDemo97 {
    private  static  Object lock = new Object();
    public static void main(String[] args) {
      synchronized (lock){
          System.out.println("11111");
          synchronized (lock){
              System.out.println("22222");
          }
      }
    }
}
