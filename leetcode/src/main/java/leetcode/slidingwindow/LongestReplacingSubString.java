package leetcode.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestReplacingSubString {
	public static void main(String[] args) {
		
		String s = "ABAB";
		int length = characterReplacement(s, 2);
		System.out.println(length);
	}
	
	public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i=0;
        int j=0;
        
        char[] cs = s.toCharArray();
        int max = 0;
        int currmax = 0;
        int currJ = j;
        map.put(cs[0], 1);
        
        while(j<cs.length) {
        	
        	if(currJ != j) {
        	if(map.containsKey(cs[j])) {
        		map.put(cs[j], map.get(cs[j])+1);
        	}
        	else {
        		map.put(cs[j], 1);
        	}
        	}
        	currJ = j;
        	if((j+1-i)-Collections.max(map.values())<=k) {
        		
        		//System.out.println(i+" "+j+" "+cs[i]+" "+cs[j]);
        		//System.out.println(getMax(map));
        		
        		j++;
        		
        		currmax++;
        		if(currmax>max) {
        			max = currmax;
        		}
        	}
        	else {
        		//System.out.println("else : "+i+" "+j+" "+cs[i]+" "+cs[j]+" max="+getMax(map));
        		currmax--;
        		map.put(cs[i], map.get(cs[i])-1);
        		i++;
        	}
        }
       // System.out.println(map);
        return max;
        
    }

}
