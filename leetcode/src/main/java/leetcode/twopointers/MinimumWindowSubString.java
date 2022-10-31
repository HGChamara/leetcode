package leetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

	public static void main(String[] args) {
		
		String s = "acbbaca";
		String t = "aba";
		System.out.println(minWindow(s, t));

	}
	
public static String minWindow(String s, String t) {
        
	int minLen= s.length()+1;
	int matched = 0;
	int start = 0;
	int subS = 0;
	Map<Character, Integer> ml = new HashMap<Character, Integer>();
	
	for(char c : t.toCharArray()) {
		ml.put(c, ml.getOrDefault(c, 0)+1);
	}
	
	for(int r=0; r<s.length(); r++) {
		char right = s.charAt(r);
		
		if(ml.containsKey(right)) {
			ml.put(right, ml.getOrDefault(right, 0)-1);
			if(ml.get(right)==0) {
				matched++;
			}
		}
		
		while(ml.size()==matched) {
			if(minLen > r-start+1) {
				minLen = r-start+1;
			}
			subS = start;
			
			char deleting = s.charAt(start++);
			if(ml.containsKey(deleting)) {
				if(ml.get(deleting)==0) {
					matched--;
				}
				ml.put(deleting, ml.get(deleting)+1);
			}
		}
		
		
	}
	
    return minLen > s.length() ? "" : s.substring(subS,subS+minLen);
        
        
    }

}
