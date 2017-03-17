package multiThread;

/**
 * Created by kang on 17/3/17.
 */
public class Sleeper extends  Thread {

    private  int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration = sleepTime;
        start();
    }

    //线程中睡眠duration
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName()+ "was Interrupt");
        }

        System.out.println(getName()+"hello");

    }
}
