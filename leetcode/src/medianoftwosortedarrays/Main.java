package medianoftwosortedarrays;

import com.johnlu.exercise.MathTools;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = MathTools.sortedArray(1,5);
        int[] nums2 = MathTools.sortedArray(2,7);
        Version1 version1 = new Version1();
        double median = version1.findMedianSortedArrays(nums1,nums2);
        System.out.println("中位数为:"+median);
    }
}
