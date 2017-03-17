package multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 消费者任务，当出现线程不安全时则输出not even
 * Created by kang on 17/3/17.
 */
public class EventChecker implements Runnable {

    private  IntGenerator generator;
    private final int id;

    public  EventChecker(IntGenerator generator,int id){
        this.generator=generator;
        this.id = id;
    }


    @Override
    public void run() {

        while(true){
            int val = generator.next();
            if (val%2 !=0){
                System.out.println(val+"not even!");
                generator.cancel();
            }
        }

    }

    public static void test(IntGenerator generator,int id){
        System.out.println("Press Control-c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i=0;i<id;i++){
            exec.execute(new EventChecker(generator,id));
        }

        exec.shutdown();

    }

    public  static  void test(IntGenerator generator){
        test(generator,10);
    }


}
