package synchronizeBlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kang on 17/3/18.
 */
public class Garden {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            exec.execute(new Entrance(i));
        }
        //让main线程休眠三秒

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Entrance.cancel();
        exec.shutdown();

        System.out.println("Total: "+Entrance.getTotalCount());
        System.out.println("sum of Entrance" +Entrance.sumEntrance());

    }

}
