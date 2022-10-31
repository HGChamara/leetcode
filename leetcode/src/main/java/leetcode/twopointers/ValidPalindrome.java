package leetcode.twopointers;

public class ValidPalindrome {
	
	
	
	public static void main(String[] args) {
		String s = " ";
		boolean isPalindrome = isPalindrome(s);
		System.out.println(isPalindrome);
	}
	
	
	private static boolean isPalindrome(String s) {
		
char[] s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();

		if(s1.length==0) {
			return true;
		}
		for(int i=0; i<=s1.length/2; i++) {
			if(s1[i] != s1[(s1.length-1)-i]) 
			{
				return false;
			}
		}
		
		return true;
	} 
}
