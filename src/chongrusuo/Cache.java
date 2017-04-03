package chongrusuo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kang on 17/4/1.
 */
public class Cache {

    static Map<String,String> map = new HashMap<>();
    //读写锁
    static ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
    static Lock r = rrw.readLock();
    static Lock w = rrw.writeLock();

    public static final Object get(String key){

        r.lock();
        try{
            return map.get(key);

        }finally {
            r.unlock();
        }

    }


    public static void put(String key,String value){
        w.lock();
        try{

            map.put(key,value);

        }finally {
            w.unlock();
        }

    }

    public static void clear(){
        w.lock();
        try{

            map.clear();
        }finally {
            w.unlock();
        }

    }



}
