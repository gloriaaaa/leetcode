package basiclearn;

import java.util.HashSet;
import java.util.Set;

public class basics {

    public static void main(String[] args) {
        /**
         * 装箱和拆箱，包装类与基本类型，== equals hashcode
         */
        System.out.println("装箱和拆箱，包装类与基本类型，== equals hashcode");
        Integer a = new Integer(5);
        Integer b = new Integer(5);
        System.out.println(a==b); //false
        // ==对基本类型比较值，引用类型如果没有覆盖equals方法时 比较的是地址,此时等价于==比较
        //覆盖equals方法后比较的是内容
        System.out.println(a.equals(b)); //true

        Integer c = 5; //装箱，调用的是valueOf(int)方法
        System.out.println(a==c); //false
        System.out.println(a.equals(c)); //true

        int d=5;
        int e=a;  //拆箱，调用的是intvalue方法
        System.out.println(d==c); //true
        System.out.println(d==e); //true
        System.out.println(a.equals(d)); //true

        //对于集合类，添加元素先判断hashcode是否相同，如果相同再判断equals
        //因此重写equals需要重写hashcode，不然是内存值，永远不相等
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set.toString());

        /**
         * String StringBuffer StringBuilder
         */
        System.out.println("String StringBuffer StringBuilder");
        String s="hello"; //private final char value[];
        StringBuilder sb = new StringBuilder();
        //public final class StringBuilder
        // extends AbstractStringBuilder
        // implements java.io.Serializable, CharSequence
        //char[] value;
        sb.append("h");//public StringBuilder append(String str) {


        StringBuffer sb1 = new StringBuffer();
        //public final class StringBuffer
        //    extends AbstractStringBuilder
        //    implements java.io.Serializable, CharSequence
        sb1.append("e");//public synchronized StringBuffer append(String str)
        //StringBuffer对方法加了同步锁 线程安全，StringBuilder不是。

        //final 关键字的作用
        //final变量初始化后不可更改，引用类型初始化后不可指向别的对象
        //final修饰类表示类不可被继承，所有成员方法隐式的指定为final方法
        //final方法防止任何继承类修改含义，以前可以提升效率转为内嵌调用，现在不用了
        //jvm和java应用会缓存final变量，在多线程下保持线程安全，

        String s1 = "todo";
        String s2= "todo";
        String s3 = "to";
        String s4="do";
        String s5 = s3+s4;
        String s6=new String(s5);
        System.out.println(s1==s2);//true
        System.out.println(s1==s5);//false
        System.out.println(s1==s6);//false

        System.out.println("intern");


        String ss = new String("1");
        ss.intern();
        String ss2 = "1";
        System.out.println(ss == ss2); //false

        String ss3 = new String("1") + new String("1");
        ss3.intern();
        String ss4 = "11";
        System.out.println(ss3 == ss4);  //true

        String sss = new String("1");
        String sss2 = "1";
        sss.intern();
        System.out.println(sss == sss2); //false

        String sss3 = new String("1") + new String("1");
        String sss4 = "11";
        sss3.intern();
        System.out.println(sss3 == sss4);  //false






    }
}