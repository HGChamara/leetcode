package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class HasNodeUndirected {

	public static void main(String[] args) {
		Map<String, List<String>> graph = new HashMap();
		graph.put("a", Arrays.asList("b","c"));
		graph.put("b", Arrays.asList("d"));
		graph.put("d", Arrays.asList("b","f"));
		graph.put("c", Arrays.asList("a","e"));
		graph.put("e", new ArrayList<String>());
		graph.put("f", new ArrayList<String>());
		
		Set<String> set = new HashSet<String>();
		
		
		System.out.println(hasNodeRec(graph, "e", "f", set));
	}
	
	public static boolean hasNodeRec(Map<String, List<String>> graph, String source, String dest, Set<String> set) {
		
		if(set.contains(source)) return false;
		if(source.equals(dest)) return true;
		set.add(source);
		for(String node : graph.get(source)) {
			System.out.println(node);
			if(hasNodeRec(graph, node, dest, set)) {
				return true;
			}
		}
		return false;
	}
	
	
	


}
