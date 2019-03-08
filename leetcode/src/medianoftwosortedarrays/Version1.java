package medianoftwosortedarrays;

import com.johnlu.exercise.QuickSort;

public class Version1 {
    public double findMedianSortedArrays(int[] nums1,int[] nums2) {
        double median = 0;
        int[] nums = new int[nums1.length+nums2.length];
        int i = 0;
        for(;i<nums1.length;i++) {
            nums[i] = nums1[i];
        }
        int j = i;
        for(;i-j<nums2.length;i++) {
            nums[i] = nums2[i-j];
        }
        int high =nums.length-1;
        int low =0;
        System.out.println("数组首位:"+low+",数组末位为:"+high);
        for(int k:nums) {
            System.out.print(k+" ");
        }
        System.out.println();
        QuickSort.sort(nums,low,high);
        System.out.print("排序后:");
        for(int k:nums) {
            System.out.print(k+" ");
        }
        if(nums.length % 2 == 1) {
            median = nums[nums.length/2];
        }else if(nums.length %2 == 0) {
            median = (nums[nums.length/2-1]+nums[nums.length/2])*1.0d/2;
        }else {
            System.out.println("整数模2一定等于0或1,而不是"+nums.length %2);
        }
        return median;
    }
}
