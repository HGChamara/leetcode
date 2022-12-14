package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();

        for(int i=0; i < heights.length; i++) {
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, heights[0].length-1, atl, heights[i][heights[0].length-1], heights);
        }

        for(int j=0; j< heights[0].length; j++) {
            dfs(0, j, pac, heights[0][j], heights);
            dfs(heights.length-1, j, atl, heights[heights.length-1][j], heights);
        }
        for(List<Integer> a : pac){
            if(atl.contains(a)) {
                list.add(a);
            }
        }

        return list;
    }

   public static void dfs(int i, int j, Set<List<Integer>> set, int previousHeight, int[][] arr) {
        ArrayList<Integer> currList = new ArrayList<>();
        currList.add(i);
        currList.add(j);

        if(set.contains(currList) || i<0 ||i == (arr.length) || j<0 || j == (arr[0].length) || arr[i][j] < previousHeight) {

        }
        else {
            set.add(currList);
            dfs(i-1, j, set, arr[i][j], arr);
            dfs(i+1, j, set, arr[i][j], arr);
            dfs(i, j-1, set, arr[i][j], arr);
            dfs(i, j+1, set, arr[i][j], arr);
        }

   }

}
