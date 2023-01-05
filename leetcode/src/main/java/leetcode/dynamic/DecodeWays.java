package leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(s.length(),1);
        System.out.println(dp(s, map));
    }

    public static int numDecodings(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(s.length(),1);

        return dfs(0, map, s);
    }

    private static int dfs(int i, Map<Integer, Integer> map, String s) {
        if(map.get(i) != null) return map.get(i);
        if(s.charAt(i)=='0') return 0;

        int res = dfs(i+1, map, s);
        if(i+1<s.length() && (s.charAt(i)=='1' || (s.charAt(i)=='2' && Integer.valueOf(s.substring(i+1, i+2))<=6 )  )) {
            System.out.println("i");
            res += dfs(i+2, map, s);
        }
        map.put(i, res);
        return res;
    }

    public static int dp(String s, Map<Integer, Integer> map) {
        for(int i= s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '0') map.put(i, 0);
            else map.put(i, map.get(i+1));

            if(i+1<s.length() && (s.charAt(i)=='1' || (s.charAt(i)=='2' && Integer.valueOf(s.substring(i+1, i+2))<=6 )  )) {
                map.put(i, map.get(i) + map.get(i+2));
            }

        }

        return map.get(0);
    }
}
