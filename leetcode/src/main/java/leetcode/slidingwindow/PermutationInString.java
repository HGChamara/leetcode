package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public static void main(String[] args) {
		
		String s1 = "abcdxabcde";
				
		String s2 = "abcdeabcdx";
		
		boolean isPer = checkInclusion(s1, s2);
		System.out.println(isPer);
	}
	
	public static boolean checkInclusion(String s1, String s2) {
        boolean isPer = false;
        
        int windowSize = s1.length();
        int a = 0;
        int b = windowSize;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s1.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0)+1);
        }
       // System.out.println(map);
       
        while(b<=s2.length()) {
        	int e=0;
        	String sub = s2.substring(a, b);
        	System.out.println(sub.length()+" "+s1.length());
        	
        	
        	 Map<Character, Integer> mapSub = new HashMap<Character, Integer>();
             for(char c : sub.toCharArray()) {
             	mapSub.put(c, mapSub.getOrDefault(c, 0)+1);
             }
             
             for(char s : map.keySet()) {
            	 if(map.getOrDefault(s, 0).intValue() == mapSub.getOrDefault(s, 0).intValue()) {
            		 System.out.println(map.get(s) +"  "+ mapSub.get(s));
            		 e++;
            	 }
             }
            System.out.println(e);
             if(e==map.size()) {
            	 isPer = true;
            	 b=s2.length();
             }
        	//System.out.println(cp);
        	//System.out.println("------------------");
        	a++;
        	b++;
        	//System.out.println(sub);
        }
        
        
        return isPer;
    }

}
