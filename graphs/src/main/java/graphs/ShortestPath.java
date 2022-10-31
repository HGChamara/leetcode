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

public class ShortestPath {

	public static void main(String[] args) {
		Map<Integer, List<Integer>> graph = new HashMap();
		
		graph.put(10, new ArrayList<Integer>());
		
		graph.put(1, Arrays.asList(2,4));
		graph.put(2, Arrays.asList(1,3));
		graph.put(3, Arrays.asList(2,5));
		graph.put(4, Arrays.asList(1,5));
		graph.put(5, Arrays.asList(3,4));
		
		
		System.out.println(breathFirstTraverse(graph, 1, 5));
	}
	
	public static int breathFirstTraverse(Map<Integer, List<Integer>> graph, int source, int target) {
		Set<Integer> set = new HashSet<Integer>();
		Queue<Element> a = new LinkedList<Element>();
		int length = 1;
		a.add(new Element(source, 0));
		set.add(source);
		
		while(!a.isEmpty()) {
			Element e = a.poll();
			//System.out.println("CHECK "+e.element+"   "+e.length);
			if(e.element==target) return e.length;
			
			for(int d : graph.get(e.element)) {
				if(!set.contains(d)) {
					a.add(new Element(d, e.length+1));
					set.add(d);
					System.out.println(d+" add "+length);
				}else {
					System.out.println(d+" have "+length);
					
				}
				
			}
			length++;
		}
		return 0;
	}
	

}

class Element {
	int element;
	int length;
	
	public Element(int element, int length) {
		this.element = element;
		this.length = length;
	}
	
}
