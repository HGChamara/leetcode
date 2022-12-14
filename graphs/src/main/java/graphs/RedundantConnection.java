package graphs;

import java.util.HashMap;
import java.util.Map;

public class RedundantConnection {
    public static void main(String[] args) {

        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] rns = findRedundantConnection(edges);
        if(rns != null){
            for(int r : rns){
                System.out.println(r);
            }
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {

        int[] par = new int[edges.length+1];
        int[] rank = new int[edges.length+1];

        for(int i=0; i<=edges.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for(int[] j : edges) {
            if(!union(j[0], j[1], par, rank)) return new int[]{j[0], j[1]};
        }

        return null;
    }

    public static int findParent(int n, int[] par) {

        int p = par[n];
        while(p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    public static boolean union(int n1, int n2, int[] par, int[] rank) {

        int pn1 = findParent(n1, par);
        int pn2 = findParent(n2, par);

        if(pn1 == pn2) return false;

        if(rank[pn1] > rank[pn2]) {
            par[n2] = pn1;
            rank[n1] += rank[n2];
        } else {
            par[n1] = pn2;
            rank[n2] +=rank[n1];
        }
        return true;
    }
}
