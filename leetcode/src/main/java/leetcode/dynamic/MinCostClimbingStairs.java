package leetcode.dynamic;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] costNew = Arrays.copyOf(cost, cost.length+1);
        costNew[cost.length] = 0;

        for(int i=costNew.length-3; i>=0; i--) {
            costNew[i] += Math.min(costNew[i+1], costNew[i+2]);
        }
        return Math.min(costNew[0], costNew[1]);
    }

}
