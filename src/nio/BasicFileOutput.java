package nio;

/**
 * Created by kang on 17/3/31.
 */

import java.io.*;

/**
 * 基本的文件输出
 */
public class BasicFileOutput {



    public static void main(String[] args) throws IOException {


        /**
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine())!=null){
            sb.append(s+"\n");
        }

        System.out.print(sb);
         **/
        BufferedReader in = new BufferedReader(new FileReader("/Users/kang/Documents/github/concurrent/src/nio/TestEOF.java"));
        String s;
        int countLine=0;
        //为了格式化输出内容，使用PrintWriter;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/kang/Documents/github/concurrent/src/nio/hello.java")));

        while((s = in.readLine())!=null){

            out.println(countLine++ +": "+s);
        }

        out.close();
        System.out.println(BufferedInputFile.read("/Users/kang/Documents/github/concurrent/src/nio/hello.java"));


    }


}
