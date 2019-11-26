package com.johnlu.exercise;

public class repeat2 {
    public void sort(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            if (arr[h] >= povit) {
                h--;
            } else {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
            }
        }
        while (l < h) {
            if (arr[l] <= povit) {
                l++;
            } else {
                int temp = arr[l];
                arr[h] = arr[l];
                arr[l] = temp;
            }
        }
    }
}
