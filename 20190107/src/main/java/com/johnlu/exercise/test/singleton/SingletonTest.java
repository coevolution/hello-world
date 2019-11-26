package com.johnlu.exercise.test.singleton;

/**
 * @author lxp
 * @date 2019/8/28 上午9:52
 * @Version 1.0
 */
public class SingletonTest {
    private static final SingletonTest instance = new SingletonTest();

    //私有的默认构造函数
    private SingletonTest() {
    }

    //静态工厂方法
    public static SingletonTest getInstance() {
        return instance;
    }
}
