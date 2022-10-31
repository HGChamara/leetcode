package leetcode.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class anagram {
	
	public static void main(String[] args) {
		
		String s = "anagram";
		String t = "nagaram";
		boolean result = isAnagram2(s, t);
		System.out.println(result);
		System.out.println(isAnagram(s, t));
	}

	private static boolean isAnagram(String s, String t) {
		
		boolean result = true;
		HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
		HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();
		
		if(s.length() != t.length()) {
			return false;
		}
		
		for(char cs : s.toCharArray()) {
			if(mapS.containsKey(cs)) {
				mapS.put(cs, (mapS.get(cs)+1));
			}
			else {
				mapS.put(cs, 1);
			}
		}
		
		for(char ct : t.toCharArray()) {
			if(mapT.containsKey(ct)) {
				mapT.put(ct, (mapT.get(ct)+1));
			}
			else {
				mapT.put(ct, 1);
			}
		}
		
		for(char cs : s.toCharArray()) {
			
			if((mapS.get(cs)==null) || (mapT.get(cs)==null)) {
				result = false;
				break;
			}
			
			if(mapS.get(cs).intValue() != mapT.get(cs).intValue()) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	private static boolean isAnagram2(String s, String t) {
		
		if(s==null && t!=null) return false;
		if(s!=null && t==null) return false;
		if(s==null && t==null) return true;
		if(s.length() != t.length()) return false;
		
		char[] c1 = new char[26];
		char[] c2 = new char[26];
		
		for(char a : s.toCharArray()) {
			c1[a-'a']++;
		}
		for(char a : t.toCharArray()) {
			c2[a-'a']++;
		}
		
		System.out.println(new String(c1));
		if(new String(c1).equals(new String(c2))) {
			return true;
		}
		return false;
		
	}

}
