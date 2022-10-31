package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LongestDistinctSubString {

	public static void main(String[] args) {
		String s = "dvdf";
		int i = lengthOfLongestSubstring(s);
		System.out.println(i);
	}
	
	public static int lengthOfLongestSubstring(String s) {
        
		if(s.equals("")) {
			return 0;
		}
		
		char[] chars = s.toCharArray();
		
		int ld = 1;
		
		int l =0;
		int r =1;
		int currLenght = 1;
		List<Character> charList = new ArrayList<Character>();
		while(r<chars.length) {
			
			char a = chars[l];
			char b = chars[r];
			charList.add(a);
			System.out.println("a : "+b);
			if(!charList.contains(b)) {
				System.out.println(b);
				charList.add(b);
				r++;
				currLenght++;
				if(currLenght>ld) {
					ld = currLenght;
				}
			}
			else {
				l++;
				charList = new ArrayList<Character>();
				currLenght=1;
				r = l+1;
			}
			
		}
		
		
		return ld;
    }

}
