package chongrusuo;

/**
 * Created by kang on 17/10/30.
 */
public class DeadLockDemo {

    private static String A="A";
    private static String B="B";

    public void deadLock(){

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                //拥有A对象的锁并且希望有B对象的锁
                synchronized (A){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("t1");
                    }

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                //拥有A对象的锁并且希望有B对象的锁
                synchronized (B){
                    synchronized (A){
                        System.out.println("t2");
                    }

                }
            }
        });

        t1.start();
        t2.start();

    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

}
