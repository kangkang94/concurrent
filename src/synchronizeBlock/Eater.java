package synchronizeBlock;

/**
 * Created by kang on 17/3/19.
 */
public class Eater implements  Runnable {

    private  ToastQueue finishedQueue;
    //用来对比吃和产生的Toast是否相同
    private int counter =0;

    public  Eater(ToastQueue finishedQueue){
        this.finishedQueue=finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                /**
                 * verify that toast is coming in order.and that all pieces are getting jammed.
                 */
                if (counter++ != t.getId() || t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>>Error:" + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp!" + t);
                }

            }
        }catch (InterruptedException e){
            System.out.println("Enter interrupted!");
        }

        System.out.println("Eater off!");



    }


}
