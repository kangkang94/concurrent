package atomicK;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kang on 17/4/3.
 */
public class AtomicIntegerTest {

    static AtomicInteger at = new AtomicInteger(1);


    public static void main(String[] args) {
        System.out.println(at.getAndIncrement());
        System.out.println(at.get());
    }


}
