package leetcode.dynamic;

import java.util.Arrays;

public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);

        for(int i= nums.length-1; i>=0; i--) {
            for(int j=i+1; j< nums.length; j++) {
                if(nums[i] < nums[j]) lis[i] = Math.max(lis[i], 1+lis[j]);
            }
        }
        Arrays.sort(lis);
        return lis[nums.length-1];

    }

    public static int lengthOfLIS2(int[] nums) {
        int result = 0;
        for(int i=0; i< nums.length; i++) {
            int currMx = 1;
            int cc = nums[i];
            for(int j=i; j< nums.length; j++) {

                if(cc<nums[j]) {
                    currMx++;
                    cc = nums[j];
                }
            }
            result = Math.max(result, currMx);
        }
    return  result;

    }

}
