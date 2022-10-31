package leetcode.binarysearch;

public class Search2dMatrix {

	public static void main(String[] args) {
		int[][] inputs =  {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
		System.out.println(searchMatrix(inputs, target));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		for(int i=0; i<matrix.length; i++) {
			System.out.println(matrix[i][matrix[i].length-1]);
			if(target > matrix[i][matrix[i].length-1]) {
				continue;
			}
			else {
				return search(0, matrix[i].length-1, matrix[i], target);
			}
		}
		return false;
    }
	
	public static boolean search(int start, int end,int[] input, int target) {
		
		int midIndex = (start+end)/2;
		int mid = input[midIndex];
		if(target == mid) return true;
		if(end>=start) {
			if(target < mid) return search(start, midIndex-1, input, target); 
			else if(target > mid) return search(midIndex+1, end, input, target); 
		}else {
			return false;
		}
		return false;
		
	}

}
