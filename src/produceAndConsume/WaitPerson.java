package produceAndConsume;

/**
 * Created by kang on 17/3/18.
 */
public class WaitPerson implements  Runnable {
    private Restaurant restaurant;
    public WaitPerson(Restaurant r){
        restaurant = r;
    }



    @Override
    public void run() {
        try {
        while(!Thread.interrupted()){
            synchronized (this){
                while(restaurant.meal == null){

                        wait();

                }
            }
            System.out.println("Waitperson got "+restaurant.meal);
            synchronized (restaurant.chef){
                restaurant.meal=null;
                restaurant.chef.notifyAll();
            }

        }

    } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
    }
    }
}
