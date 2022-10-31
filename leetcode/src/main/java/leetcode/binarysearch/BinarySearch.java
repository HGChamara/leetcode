package leetcode.binarysearch;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		System.out.println(search(nums,23));
	}	
	
	public static int search(int[] nums, int target) {
		return binarySearch(0, nums.length-1, nums, target);
		
        
    }
	
	public static int binarySearch(int start, int end, int nums[], int target) {

		int middle = (start+end)/2;

		int result = -1;
		int midValue = nums[middle];
		if(midValue==target) {
			result = middle;
		}
		if(end>=start) {
		
		 if(midValue<target) {
			return binarySearch(middle+1, end, nums, target);
		}
		
		else if(midValue>target) {
			return binarySearch(start, middle-1, nums, target);
		}}
		return result;
	}
	
}
