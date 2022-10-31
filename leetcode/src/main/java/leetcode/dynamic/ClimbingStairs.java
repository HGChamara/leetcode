package leetcode.dynamic;

import java.util.HashMap;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(6));
		System.out.println(rec(0,6));
		System.out.println(recMem(0,6, new HashMap<Integer, Integer>()));
	}
	
	public static int climbStairs(int n) {
		
		int one = 1;
		int two = 1;
		
		for(int i=2; i<=n; i++) {
			int temp = one;
			one = one + two;
			two = temp;
		}
		
		return one;
	}
	
	public static int rec(int curr, int n) {
		if(curr==n) return 1;
		if(curr>n) return 0;
		return rec(curr+1, n) + rec(curr+2, n);
		
	}
	
	public static int recMem(int curr, int n, HashMap<Integer, Integer> map) {
		
		if(map.containsKey(curr)) return map.get(curr);
		if(curr==n) return 1;
		if(curr>n) return 0;
		
		int out = rec(curr+1, n) + rec(curr+2, n);
		map.put(curr, out);
		return out;
		
	}

}
