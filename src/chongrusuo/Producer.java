package chongrusuo;

import java.util.LinkedList;

/**
 * Created by kang on 17/10/30.
 */
public class Producer extends Thread{

    private  int num;
    private Storage storage ;

    public Producer(Storage storage){
        this.storage = storage;
    }


    @Override
    public void run() {
        storage.produce(num);
    }

    public void setNum(int num) {
        this.num = num;
    }
}
