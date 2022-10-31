package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
	public static void main(String[] args) {
		
		String a = "testasd";
		char[] hash = new char[26];
		for(char s :a.toCharArray()) {
			hash[s-'a']++;
			System.out.println((s-'a'));
		}
		String str=new String(hash);
		System.out.println(""+str);
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> anagramGroups = groupAnagrams(strs);
		System.out.println(anagramGroups);
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> anagramGroupList = new ArrayList<List<String>>();
		
		HashMap<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		for(String str : strs) {
			
			char[] hash = new char[26];
			for(char s :str.toCharArray()) {
				hash[s-'a']++;
				System.out.println((s-'a')+" "+hash[s-'a']);
			}
			String key = new String(hash);
			//char[] chars = str.toCharArray();
			//Arrays.sort(chars);
			//String orderedString = new String(chars);
			
			if(anagramMap.get(key)==null) {
				ArrayList<String> indexes = new ArrayList<String>();
				indexes.add(str);
				anagramMap.put(key,indexes);
			}
			else {
				anagramMap.get(key).add(str);
			}
		}
		
		for(List<String> indexes : anagramMap.values()) 
		{
			anagramGroupList.add(indexes);
		}
		
		return anagramGroupList;
	}
}
