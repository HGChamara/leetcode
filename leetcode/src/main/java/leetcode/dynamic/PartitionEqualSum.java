package leetcode.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSum {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if(sum%2 == 1) return false;

        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        for(int num : nums) {
            if(num == sum/2) return true;
            HashSet<Integer> currSet = new HashSet<>();
            for(int s : set) {
                if(s+num == sum/2) return true;
                currSet.add(s+num);
                currSet.add(s);
            }
            set = currSet;
        }
        return false;
    }

}
