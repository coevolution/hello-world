package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumVersion2 {
    public static int[] twoSum(int[] nums,int target) {
        long start = System.currentTimeMillis();
        int[] arr = new int[2];
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(m.containsKey(target-nums[i])) {
                arr[0] = target-nums[i];
                arr[1] = nums[i];
                //                System.out.println(
                //                    (target + " = " + arr[0] + " + " + arr[1] + "; " + "i = " + m.get(target-nums[i]) + "," + "j = "
                //                        + i));
                break;
            }
            m.put(nums[i],i);
        }
        long end = System.currentTimeMillis();
        System.out.println("hashmap单层for循环版本用时:"+(end-start)+"ms");
        return arr;
    }
}
