package produceAndConsume;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kang on 17/3/18.
 */
public class Restaurant {

    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restaurant(){
        exec.execute(waitPerson);
        exec.execute(chef);
    }


    public static void main(String[] args) {
        new Restaurant();
    }
}
