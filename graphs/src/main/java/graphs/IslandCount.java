package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class IslandCount {

	public static void main(String[] args) {
		Map<String, List<String>> graph = new HashMap();
		/*graph.put("e", new ArrayList<String>());
		
		graph.put("a", Arrays.asList("b","c"));
		graph.put("b", Arrays.asList("d"));
		graph.put("d", Arrays.asList("b","f"));
		graph.put("c", Arrays.asList("a","e"));
		graph.put("e", new ArrayList<String>());
		graph.put("f", new ArrayList<String>());
		
		graph.put("g", Arrays.asList("h"));
		graph.put("h", Arrays.asList("k"));
		graph.put("k", Arrays.asList("g"));*/
		
		Set<String> set = new HashSet<String>();
		String[][] arr = {	{"W","W","W","W","W","W","L","W"},
							{"L","W","L","W","W","W","L","W"},
							{"W","L","W","W","L","W","W","W"},
							{"W","L","W","W","L","L","W","W"},
							{"W","W","L","W","W","L","W","W"},
							{"W","W","W","W","W","W","W","W"} };
			
		int count = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(explore(arr, i, j, set)) count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean explore(String[][] graph, int r, int c, Set<String> set) {
		//System.out.println(r+" "+c);
		if(set.contains(r+"-"+c)) return false;
		if(r<0 || r > graph.length ) return false;
		if(c<0 || c > graph[r].length ) return false;
		if(graph[r][c].equals("W")) return false;
		
		set.add(r+"-"+c);

		explore(graph, r-1, c, set);
		explore(graph, r+1, c, set);
		explore(graph, r, c+1, set);
		explore(graph, r, c-1, set);
		return true;
	}
	
	
	


}
