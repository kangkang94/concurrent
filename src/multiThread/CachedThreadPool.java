package multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kang on 17/3/16.
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        //ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i=0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }


}
