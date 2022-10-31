package leetcode.twopointers;

public class TwoSum {

	public static void main(String[] args) {
		int[] input = {-1,0};
		int[] ints = twoSum(input,-1);
		System.out.println(ints[0]+" "+ints[1]);
	}
	
	private static int[] twoSum(int[] input, int target) {
		
		int i = 0;
		int j = input.length - 1;
		
		while(i<j) 
		{
			if((input[i]+input[j]) < target) {
				i++;
			}
			else if((input[i]+input[j]) > target) {
				j--;
			}
			else {
				return new int[] {i+1, j+1};
			}
		}
		
		return null;
	}
	
}
