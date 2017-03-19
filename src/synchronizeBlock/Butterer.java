package synchronizeBlock;

/**
 * Created by kang on 17/3/19.
 */
public class Butterer implements Runnable {

    private ToastQueue dryQueue,butterQueue;
    public Butterer(ToastQueue dryQueue,ToastQueue butterQueue){
        this.dryQueue = dryQueue;
        this.butterQueue=butterQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

                //blocks until next piece of toast is available;
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);

                butterQueue.put(toast);

            }
        }catch (InterruptedException e){
            System.out.println("Buttered interrupted!");
        }

        System.out.println("Butter off");

    }
}
