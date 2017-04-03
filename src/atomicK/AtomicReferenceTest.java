package atomicK;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by kang on 17/4/3.
 */
public class AtomicReferenceTest {

    static AtomicReference<User> ar = new AtomicReference<>();



    public static void main(String[] args) {

        User user = new User("conan",15);
        ar.set(user);

        User updateUser = new User("hello",25);
        ar.compareAndSet(user,updateUser);
        System.out.println(ar.get().getName());
        System.out.println(ar.get().getClass());
        System.out.println(ar.get());

        System.out.println(user);
        System.out.println(" ");
        System.out.println(updateUser);


    }

    static class User{

        private String name;
        private int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }
/**
        @Override
        public String toString() {
            return "["+ name +"  :" +old+"]";
        }
 **/
    }


}
