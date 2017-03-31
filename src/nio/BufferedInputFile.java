package nio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kang on 17/3/31.
 */

/**
 * 缓冲输入文件
 */
public class BufferedInputFile {

    public static String read(String filename) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(filename));

        String s;
        StringBuilder sb = new StringBuilder();

        while((s=in.readLine())!=null){

            sb.append(s+"\n");
        }
        //要把输入流关掉
        in.close();

        return sb.toString();

    }




    public static void main(String[] args) throws IOException {

        System.out.println(read("/Users/kang/Documents/github/concurrent/src/nio/BufferedInputFile.java"));

    }




}
