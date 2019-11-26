package com.johnlu.exercise.test;

import com.johnlu.exercise.myannotation.MyAnnotation;
import org.junit.Test;

/**
 * @author lxp
 * @date 2019/7/4 上午10:01
 * @Version 1.0
 */
public class TestMyAnnotation {
    @MyAnnotation String userName;

    @Test public void testMyAnnotation1() {
        userName = "得到的";
    }
}
