package ThreadHelper;

/**
 * Created by kang on 17/3/18.
 */
public class Car {

    private boolean waxOn=false;
    public synchronized void waxed(){
        waxOn=true;
        notifyAll();
    }

    public synchronized void buffed(){
        waxOn=false;
        notifyAll();
    }

    public synchronized void waitingForWaxing() throws InterruptedException {
        while(waxOn == false){
            wait();
        }
    }

    public synchronized void waitingForBuffing() throws InterruptedException {
        while(waxOn==true){
            wait();
        }
    }


}
