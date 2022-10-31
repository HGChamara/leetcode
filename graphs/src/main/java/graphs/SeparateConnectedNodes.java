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

public class SeparateConnectedNodes {

	public static void main(String[] args) {
		Map<String, List<String>> graph = new HashMap();
		graph.put("e", new ArrayList<String>());
		
		graph.put("a", Arrays.asList("b","c"));
		graph.put("b", Arrays.asList("d"));
		graph.put("d", Arrays.asList("b","f"));
		graph.put("c", Arrays.asList("a","e"));
		graph.put("e", new ArrayList<String>());
		graph.put("f", new ArrayList<String>());
		
		graph.put("g", Arrays.asList("h"));
		graph.put("h", Arrays.asList("k"));
		graph.put("k", Arrays.asList("g"));
		Set<String> set = new HashSet<String>();
		int count = 0;
		
		for(String s : graph.keySet()) {
			if(explore(graph, s, set)) {
				count++;
			}
		}
		
		
		
		System.out.println(count);
	}
	
	public static boolean explore(Map<String, List<String>> graph, String source,  Set<String> set) {
		
		if(set.contains(source)) return false;
		set.add(source);
		
		for(String node : graph.get(source)) {
			explore(graph, node, set);
		}
		return true;
	}
	
	
	


}
