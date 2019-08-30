package com.johnlu.exercise.lru;

/**
 * @author lxp
 * @date 2019/8/16 下午7:56
 * @Version 1.0
 */
public class LRUCacheMain {
    private static int count = 101;
    public static void main(String[] args) {
        int 她 = (int) (Math.ceil(count / 0.75) + 1);
        LRUCache l = new LRUCache(100);
        for(int i=0;i<count;i++) {
            l.put(i+"",System.currentTimeMillis());
        }
        System.out.println(l.get("1"));
        l.put(count+1+"",System.currentTimeMillis());
        l.entrySet().forEach(System.out::println);

    }
}
