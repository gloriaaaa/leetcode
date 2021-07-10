package basiclearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncLearn {
    public void func1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println(i+" ");

            }
        }
    }
    public static void main(String[] args) {
//        SyncLearn e1 = new SyncLearn();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());
        String s1="30";
        String s2="3";
        System.out.println((s1+s2).compareTo(s2+s1));
    }
}
