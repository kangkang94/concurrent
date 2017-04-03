package chongrusuo;

/**
 * Created by kang on 17/4/1.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 一个测试用来观察公平锁和非公平锁在获取锁时的区别
 *
 */
public class FairAndUnfairTest {






    //重入锁
    public static class ReentrantLock2 extends ReentrantLock{

        public ReentrantLock2(boolean fail){
            super(fail);
        }
        //列表逆序输出，方便观察，输出处于等待队列的线程集合
        @Override
        protected Collection<Thread> getQueuedThreads() {
            ArrayList<Thread> list = new ArrayList<>(super.getQueuedThreads());
           // Collections.sort(list,Collections.reverseOrder());
            Collections.reverse(list);
            return list;
        }
    }



}
