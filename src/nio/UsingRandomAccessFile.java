package nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by kang on 17/3/31.
 */

/**
 * 读写随机访问文件
 */
public class UsingRandomAccessFile {

     static String file = "/Users/kang/Documents/github/concurrent/src/nio/fighting.dat";

     public static void display() throws IOException {

         RandomAccessFile randomAccessFile = new RandomAccessFile(file,"r");
         for (int i=0;i<7;i++){
             System.out.println("value "+i+":"+randomAccessFile.readDouble());

         }

         System.out.println(randomAccessFile.readUTF());
         randomAccessFile.close();

     }

    public static void main(String[] args) throws IOException {

         RandomAccessFile rf = new RandomAccessFile(file,"rw");

         for (int i=0;i<7;i++){
             rf.writeDouble(i*2);
         }

         rf.writeUTF("The end of the file");
        rf.close();
        display();

        //移动指针
        rf = new RandomAccessFile(file,"rw");
        //5个8（double为8byte）byte-----字节
        rf.seek(5*8);
        rf.writeDouble(10.1111);
        rf.close();
         display();
    }



}
