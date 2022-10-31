package graphs;

import java.util.HashSet;
import java.util.Set;

public class LargestIsland {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		String[][] arr = {	{"W","W","W","W","W","W","L","W"},
							{"L","W","L","W","W","W","L","W"},
							{"W","L","W","W","L","W","W","W"},
							{"W","L","W","W","L","L","W","W"},
							{"W","W","L","W","L","L","W","W"},
							{"W","W","W","W","W","W","W","W"} };
			
		int maxCount = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				int currCount = explore(arr, i, j, set);
				if(currCount>0 && currCount>maxCount) maxCount = currCount; 
			}
		}
		
		System.out.println(maxCount);
	}
	
	public static int explore(String[][] graph, int r, int c, Set<String> set) {
		//System.out.println(r+" "+c);
		if(set.contains(r+"-"+c)) return 0;
		if(r<0 || r > graph.length ) return 0;
		if(c<0 || c > graph[r].length ) return 0;
		if(graph[r][c].equals("W")) return 0;
		
		set.add(r+"-"+c);
		int count =1; //1 because need to add the current count. When code comes to this line it is already a land.
		count += explore(graph, r-1, c, set);
		count += explore(graph, r+1, c, set);
		count += explore(graph, r, c+1, set);
		count += explore(graph, r, c-1, set);
		return count;
	}
	
	
	


}
