package leetcode.dynamic;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,3,5}, 7));
    }

    public static int coinChange(int[] coins, int amount) {

        int[] values = new int[amount+1];
        Arrays.fill(values, amount+1);
        values[0] = 0;

        for(int i=0; i< values.length; i++) {
            for(int c : coins) {
                if(i-c >=0) {
                    values[i] = Math.min(values[i], 1+values[i-c]);
                }
            }
        }
        int result = -1;
        if(values[amount] != amount+1 ) result = values[amount];
        return result;
    }
}
