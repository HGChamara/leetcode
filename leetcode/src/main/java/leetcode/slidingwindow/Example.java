package leetcode.slidingwindow;

public class Example {

	public static void main(String[] args) {
		int[] numbers = {1, 4, 2, 10, 23, 3, 1, 0, 20};
		int k =4;
		int maxSum = maxSum(numbers,k);
		System.out.println(maxSum);
	}

	private static int maxSum(int[] numbers, int k) {
		
		int maxSum = 0;
		for(int i=0; i<k; i++) {
			maxSum += numbers[i];
		}
		
		int currMax = maxSum;
		for(int i=1; i<=numbers.length-k; i++) {
			currMax = currMax - numbers[i-1]+numbers[i+k-1];
			if(maxSum < currMax) {
				maxSum = currMax;
			}
		}
		
		return maxSum;
	}

}
