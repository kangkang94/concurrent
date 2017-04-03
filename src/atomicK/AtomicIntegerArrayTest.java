package atomicK;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by kang on 17/4/3.
 */
public class AtomicIntegerArrayTest {

    static int[] value = new int[]{1,2};

    //将数组传入构造器实际上是将数组拷贝了一份
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {

        System.out.println(ai.getAndSet(0,3));
        System.out.println(ai.get(0));
        System.out.println(ai.getAndAdd(1,2));
        System.out.println(ai.get(1));
        System.out.println(value[0]);

    }


}
