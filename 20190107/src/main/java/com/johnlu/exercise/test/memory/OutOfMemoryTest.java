package com.johnlu.exercise.test.memory;

import com.sun.management.VMOption;
import org.junit.Test;
import sun.management.HotSpotDiagnostic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxp
 * @date 2019/7/17 下午2:29
 * @Version 1.0
 */
public class OutOfMemoryTest {
    //failed
    @Test public void test1() {
        double freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        double maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);
        System.out.println("maxMemory=" + maxMemory);

        List<VMOption> options = new HotSpotDiagnostic().getDiagnosticOptions();
        for (VMOption vmOption : options) {
            System.out.println(vmOption);
        }
        byte[] b = new byte[120101024 * 2];
        for (byte bi : b) {
            bi = 1;

        }

        System.out.println("b.length=" + b.length);

        freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);
        System.out.println("maxMemory=" + maxMemory);
        Runtime.getRuntime().gc();

        freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);
        System.out.println("maxMemory=" + maxMemory);
    }

    @Test public void test2() {
        double freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        double maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);

        System.out.println("maxMemory=" + maxMemory);
        List list = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            list.add(new OOMObject());
        }

        System.out.println("list.size()=" + list.size());
        freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);
        System.out.println("maxMemory=" + maxMemory);
        Runtime.getRuntime().gc();
        freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);
        System.out.println("maxMemory=" + maxMemory);
    }

    public static void fillHeap(int num) {
        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            System.out.println("num=" + i);
            double freeMemory1 = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
            double maxMemory1 = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
            System.out.println("freeMemory1=" + freeMemory1);
            System.out.println("maxMemory1=" + maxMemory1);
            list.add(new OOMObject());
        }
        System.out.println("list.size()=" + list.size());
    }

    public static class OOMObject {
        private byte[] arrs = new byte[1024 * 64];
    }

    public static void main(String[] args) {
        double freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        double maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);
        System.out.println("maxMemory=" + maxMemory);
        Boy b1 = new Boy();
        System.out.println(b1);
        fillHeap(1);
        freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);
        System.out.println("maxMemory=" + maxMemory);

        Runtime.getRuntime().gc();
        freeMemory = convertByte2Gigabyte(Runtime.getRuntime().freeMemory());
        maxMemory = convertByte2Gigabyte(Runtime.getRuntime().maxMemory());
        System.out.println("freeMemory=" + freeMemory);
        System.out.println("maxMemory=" + maxMemory);
    }

    private static double convertByte2Gigabyte(long num) {
        return num * 0.1d / 1024 / 1024 / 1024;
    }
}
