package synchronizeBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kang on 17/3/18.
 */
public class Entrance implements Runnable {

    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    //number是记录转门的人数
    private  int number;

    private final  int id;

    private static volatile boolean canceled = false;

    public  static  void cancel(){ canceled = true;}

    /**
     * 在构造器中传入线程id,并且把当前线程加入list中！注意：通过implement Runnable接口实现多线程，每个线程里的资源是共享的！
     * @param id
     */
    public Entrance(int id){
        this.id = id;
        entrances.add(this);

    }

    /**
     * 让线程每100 加一
     */
    @Override
    public void run() {

        while(!canceled){
            //对括号内的代码加对象锁
            synchronized (this){
                ++number;
            }
            System.out.println(this + "Total: "+ count.increment());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stoping "+ this);
    }

    public synchronized int getValue(){return number;}
    public String toString(){
        return "Entrance " + id+":"+getValue();
    }
    /**
     * 获取总门的人数
     */
    public static int getTotalCount(){
        return count.value();
    }
    /**
     * 每个门累加得到总门人数
     */
    public static int sumEntrance(){
        int sum=0;
        for (Entrance entrance :entrances){
            sum+=entrance.getValue();
        }
        return sum;
    }



}
