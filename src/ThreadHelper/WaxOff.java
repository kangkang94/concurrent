package ThreadHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by kang on 17/3/18.
 */
public class WaxOff implements Runnable {

    private Car car;
    public WaxOff(Car car){
        this.car = car;
    }

    @Override
    public void run() {

        try {
            while(!Thread.interrupted()){
                car.waitingForWaxing();
                System.out.println("Wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        System.out.println("Ending Wax off task!");

    }
}
