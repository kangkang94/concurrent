package chongrusuo;

/**
 * Created by kang on 17/10/30.
 */
public class Consumer extends Thread {

    private  int num;
    private Storage storage ;

    public Consumer(Storage storage){
        this.storage = storage;
    }



    @Override
    public void run() {
       storage.consume(num);
    }

    public void setNum(int num) {
        this.num = num;
    }
}
