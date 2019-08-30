package com.johnlu.exercise.test;

import com.google.common.collect.Lists;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.List;

/**
 * @author lxp
 * @date 2019/7/29 下午8:38
 * @Version 1.0
 */
public class DriveClassNameTest {
    public static void main(String[] args) {
        List list = Lists.newArrayList();
        list.add("3st");
        list.add("gsfgst");
        list.add("sdat");
        list.add("xst");
        list.add("bst");
        list.add("cx3st");
        list.add(new Man());
        list.forEach(System.out::println);
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
