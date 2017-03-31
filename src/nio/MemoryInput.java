package nio;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by kang on 17/3/31.
 */

/**
 * 从内存输入
 */
public class MemoryInput {

    public static void main(String[] args) throws IOException {

        StringReader in = new StringReader(BufferedInputFile.read("/Users/kang/Documents/github/concurrent/src/nio/MemoryInput.java"));

        int c;
        while((c=in.read())!=-1){
            System.out.print((char) c);
        }

    }

}
