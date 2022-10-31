package leetcode.dynamic;

import java.util.HashMap;

public class Fibonacci {

	public static void main(String[] args) {
		//1,1,2,3,5,8,13,21
		System.out.println(fibByBottomsUp(8));
		System.out.println(fibByRecurssion(8));
		System.out.println(fibByMemoize(8, new HashMap<Integer, Integer>()));
	}
	
	public static int fibByBottomsUp(int position) {
		int[] fibs = new int[position+1];
		fibs[1] = 1;
		fibs[2] = 1;
		if(position==1 || position==2) {
			return 1;
		}
		for(int i=3; i<=position; i++) {
			fibs[i] = fibs[i-1]+fibs[i-2];
		}
		return fibs[position];
		
	}
	
	public static int fibByRecurssion(int position) {
		if(position == 1 || position == 2) {
			return 1;
		}
		return fibByRecurssion(position-1) + fibByRecurssion(position-2); 
		
	}
	
	public static int fibByMemoize(int position, HashMap<Integer, Integer> map) {
		map.put(1, 1);
		map.put(2, 1);
		if(map.containsKey(position)) {
			return map.get(position);
		}
		int value = fibByMemoize(position-1, map) + fibByMemoize(position-2, map);
		map.put(position, value);
		return value;
		
	}

}
