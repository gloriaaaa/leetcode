import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//int compareTo(T t)方法说明
//定义:比较此对象与指定对象的顺序。
//返回:负整数、零或正整数。如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
//假如result返回1。Collections.sort(List)方法就是升序;
//假如result返回-1。Collections.sort(List)方法就是降序;


//16min
public class Solution406 {
    public  int [][] reconstructQueue(int [][] people){
        int m= people.length;
        int n= people[0].length;
        if(n==0||m==0) return new int [0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        //第一列降序小-大,第二列大-小
        List<int[]> list = new ArrayList<>();
        for(int [] i:people){
            System.out.println(i[1]);
            list.add(i[1],i);

        }
        return list.toArray(new int[list.size()][2]);
    }
//    public int[][] reconstructQueue(int[][] people) {
//
//        int n = people.length;
//        int m = people[0].length;
//        if (n == 0 || m == 0) return new int[0][0];
//
//        Arrays.sort(people, new Comparator<int[]>() {
//
//            @Override
//            public int compare(int[] o1, int[] o2) {
//
//                // 先按身高降序，若身高相同则按 k 值升序。
//                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
//            }
//        });
//
//        // 遍历排序后的数组，根据 K 插入到 K 的位置上。
//        List<int[]> list = new ArrayList<>();
//        for (int[] i : people) {
//
//            list.add(i[1], i);
//        }
//        return list.toArray(new int[list.size()][2]);
//    }


}
