package leetcode.dynamic;

import java.util.HashMap;

public class LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                dfs(i,j,-1,matrix,map);
            }
        }
        return map.values().stream().max(Integer::compare).get();
    }

    private static int dfs(int i, int j, int pervValue, int[][] matrix, HashMap<String, Integer> map) {
        if(i<0 || i== matrix.length || j<0 || j==matrix[0].length || matrix[i][j]<=pervValue) return 0;
        if(map.get(i+"-"+j) != null) return map.get(i+"-"+j);

        int res=1;
        res = Math.max(res, 1+dfs(i+1, j, matrix[i][j], matrix, map));
        res = Math.max(res, 1+dfs(i, j+1, matrix[i][j], matrix, map));
        res = Math.max(res, 1+dfs(i-1, j, matrix[i][j], matrix, map));
        res = Math.max(res, 1+dfs(i, j-1, matrix[i][j], matrix, map));
        map.put(i+"-"+j, res);
        return res;
    }
}
