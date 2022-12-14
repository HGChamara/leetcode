package graphs;

import java.util.*;

public class ReconstructItenary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK","KUL"));
        tickets.add(List.of("JFK","NRT"));
        tickets.add(List.of("NRT","JFK"));
        findItinerary(tickets);
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        result.add("JFK");
        int size=0;
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> l : tickets) {
            if(map.get(l.get(0))!=null) {
                map.get(l.get(0)).add(l.get(1));
            }
            else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(l.get(1));
                map.put(l.get(0), temp);
            }
            size++;
        }
        map.values().stream().forEach(l -> l.sort(new CustomComparator()));
        dfs("JFK", map, result, size);
        return result;
    }

    public static boolean dfs(String src, Map<String, List<String>> map, List<String> result, int size) {
        if(result.size() == size+1) return true;
        if(map.get(src)==null) return false;

        List<String> temp = map.get(src);
        for (ListIterator<String> i = temp.listIterator(); i.hasNext(); i.next()) {
            String s =i.next();
            i.remove();
            result.add(s);

            if(dfs(s,map,result,size)) return  true;
            i.add(s);
            result.remove(s);
        }
        return false;

    }

}

class CustomComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
