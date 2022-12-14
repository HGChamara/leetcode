package leetcode.graphs;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};   // u-from, v-to, w-cost
        System.out.println(networkDelayTime(times,4,2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<NodeTime>> map = new HashMap<>();
        Set<Integer> visit = new HashSet<>();
        int totalTime = 0;

        for(int[] t : times) {
            NodeTime nn = new NodeTime(t[1], t[2]);
            if(map.get(t[0]) != null) {
                map.get(t[0]).add(nn);
            }
            else {
                ArrayList<NodeTime> ant = new ArrayList<>();
                ant.add(nn);
                map.put(t[0], ant);
            }
        }
        //Dijkstra's algorithm

        PriorityQueue<NodeTime> pq = new PriorityQueue<>();
        pq.add(new NodeTime(k, 0));

        while(!pq.isEmpty()) {
            NodeTime nt = pq.poll();
            if(visit.contains(nt.getNode())) continue;
            visit.add(nt.getNode());
            totalTime = Math.max(totalTime, nt.getTime());

            if(map.get(nt.getNode()) != null) {
                for(NodeTime nt1 : map.get(nt.getNode())){
                    if(!visit.contains(nt1.getNode())) {
                        nt1.setTime(nt1.getTime()+nt.getTime());
                        pq.add(nt1);
                    }
                }
            }

        }

        int result = -1;
        if(visit.size()==n) result = totalTime;

        return result;
    }

}

class NodeTime implements Comparable {
    int node;
    int time;

    public NodeTime(int node, int time) {
        this.node = node;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public int getNode() {
        return node;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Object o) {
        NodeTime n1 = (NodeTime) o;
        int result = 0;
        if(n1.getTime() < time) result = 1;
        else if(n1.getTime() > time) result = -1;
        return result;
    }
}

