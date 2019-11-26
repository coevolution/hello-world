package com.johnlu.exercise.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lxp
 * @date 2019/8/27 下午7:15
 * @Version 1.0
 */
public class ArrayListRemoveTest {
    public static void main(String[] a) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("bb");
        list.add("aa");
        list.add("cc");
        // 删除元素 bb
        remove(list, "bb");
        for (String str : list) {
            System.out.println(str);
        }

    }

    public static void remove(ArrayList<String> list, String elem) {
        // 五种不同的循环及删除方法
        // 方法一：普通for循环正序删除，删除过程中元素向左移动，不能删除重复的元素
        //        for (int i = 0; i < list.size(); i++) {
        //            if (list.get(i).equals(elem)) {
        //                list.remove(list.get(i));
        //            }
        //        }
        // 方法二：普通for循环倒序删除，删除过程中元素向左移动，可以删除重复的元素
        //        for (int i = list.size() - 1; i >= 0; i--) {
        //            if (list.get(i).equals(elem)) {
        //                list.remove(list.get(i));
        //            }
        //        }
        // 方法三：增强for循环删除，使用ArrayList的remove()方法删除，产生并发修改异常 ConcurrentModificationException
        //        for (String str : list) {
        //            if (str.equals(elem)) {
        //                list.remove(str);
        //            }
        //        }
        // 方法四：迭代器，使用ArrayList的remove()方法删除，产生并发修改异常 ConcurrentModificationException
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(elem)) {
                list.remove(iterator.next());
            }
        }

        // 方法五：迭代器，使用迭代器的remove()方法删除，可以删除重复的元素，但不推荐
        //        Iterator iterator = list.iterator();
        //        while (iterator.hasNext()) {
        //            if(iterator.next().equals(elem)) {
        //                iterator.remove();
        //            }
        //        }
    }
}
