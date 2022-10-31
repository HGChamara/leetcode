package leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {

	public static void main(String[] args) {
		
		int[] nums = {9,1,-3,2,4,8,3,-1,6,-2,-4,7};
		int l = longestConsecutive(nums);
		System.out.println(l);
	}

	private static int longestConsecutive(int[] nums) {
		
		if(nums.length==0) {
			return 0;
		}
		
		int longestConsec  =1;
		Set<Integer> numSet = new HashSet<Integer>();
		for(int num : nums) {
			numSet.add(num);
		}
		
		for(int s :nums) {
			
			int currNum = s;
			int currConses = 1;
			int nextNum = currNum+1;
			if(!numSet.contains(currNum-1)) 
			{
				while(numSet.contains(nextNum)) {
					currConses++;
					nextNum++;
				}
			}
			
			if(currConses>longestConsec) 
			{
				longestConsec = currConses;
			}
			
		}
		return longestConsec;
		
	}

}
