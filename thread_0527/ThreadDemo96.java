package thread.thread_0527;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: HuYu
 * Date: 2021-05-27
 * Time: 20:46
 */
public class ThreadDemo96 {
    public static void main(String[] args) {
        //创建一个读写锁
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);//表示是否是公平的，默认是非公平的
        //读锁

        ReentrantReadWriteLock.ReadLock  readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
//        ThreadPoolExecutor executor = new ThreadPoolExecuto(1,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
          ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000)
        );
   executor.execute(new Runnable() {
       @Override
       public void run() {
           readLock.lock();
           try {
               System.out.println(Thread.currentThread().getName());
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }finally {
               readLock.unlock();
           }
       }
   });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();

                }
            }
        });
   executor.execute(new Runnable() {
       @Override
       public void run() {
           writeLock.lock();
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }finally {
               writeLock.unlock();
           }
       }
   });
    }
}
