package chongrusuo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kang on 17/4/1.
 */
public class Cache {

    static Map<String,String> map = new HashMap<>();
    //读写锁
    static ReentrantReadWriteLock rrw = new ReentrantReadWriteLock();
    static Lock readLock = rrw.readLock();
    static Lock writeLock = rrw.writeLock();

    public static final Object get(String key){

        readLock.lock();
        try{
            return map.get(key);

        }finally {
            readLock.unlock();
        }

    }


    public static void put(String key,String value){
        writeLock.lock();
        try{

            map.put(key,value);

        }finally {
            writeLock.unlock();
        }

    }

    public static void clear(){
        writeLock.lock();
        try{

            map.clear();
        }finally {
            writeLock.unlock();
        }

    }



}
