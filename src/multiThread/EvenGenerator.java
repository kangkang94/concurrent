package multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 不断地输出偶数
 * Created by kang on 17/3/17.
 */
public class EvenGenerator extends IntGenerator {

    private  int currentEvenValue =0;

    private Lock lock = new ReentrantLock();

    /**
     * 此方法容易导致线程不安全，可加syschronized和使用显示的Lock对象
     * @return
     */
    @Override
    public  int next() {

        lock.lock();
        try {
            ++currentEvenValue;

            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EventChecker.test(new EvenGenerator());
    }

}
