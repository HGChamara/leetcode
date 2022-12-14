package leetcode.graphs;

import java.util.*;

public class SwimInWater {

    public  static void main(String[] args) {

        int[][] grid = {{0,2},{1,3}};
        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid) {

        int len = grid.length;
        int[][] directions = {{0, 1},{0, -1},{1, 0},{-1, 0}};

        Set<String> visit = new HashSet<>();
        PriorityQueue<WaterPoint> queue = new PriorityQueue<WaterPoint>();
        WaterPoint waterPoint0 = new WaterPoint(grid[0][0], 0, 0);
        queue.add(waterPoint0);
        visit.add(0+"-"+0);

        while(!queue.isEmpty()) {
            WaterPoint curr = queue.poll();
            if(curr.x == len-1 && curr.y == len-1) return curr.height;

            for(int[] dir : directions) {
                int nextX = curr.x+dir[0];
                int nextY = curr.y+dir[1];

                if(nextX < 0 || nextY < 0 || nextX == len || nextY == len || visit.contains(nextX+"-"+nextY)) continue;

                visit.add(nextX+"-"+nextY);
                queue.add(new WaterPoint(Math.max(grid[nextX][nextY], curr.height) , nextX, nextY));

            }
        }
        return 0;
    }
}

class WaterPoint implements Comparable {
    int height;
    int x;
    int y;

    public WaterPoint(int height, int x, int y) {
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        WaterPoint wp = (WaterPoint) o;
        if(height>wp.height) return 1;
        else if(height<wp.height) return -1;
        return 0;
    }
}
