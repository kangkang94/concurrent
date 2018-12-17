package nio;

/**
 * Created by kang on 17/3/31.
 */

import java.io.*;

/**
 * 存储和恢复数据
 */
public class StoringAndRecoveringData {


    public static void main(String[] args) throws IOException {

        DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/Use" +
                "rs/kang/Documents/github/concurrent/src/nio/hello.txt")));
        stream.writeDouble(3.141513);
        stream.writeUTF("That was pi");
        stream.writeUTF("Hello World");
        stream.writeDouble(1.145);

        stream.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/kang/Documents/github/concurrent/src/nio/hello.txt")));
       System.out.println(in.readDouble());
        System.out.println(in.readUTF());

       System.out.println(in.readUTF());

       System.out.println(in.readDouble());

    }



}
