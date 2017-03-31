package nio;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by kang on 17/3/31.
 */

/**
 * 格式化内存输入
 *
 */
public class FormattedMemoryInput {


    public static void main(String[] args) {

        DataInputStream in = null;
        try {

            in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("/Users/kang/Documents/github/concurrent/src/nio/MemoryInput.java").getBytes()));
            while(true){
                System.out.print((char)in.readByte());
            }

        } catch (IOException e) {

        }




    }
}
