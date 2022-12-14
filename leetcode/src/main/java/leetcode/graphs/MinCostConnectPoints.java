package leetcode.graphs;

import java.util.*;

public class MinCostConnectPoints {

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int res = minCostConnectPoints(points);
        System.out.println(res);
    }

    //Minimum spanning trees
    //Prims algorithm
    public static int minCostConnectPoints(int[][] points) {

        int n = points.length;
        Map<Integer, ArrayList<CostNode>> adj = new HashMap<>();

        for(int i=0; i<n; i++) {
            int[] l1 = points[i];
            for(int j=i+1; j<n; j++) {
                int[] l2 = points[j];
                int dist = Math.abs(l1[0]-l2[0]) + Math.abs(l1[1]-l2[1]);

                CostNode c1 = new CostNode(dist,j);
                CostNode c2 = new CostNode(dist,i);

                if(adj.get(i) != null) {
                    ArrayList<CostNode> a = adj.get(i);
                    a.add(c1);
                } else {
                    ArrayList<CostNode> a = new ArrayList<>();
                    a.add(c1);
                    adj.put(i,a);
                }

                if(adj.get(j) != null) {
                    ArrayList<CostNode> a = adj.get(j);
                    a.add(c2);
                } else {
                    ArrayList<CostNode> a = new ArrayList<>();
                    a.add(c2);
                    adj.put(j,a);
                }
            }
        }

        //Prim's Algorithm
        int res = 0;
        PriorityQueue<CostNode> pQueue = new PriorityQueue<>();
        CostNode c0 = new CostNode(0,0);
        pQueue.add(c0);
        Set<Integer> visit = new HashSet<>();

        while(visit.size()<n) {
            CostNode tm = pQueue.poll();
            if (visit.contains(tm.getNode())) continue;
            res += tm.getCost();
            visit.add(tm.getNode());

            if(adj.get(tm.getNode()) != null) {
                for(CostNode a : adj.get(tm.getNode())) {
                    pQueue.add(a);
                }
            }

        }
        return res;
    }
}

class CostNode implements Comparable{
    private int cost;
    private int node;

    public CostNode(int cost, int node) {
        this.cost = cost;
        this.node = node;
    }
    public int getCost () {
        return cost;
    }

    public int getNode () {
        return node;
    }

    @Override
    public int compareTo(Object o) {

        CostNode c = (CostNode) o;
        if(cost>c.cost) return 1;
        else if(cost < c.cost) return -1;
        else return 0;
    }
}
