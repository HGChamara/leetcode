package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = { 1,2};
		int k=1;
		int[] frequentArray = topKFrequent(nums, k);
		for(int g : frequentArray) {
			System.out.print(g+" | ");
		}
	}

	private static int[] topKFrequent(int[] nums, int k) {
		
		HashMap<Integer, Integer> frequentMap = new HashMap<Integer, Integer>();
		for(int num : nums) {
			if(frequentMap.get(num)!=null) {
				frequentMap.put(num, (frequentMap.get(num)+1));
			}
			else {
				frequentMap.put(num, 1);
			}
		}
		ArrayList<Integer>[] freqArr = new ArrayList[nums.length+1];
		for(int i : frequentMap.keySet()) {
			
			if(freqArr[frequentMap.get(i)] !=null) {
				ArrayList<Integer> tempArr = freqArr[frequentMap.get(i)];
				tempArr.add(i);
				freqArr[frequentMap.get(i)] = tempArr;
			}
			else {
				ArrayList<Integer> tempArr = new ArrayList<Integer>();
				tempArr.add(i);
				freqArr[frequentMap.get(i)] = tempArr;
			}
			
		}
		for(ArrayList<Integer> g : freqArr) {
			System.out.print(g+" | ");
		}
		System.out.println("------------------------");
		int[] finalArray = new int[k];
		int finalIndex = k-1;
		for(int i=freqArr.length-1; i>=0; i--) {
			if(freqArr[i] != null) 
			{
				System.out.println(freqArr[i]);
				for(int j : freqArr[i]) 
				{
					if(finalIndex >=0) {
					finalArray[finalIndex] = j;
					finalIndex--;
					}
				}
			}
		}
		
		
		
		return finalArray;
	}

}
