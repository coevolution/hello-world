package com.johnlu.exercise.test.classloader;

/**
 * @author lxp
 * @date 2019/7/22 下午1:51
 * @Version 1.0
 */
/**
 * ClassInitializedOrder for : Java Classload Order Test
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/20
 */
// CASE 1
class ClassInitializedOrder {
    private static boolean initialized = false;
    static {
        println("static 代码块执行。");
        Thread thread = new Thread(() -> initialized = true);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        println("main 函数执行。");
        System.out.println("initialized = " + initialized);
    }

    private static void println(Object o){
        System.out.println(o);
    }
}
