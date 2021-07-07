package collectionstudy;

import java.util.*;

public class collectiontest {
    public static void main(String[] args) {
        //int c=(int)Math.pow(10,5);

        int [] a = {1,2,3};
        System.out.println("a: "+ Arrays.toString(a));

        int [] b = new int[]{1,2,3};
        System.out.println("b: "+Arrays.toString(b));

        int [] c = new int[3];
        for(int i=0;i<c.length;i++)
        {
            c[i]=i+1;
        }
        System.out.println("c: "+Arrays.toString(c));

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            arr.add(i+1);
        }
        System.out.println("arr: "+arr.toString());

        arr.add(99);//[1,2,3,99]
        arr.add(3,88);//[1,2,3,88,99],索引加值

//取值
        int c1=c[1];
        int arr1=arr.get(1);
//改
        c1=11;
        arr.set(1,11);
//删
        arr.remove(3);//？？？删除的是索引
//长度
        //int csize = c.length();
        int arrsize=arr.size();
//查找
        boolean is99=arr.contains(99);

//排序
        Arrays.sort(c);
        Collections.sort(arr); //O(nlogn) 从小到大
        Collections.sort(arr,Collections.reverseOrder());


        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(2,99);
        int element = list.get(2);
        int index = list.indexOf(99);
        list.set(2,88);
        list.remove(2);//索引 O(N) 要找到索引位置的复杂度为O(N)
        int length=list.size();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
//offer
        System.out.println(queue.toString());

        int temp1=queue.peek();//获得当前队头//1
        int temp2=queue.poll();//出队并删除

        System.out.println(queue.isEmpty());

        System.out.println(queue.size());

        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.println(temp);
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
//获取栈顶元素
        stack.peek();
//删除
        int temp= stack.pop();
        stack.size();
        stack.isEmpty();
        while(!stack.isEmpty()){
            int num = stack.pop();
        }
        Deque<Integer> stack1= new LinkedList<>();

        String[] hashTable = new String[4];
        HashMap<Integer,String> map = new HashMap<>();


        hashTable[1] = "hanmeimei";
        hashTable[2] = "lihua";
        hashTable[3] = "siyangyuan";

        map.put(1, "hanmeimei");
        map.put(2, "lihua");
        map.put(3, "siyangyuan");

        map.remove(1);
        map.get(3);
        map.containsKey(3);
        map.size();
        map.isEmpty();

        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(3);
        set.add(5);
        set.add(2);
        set.add(10);
        set.contains(2);
        set.remove(2);
        set.size();

//        boolean[] visited = new boolean[m*n];

//最小堆
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
//最大堆

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap.add(10);
        minheap.peek();
        minheap.poll();
        minheap.size();
        while(!minheap.isEmpty()){
            System.out.println(minheap.poll());
        }

    }
}
