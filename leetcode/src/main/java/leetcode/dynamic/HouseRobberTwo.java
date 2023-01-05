package leetcode.dynamic;

import java.util.Arrays;

public class HouseRobberTwo {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1}; // this is now circular first house connected to the last house
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {

        int[] arr1 = Arrays.copyOfRange(nums,1, nums.length);
        int[] arr2 = Arrays.copyOfRange(nums,0, nums.length-1);
        if(nums.length==1) return nums[0];
        return Math.max(robHelper(arr1), robHelper(arr2));
    }

    public static int robHelper(int[] nums) {

        int r1=0, r2 = 0; // {r1, r2, -------- }

        for(int i: nums) {
            int temp = Math.max(r1+i, r2);
            r1 = r2;
            r2 = temp;
        }
        return r2;
    }
}
