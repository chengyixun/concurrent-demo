package com.example.concurrentlearn.wangzheng;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap 是通过双向链表和散列表这两种数据结构组合实现的。
 * LinkedHashMap 中的“Linked”实际上是指的是双向链表，并非指用链表法解决散列冲突。
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {

        HashMap<Integer, Integer> m = new LinkedHashMap<>();
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            System.out.println(e.getKey());
        }


        HashMap<Integer, Integer> m1 = new LinkedHashMap<>(10, 0.75f, true);
        m1.put(3, 11);
        m1.put(1, 12);
        m1.put(5, 23);
        m1.put(2, 22);

        /**
         * 再次将键值为 3 的数据放入到 LinkedHashMap 的时候，
         * 会先查找这个键值是否已经有了，然后，再将已经存在的 (3,11) 删除，
         * 并且将新的 (3,26) 放到链表的尾部
         */
        m1.put(3, 26);
        m1.get(5); //我们将被访问到的数据移动到链表的尾部

        System.out.println("它不仅支持按照插入顺序遍历数据，还支持按照访问顺序来遍历数据");
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            System.out.println(entry.getKey());
        }



    }
}
