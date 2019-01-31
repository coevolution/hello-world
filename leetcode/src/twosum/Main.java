package twosum;

import com.johnlu.exercise.MathTools;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = MathTools.randomSort(1,100000);
        Arrays.stream(nums).forEach(System.out::println);
        TwoSumVersion1.twoSum(nums,14);
        TwoSumVersion2.twoSum(nums,14);
    }
}
