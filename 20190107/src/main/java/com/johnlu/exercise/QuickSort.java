package com.johnlu.exercise;

public class QuickSort {

    public static void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= povit)
                l++;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
//        print(arr);
        System.out.println("l=" + (l + 1) + "h=" + (h + 1) + "povit="+povit);
        if (l > low)
            sort(arr, low, l - 1);
        if (h < high)
            sort(arr, l + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = MathTools.randomSort(20,30);
        for(int i:arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("===========================");
        sort(arr,0,10);
        for(int i:arr) {
            System.out.print(i+" ");
        }
    }
}

