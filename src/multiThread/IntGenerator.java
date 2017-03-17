package multiThread;

/**
 * Created by kang on 17/3/17.
 */
public abstract class IntGenerator {

    private volatile boolean canceled = true;
    public abstract int next();
    public void cancel(){canceled = true;}
    public boolean isCanceled(){
        return  canceled;
    }

}
