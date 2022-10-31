package leetcode.graphs;

import java.util.HashSet;
import java.util.Set;

public class CountIslands {

	public static void main(String[] args) {
		char[][] grid = {
					{'1','1','0','0','0'},
		            {'1','1','0','0','0'},
		            {'0','0','1','0','0'},
		            {'0','0','0','1','1'}
		};
		
		System.out.println(numIslands(grid));
	}
	
	public static int numIslands(char[][] grid) {
		Set<String> set = new HashSet<String>();
		int count = 0;
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[i].length; j++) {
        		if(explore(grid, i, j, set)) count++;
        	}
        }
        return count;
    }

	private static boolean explore(char[][] grid, int i, int j, Set<String> set) {
		if(set.contains(i+"-"+j)) return false;
		if(i<0 || i>=grid.length) return false;
		if(j<0 || j>=grid[i].length) return false;
		if(grid[i][j]=='0') return false;
		set.add(i+"-"+j);
		explore(grid, i+1, j, set);
		explore(grid, i-1, j, set);
		explore(grid, i, j+1, set);
		explore(grid, i, j-1, set);
		return true;
	}

}
