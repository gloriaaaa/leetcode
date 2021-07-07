package collectionstudy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class learn {
    public void category()
    {

        //List接口
        List<Integer> array1= new ArrayList<>();
        List<Integer> list1=new LinkedList<>();
//        public class LinkedList<E>
//            extends AbstractSequentialList<E>
//            implements List<E>, Deque<E>, Cloneable, java.io.Serializable

        //queue接口
        Queue<Integer> queue = new LinkedList<>();//public interface Queue<E> extends Collection<E>
        Deque<Integer> stack1= new LinkedList<>();//public interface Deque<E> extends Queue<E>

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        //set接口
        HashSet<Integer> set = new HashSet<>();//基于哈希表实现，支持快速查找，但不支持有序性操作。并且失去了元素的插入顺序信息
        TreeSet<Integer> treeSet = new TreeSet<>();//基于红黑树实现，支持有序性操作，例如根据一个范围查找元素的操作。
        // 但是查找效率不如 HashSet，HashSet 查找的时间复杂度为 O(1)，TreeSet 则为 O(logN)
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();//具有 HashSet 的查找效率，并且内部使用双向链表维护元素的插入顺序



        //map接口
        HashMap <Integer,Integer>map = new HashMap<>();//基于哈希表实现。非线程安全，1.7是数组+链表，1.8是数组+链表/红黑树
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();//基于红黑树实现。
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();//使用双向链表来维护元素的顺序，顺序为插入顺序或者最近最少使用（LRU）顺序。


        //juc下
        ConcurrentHashMap <Integer,Integer>concurrentHashMap= new ConcurrentHashMap<>();//1.7是分段锁，1.8去掉分段锁改成cas+synchronized
        ConcurrentSkipListMap<Integer,Integer> concurrentSkipListMap;
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList;
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet;

    }
}
