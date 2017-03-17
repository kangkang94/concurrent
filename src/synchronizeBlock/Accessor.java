package synchronizeBlock;

/**
 * Created by kang on 17/3/17.
 */
public class Accessor implements Runnable {

    private  final int id;
    public  Accessor(int id){
        this.id=id;
    }

    /**
     * 证明变量的在不同线程下相互独立
     */
    @Override
    public void run() {

        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);

            Thread.yield();
        }



    }

    public String toString(){

        return "#" +id + ":" +ThreadLocalVariableHolder.get();
    }


}
