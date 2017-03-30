package ThreadHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by kang on 17/3/18.
 */
public class WaxOn implements  Runnable {

    private  Car car;
    public WaxOn(Car car){
        this.car = car;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
            System.out.println("Wax on!  ");

                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffing();
            }
        } catch (InterruptedException e) {
        System.out.println("Exiting via interrupt!");
        }
        System.out.println("Ending Wax On task!");
    }


}
