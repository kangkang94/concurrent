package multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kang on 17/3/17.
 */
public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed(){
        //获取锁，返回boolean值
        boolean captured =lock.tryLock();
        try {
            System.out.println("tryLock()" + captured);
        }finally {
            if (captured){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean captured = false;

        //尝试获取锁，返回boolean值
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            System.out.println("tryLock(2,TimeUnit.SECONDS):"+captured);

        }finally {
            if (captured){
                lock.unlock();
            }
        }


    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread(){
            {setDaemon(true);}
            @Override
            public void run() {
                super.run();
                al.lock.lock();
                System.out.println("acquired!");

            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }


}
