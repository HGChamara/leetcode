package graphs;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int[][] arr = {{1,0},{1,2}};
        System.out.println(canFinish(3, arr));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> preMap = new IdentityHashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] i : prerequisites) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i[1]);
            if(preMap.get(i[0]) == null) {
                preMap.put(i[0], list);
            } else {
                preMap.get(i[0]).add(i[1]);
            }
        }
        System.out.println(preMap);
        for(int i=0; i < numCourses; i++) {
            if(!dfs(i, preMap, set)) return false;
        }
        return true;
    }

    public static boolean dfs(int i, Map<Integer, ArrayList<Integer>> preMap, Set<Integer> set){
        if(set.contains(i)) return false;
        if(preMap.get(i)==null) {
            return true;
        }
        set.add(i);
        for(int k : preMap.get(i)) {
            if(!dfs(k, preMap,set)) return false;
        }
        set.remove(i);
        preMap.remove(i);
        return true;
    }
}
