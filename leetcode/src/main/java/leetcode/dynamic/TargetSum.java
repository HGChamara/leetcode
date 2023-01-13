package leetcode.dynamic;

import java.util.HashMap;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,0};
        int target = 1;
        System.out.println(findTargetSumWays(nums,target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> cache = new HashMap<>();
        return backTrack(0, 0, nums, target, cache);
    }

    public static int backTrack(int i, int currTotal, int[] nums, int target, HashMap<String, Integer> cache) {
        if(i == nums.length) {
            int returnValue = (currTotal == target) ?  1 :  0;
            return returnValue;
        }
        if(cache.containsKey(i+"-"+currTotal)) return cache.get(i+"-"+currTotal);

        int sum = backTrack(i+1, currTotal+nums[i], nums, target, cache) +backTrack(i+1, currTotal-nums[i], nums, target, cache);
        System.out.println("sum="+sum+"   i="+i+"  currTotal="+currTotal);
        cache.put(i+"-"+currTotal, sum);

        return cache.get(i+"-"+currTotal);
    }
}
