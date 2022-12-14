package leetcode.graphs;

import java.util.HashSet;

public class LargestIsland {

    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;
        HashSet<String> set = new HashSet<String>();
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j < grid[i].length; j++) {
                int currArea = findArea(grid, i, j, set);
                if (maxCount<currArea) maxCount = currArea;
            }
        }
        return maxCount;
    }

    public int findArea(int[][] grid, int i, int j, HashSet<String> set) {

        if(set.contains(i+"-"+j)) return 0;
        if(i<0 || i> grid.length-1) return 0;
        if(j<0 || j> grid[i].length-1) return 0;
        if(grid[i][j]==0) return 0;

        set.add(i+"-"+j);

        int count = 1;
        count += findArea(grid, i-1, j, set);
        count += findArea(grid, i+1, j, set);
        count += findArea(grid, i, j-1, set);
        count += findArea(grid, i, j+1, set);
        return count;
    }

}
