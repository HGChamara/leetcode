package leetcode.arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] ints = {1,0,2,3};
		int[] results = productExceptSelf(ints);
		for(int i : results) {
			System.out.println(i);
		}
	}

	public static int[] productExceptSelf(int[] nums) {
		
		int[] result = new int[nums.length];
		result[0] = 1;
		result[nums.length-1] = 1;
		int prefix = 1;
		int postfix = 1;
		
		for(int i=1; i<=nums.length-1; i++) {
			prefix = prefix*nums[i-1];
			result[i] = prefix;
			
		}
		for(int i=nums.length-2; i>=0; i--) {
			postfix = postfix*nums[i+1];
			result[i] = result[i]*postfix;
		}
		
        return result;
    }
	
}
