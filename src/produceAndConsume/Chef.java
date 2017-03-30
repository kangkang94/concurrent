package produceAndConsume;

import java.util.concurrent.TimeUnit;

/**
 * Created by kang on 17/3/18.
 */
public class Chef implements Runnable {

    private Restaurant restaurant;
    private  int count = 0;
    public Chef(Restaurant r){
        restaurant=r;
    }

    @Override
    public void run() {
        try {
        while(!Thread.interrupted()){
            //有meal则wait（）
            synchronized (this){
                while(restaurant.meal !=null){
                    wait();
                }

            }

            if(++count ==10){
                System.out.println("Out of food ,closing");
                restaurant.exec.shutdownNow();
            }
            System.out.print("Order up!");

            synchronized (restaurant.waitPerson){
                restaurant.meal = new Meal(count);
                restaurant.waitPerson.notifyAll();
            }


                TimeUnit.MILLISECONDS.sleep(100);


        }
    } catch (InterruptedException e) {
            System.out.println("Chef interrupter");
    }

    }




}
