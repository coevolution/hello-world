package com.johnlu.exercise;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MathTools {
    /**
     * 利用set无序性将输入的整数值进行排序，因为对于同一整数数组，set遍历结果是一样的，而带小数时set的遍历结果是就会不同。
     * 根据这个原理，每次遍历时先随机生成一个小数加到整数后面，存到set里，取出时再将小数部分去掉，就得到了一个无重复的随机整数数组了
     * （注：1.8jdk中set数组近乎有序，整数以大小排序，小数以小数点后面第一位的大小排序，所以本方法依然有效）
     * @param min
     * @param max
     * @return
     */
    public static int[] randomSort(int min, int max) {
        int[] arr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = min + i;
        }
        Random random = new Random();
        Set<Float> set = new HashSet<>();
        for (int i : arr) {
//            set.add(i + random.nextFloat());
            set.add((float) i);
        }
        int j = 0;
        for (Float f : set) {
            arr[j] = (int) f.floatValue();
            j++;
        }
        return arr;
    }

    public static int[] sortedArray(int min, int max) {
        int[] arr = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = min + i;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = MathTools.randomSort(100,120);
        for(int i:arr) {
            System.out.print(i+" ");
        }
    }
}
