package leetcode.dynamic;

import java.util.Arrays;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,0,-2,4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int cMax = 1;
        int cMin = 1;

        for (int n : nums) {
            /*if(n == 0) {
                cMax = 1;
                cMin = 1;
                continue;
            }*/

            int temp = cMax*n;
            cMax = Math.max(cMax*n, Math.max(cMin*n, n));
            cMin = Math.min(temp, Math.min(cMin*n, n));
            res = Math.max(res, cMax);
        }
        return res;
    }
}
