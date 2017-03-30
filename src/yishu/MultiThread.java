package yishu;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by kang on 17/3/29.
 */

/**
 * 查看当前线程的id和name
 */
public class MultiThread {

    public static void main(String[] args) {

        new Thread(){


            @Override
            public void run() {
                System.out.println("Hello World");;
            }
        }.start();

        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false,false);

        for (ThreadInfo threadInfo :threadInfos){

            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());

        }
    }

}
