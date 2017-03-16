package multiThread;

/**
 * Created by kang on 17/3/16.
 */
public class MainThread {

    public static void main(String[] args) {

        for (int i=0;i<10;i++){

            new Thread(new LiftOff()).start();
            System.out.println("Waiting for LiftOff!");
        }


    }

}
