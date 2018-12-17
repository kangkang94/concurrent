package nio;

import java.io.*;

/**
 * Created by kang on 17/3/31.
 */
public class TestEOF {

    public static void main(String[] args) throws IOException {

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/kang/Documents/github/concurrent/src/nio/TestEOF.java")));

        int i;
        //查看还有多少供存取的字符，一次一个字节地读取文件
        while((i=in.available())!=0){

            System.out.print((char)in.readByte());
        }

    }

}
