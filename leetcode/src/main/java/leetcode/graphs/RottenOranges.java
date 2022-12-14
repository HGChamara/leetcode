package leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {

        int goodCount=0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i< grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) goodCount++;
                if(grid[i][j]==2) {
                    int[] arr = {i,j};
                    q.add(arr);
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty() && goodCount > 0) {
            int size = q.size();
            for(int i=0; i< size; i++) {
                int[] a = q.poll();

                for(int[] d : directions) {
                    int r = d[0]+a[0];
                    int c = d[1]+a[1];

                    if(r<0 || r==grid.length ||
                        c<0 || c==grid[0].length || grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    q.add(new int[]{r,c});
                    goodCount--;
                }

            }
            time++;
        }

        return (goodCount>0) ? -1 : time;
    }


}
