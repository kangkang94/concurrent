package nio;

/**
 * Created by kang on 17/3/31.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Static functions for reading and writing text files as a single string,and treating a file as ArrayList.
 */
public class TestFile extends ArrayList<String>{

    //Read a file as a single string
    public static String read(String name){

        StringBuilder sb = new StringBuilder();
        BufferedReader in=null;
        String s;
            try {

                in = new BufferedReader(new FileReader(new File(name).getAbsoluteFile()));
                while((s=in.readLine())!=null){
                    sb.append(s+"\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

      return  sb.toString();
    }

    //write a single file in one method call;
    public static void write(String file,String text){

        PrintWriter out=null;
        try {

            //没有读的功能，直接写把text写到文件中
             out= new PrintWriter(new File(file).getAbsoluteFile());
            out.print(text);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }


    }

    //Read a file,split by any regular expression
    public TestFile(String fileName,String splitter){

        super(Arrays.asList(fileName.split(splitter)));
        if (get(0).equals(" "))
            remove(0);

    }

    public TestFile(String fileName){
        this(fileName,"\n");
    }

    public void write(String filename){
        PrintWriter out=null;
        try {
            out= new PrintWriter(new File(filename).getAbsoluteFile());
            for (String item:this){
                out.println(item);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }

    }



}