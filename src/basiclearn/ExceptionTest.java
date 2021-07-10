package basiclearn;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
    /**空指针异常-java.lang.NullPointerException*/
    public static void nullPointerExceptionTest(){
        String a = null;
        System.out.println(a.length());
    }

    /**超出内存限制异常-java.lang.OutOfMemoryError*/
    //执行时在执行参数VM options设置成-Xms20M -Xmx20M -Xmn10M
    public static void outOfMemoryErrorTest(){
        List list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            byte[] bytes = new byte[1024*1024];
            list.add(bytes);
        }
    }

    public static void main(String[] args) {
        //ExceptionTest.nullPointerExceptionTest();
        //Exception in thread "main" java.lang.NullPointerException
        //	at basiclearn.ExceptionTest.nullPointerExceptionTest(ExceptionTest.java:10)
        //	at basiclearn.ExceptionTest.main(ExceptionTest.java:14)
        try{
            ExceptionTest.nullPointerExceptionTest();

        } catch (Exception e)
        {
            System.out.println("====> java.lang.NullPointerException");
            System.out.println(e.fillInStackTrace());
        }

//        ExceptionTest.outOfMemoryErrorTest();
        try {
            ExceptionTest.outOfMemoryErrorTest();
        } catch (OutOfMemoryError  e) {
            System.out.println("====> java.lang.OutOfMemoryError");
            System.out.println(e.fillInStackTrace());
        }
    }
}
