package synchronizeBlock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kang on 17/3/17.
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>(){
        private Random random = new Random(47);

        protected synchronized Integer initialValue(){
            return  random.nextInt(1000);
        }
    } ;

    public static void increment(){
        value.set(value.get()+1);
    }

    public static int get(){
        return  value.get();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            exec.execute(new Accessor(i));
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //所有线程理解停止
        exec.shutdownNow();

    }

}
