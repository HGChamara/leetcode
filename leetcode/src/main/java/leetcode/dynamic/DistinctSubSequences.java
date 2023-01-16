package leetcode.dynamic;

import java.util.HashMap;

public class DistinctSubSequences {

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        HashMap<String, Integer> cache = new HashMap<>();
        return dfs(0, 0, s, t, cache);
    }

    private static int dfs(int i, int j, String s, String t, HashMap<String, Integer> cache) {
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(cache.get(i+"-"+j)!=null) return cache.get(i+"-"+j);

        if(s.charAt(i)==t.charAt(j)) {
            cache.put(i+"-"+j,( dfs(i+1,j+1,s,t,cache)+dfs(i+1,j,s,t,cache)));
        }
        else{
            cache.put(i+"-"+j,(dfs(i+1,j,s,t,cache)));
        }
        return cache.get(i+"-"+j);
    }

}
