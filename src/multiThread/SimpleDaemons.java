package multiThread;

import java.util.concurrent.TimeUnit;

/**
 * Created by kang on 17/3/17.
 */
public class SimpleDaemons implements Runnable {


    @Override
    public void run() {

        while (true){
            try {

                Thread.sleep(100);
                System.out.println(Thread.currentThread()+":"+this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }


    public static void main(String[] args) throws InterruptedException {

        for (int i=0;i<10;i++) {
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all daemon started");
        TimeUnit.MILLISECONDS.sleep(175);

    }

}
