package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	public static void main(String[] args) {
		
		
		
		int[] nums = {-2,0,0,2,2};
		List<List<Integer>> sums = threeSum(nums);
		System.out.println(sums);
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length-2; i++) {
			int c = nums[i];
			int j = i+1;
			int k = nums.length-1;
		
			
			while(j<k) {
				int a = nums[j];
				int b = nums[k];
				if(a+b+c<0) {
					j++;
				}
				else if(a+b+c>0) {
					k--;
				}
				else if(a+b+c==0) {
					System.out.println(j+" - "+k);
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(c);
					temp.add(a);
					temp.add(b);
					if(!list.contains(temp)) {
					list.add(temp);}
					j++;
					k--;
				}
			}
		}
		
		return list;
	}
	 
	 
}
