package multiThread;

import java.util.concurrent.Callable;

/**
 * Created by kang on 17/3/16.
 */
public class TaskWithResult implements Callable<String> {

    private  int id;
    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }

}
