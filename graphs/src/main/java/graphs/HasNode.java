package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class HasNode {

	public static void main(String[] args) {
		Map<String, List<String>> graph = new HashMap();
		graph.put("a", Arrays.asList("b","c"));
		graph.put("b", Arrays.asList("d"));
		graph.put("d", Arrays.asList("f"));
		graph.put("c", Arrays.asList("e"));
		graph.put("e", new ArrayList<String>());
		graph.put("f", new ArrayList<String>());
		System.out.println(hasNodeRec(graph, "c", "f"));
		System.out.println(hasNodeBreath(graph, "a", "f"));
		System.out.println(hasNodeDepth(graph, "c", "f"));
	}
	
	public static boolean hasNodeRec(Map<String, List<String>> graph, String source, String dest) {
		if(source.equals(dest)) return true;
		
		for(String node : graph.get(source)) {
			if(hasNodeRec(graph, node, dest)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean hasNodeBreath(Map<String, List<String>> graph, String source, String dest) {
		Queue<String> q = new LinkedList<String>();
		q.add(source);
		
		while(!q.isEmpty()) {
			String curr = q.poll();
			if(curr.equals(dest)) return true;
			for(String s : graph.get(curr)) {
				q.add(s);
			}
		}
		return false;
	}
	
	public static boolean hasNodeDepth(Map<String, List<String>> graph, String source, String dest) {
		
		Stack<String> s = new Stack<String>();
		s.add(source);
		
		while(!s.isEmpty()) {
			String curr = s.pop();
			if(curr.equals(dest)) return true;
			for(String c : graph.get(curr)) {
				s.add(c);
			}
		}
		return false;
	}


}
