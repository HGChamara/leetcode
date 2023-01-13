package leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

public class StockBuyAndSellWithCooldown {

    public static void main(String[] args) {
        int[] prices = {1,2,4 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        HashMap<String, Integer> map = new HashMap<>();
        return dfs(0, true, prices, map);
    }
    //TODO - not correct
    private static int dfs(int i, boolean buy, int[] prices, HashMap<String, Integer> map) {
        if(i>= prices.length) return 0;
        if(map.containsKey(i+""+buy)) return map.get(i+""+buy);

        if(buy) {
            int b = dfs(i+1, false, prices, map) - prices[i];
            int cooldown = dfs(i+1, true, prices, map);
            map.put(i+""+true, Math.max(b, cooldown));
        }
        else {
            int s = dfs(i+2, true, prices, map) + prices[i];
            int cooldown = dfs(i+1, true, prices, map);
            map.put(i+""+false, Math.max(s, cooldown));
        }
        System.out.println(i);
        return map.get(i+""+buy);
    }

}
