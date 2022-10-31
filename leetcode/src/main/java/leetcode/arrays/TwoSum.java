package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 18;
		int[] output = towSum(nums,target);
		for(int num :output)  {
			System.out.println(num);
		}
	}

	private static int[] towSum(int[] nums, int target) {
		int index = 0;
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		
		for(int num : nums) {
			
			if(numMap.get(target-num)==null) {
				numMap.put(num, index);
			}
			else {
				return new int[] {numMap.get(target-num), index};
			}
			
			index++;
		}
		
		return null;
	}

}
