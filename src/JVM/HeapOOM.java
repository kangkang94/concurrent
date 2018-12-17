package JVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kang on 17/11/13.
 */
public class HeapOOM {

    static class OOMobject{
        Byte[] bytes = new Byte[1024*1024];
    }

    public static void main(String[] args) {

        List<OOMobject> list = new ArrayList<OOMobject>();

        while (true){
            list.add(new OOMobject());
        }

    }


}
