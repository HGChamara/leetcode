package leetcode.dynamic;

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {

        int[] coins = {1,2,5};
        System.out.println(change(5, coins));
    }

    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp,0);
        dp[0] = 1;

        for(int coin : coins) {
            for(int i=1; i<=amount; i++) {
                if(coin <=i) {
                    dp[i] = dp[i] + dp[i-coin];
                }
            }
        }
        return dp[amount];
    }

}
