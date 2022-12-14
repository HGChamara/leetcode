package graphs;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {
        int[][] arr = {{1,0},{2,0},{3,1},{3,2}};
        int[] output = findOrder(4,arr);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, ArrayList<Integer>> preMap = new HashMap<>();
        for(int[] pre : prerequisites) {
            if(preMap.get(pre[0])==null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(pre[1]);
                preMap.put(pre[0], list);
            }
            else preMap.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        ArrayList<Integer> output = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            if(!dfs(i,preMap,visit,cycle,output)) return new int[]{};
        }
        int[] outArray = new int[output.size()];
        for(int i=0; i<output.size(); i++) {
            outArray[i] = output.get(i);
        }


        return outArray;
    }

    public static boolean dfs(int node, Map<Integer, ArrayList<Integer>> preMap, Set<Integer> visit, Set<Integer> cycle, ArrayList output ) {
        if(visit.contains(node)) return true;
        if(cycle.contains(node)) return false;

        cycle.add(node);
        ArrayList<Integer> temp = preMap.get(node);
        if(temp != null) {
            for(int al : temp) {
                if(!dfs(al, preMap, visit, cycle, output)) return false;
            }
        }

        cycle.remove(node);
        visit.add(node);

        output.add(node);
        return true;


    }


}
