package chongrusuo;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by kang on 17/10/30.
 */
public class Storage {

    public static final int MAX= 100;

    //仓库，存储生产者线程生产的产品
    public LinkedList<Object> list = new LinkedList<Object>();

    public void produce(int num){
        //同步多个生产者线程
        synchronized (list){

            while (list.size()+num>MAX){

                try {
                    //不满足条件，生成者线程阻塞,释放锁
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //满足条件
            for (int i=0;i<num;i++){

                list.add(new Object());
            }
            //通知所有阻塞的线程可以执行
            list.notifyAll();

        }
    }

    public void consume(int num){

        synchronized (list){

            while(num >list.size()){

                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i=0;i<num;i++){
                list.remove();
            }
            list.notifyAll();
        }

    }

}
