package chongrusuo;

/**
 * Created by kang on 17/4/5.
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用数组实现的有界阻塞队列
 * @param <T>
 */
public class ArrayBlockQueue<T> {

    Object[] items ;
    //count为数组中元素个数
    int addIndex,removeIndex,count;
    Lock lock = new ReentrantLock();

    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();


    public ArrayBlockQueue(int size){

        items = new Object[size];
    }


    public void  add(T t) throws InterruptedException {

        lock.lock();
        try{
            while(count == items.length){
                notFull.await();
            }
            items[addIndex] = t;
            //
            if (++addIndex == items.length){
                addIndex=0;
                addIndex=0;
            }

            ++count;
            notEmpty.signal();


        }finally {
            lock.unlock();
        }



    }





}
