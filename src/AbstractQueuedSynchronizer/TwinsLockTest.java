package AbstractQueuedSynchronizer;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by kang on 17/3/30.
 */
public class TwinsLockTest {
/**
   static  class Worker extends Thread{

       Lock lock;
       public  Worker(Lock lock){
           this.lock = lock;
       }


       @Override
       public void run() {
           while(true){

               lock.lock();
               try{
                   TimeUnit.SECONDS.sleep(1);
                   System.out.println(Thread.currentThread().getName()+"");

                  //® TimeUnit.SECONDS.sleep(1);

               } catch (InterruptedException e) {
                   e.printStackTrace();
               } finally {
                   lock.unlock();
               }


           }

       }
   }

    public static void main(String[] args) throws InterruptedException {
       final Lock lock = new TwinsLock();
        //启动10个后台线程
        for(int i=0;i<10;i++){
            Worker worker = new Worker(lock);
            worker.setDaemon(true);
            worker.start();

        }


            TimeUnit.SECONDS.sleep(16);


    }

**/
      @Test
      public void test() throws InterruptedException {
          final Lock lock = new TwinsLock();

          class Worker extends Thread{
              @Override
              public void run() {
                  while(true){

                      lock.lock();
                      try{
                          TimeUnit.SECONDS.sleep(3);
                          System.out.println(Thread.currentThread().getName());
                          System.out.println("");
                          TimeUnit.SECONDS.sleep(3);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      } finally {
                          lock.unlock();
                      }


                  }
              }
          }

          for (int i=0;i<10;i++){
              Worker worker = new Worker();
              worker.setDaemon(true);
              worker.start();
          }


         for (int i=0;i<20;i++){
              TimeUnit.SECONDS.sleep(1);
             System.out.println("******");
         }

      }



}
