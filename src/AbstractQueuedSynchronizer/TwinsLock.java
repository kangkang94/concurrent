package AbstractQueuedSynchronizer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by kang on 17/3/30.
 */

/**
 *自定义同步组件,该组件至多允许俩个线程同时访问，超过俩个线程将会阻塞。
 */
public class TwinsLock implements Lock {

    private final Sync sync = new Sync(2);


    private static final class Sync extends AbstractQueuedSynchronizer{

        Sync(int count ){
            if (count<=0){
                //非法的参数异常
                throw new IllegalArgumentException("count must large than zero.");
            }
            setState(count);

        }

        /**
         * 重写AQS的抽象方法，实现共享获取与释放同步状态！供模板方法调用
         * @param recudeCount
         * @return
         */
        @Override
        public int tryAcquireShared(int recudeCount) {
            //自旋
            for(;;){
                int current = getState();
                int newCount = current - recudeCount;
                //CAS操作确保原子性
                if (newCount<0||compareAndSetState(current,newCount)){
                    return newCount;
                }

            }
        }


        /**
         *
         * 共享式地释放同步状态
         * @param reduceCount
         * @return
         */
        @Override
        public boolean tryReleaseShared(int reduceCount) {

            for(;;){
                int current =getState();
                int newCount = current+reduceCount;
                if (compareAndSetState(current,newCount)){
                    return true;
                }

            }


        }
    }


    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
