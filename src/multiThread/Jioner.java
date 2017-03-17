package multiThread;

/**
 * Created by kang on 17/3/17.
 */
public class Jioner extends Thread {

    private  Sleeper sleeper;

    public Jioner(String name ,Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        super.run();

        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+" has awkend");

    }

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleepy",1000);
        Sleeper grumpy = new Sleeper("Grumpy",1000);
        Jioner dock = new Jioner("Dock",sleeper);
        Jioner doc = new Jioner("Doc",grumpy);
        grumpy.interrupt();
    }


}
