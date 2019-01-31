package twosum;

public class TwoSumVersion1 {
    public static int[] twoSum(int[] nums,int target) {
        long start = System.currentTimeMillis();
        int i = 0;
        int j = nums.length - 1;
        for (; i < nums.length; i++) {
            boolean flag = false;
            j = nums.length - 1;
            for (; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        //        System.out.println(
        //            (target + " = " + nums[i] + " + " + nums[j] + "; " + "i = " + i + "," + "j = "
        //                + j));
        long end = System.currentTimeMillis();
        System.out.println("双层for循环版本用时:" + (end - start) + "ms");
        return new int[] {nums[i], nums[j]};
    }
}
