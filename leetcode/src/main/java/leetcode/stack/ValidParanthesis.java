package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		String s = "()[[{}";
		System.out.println(isValid(s));
	}
	
	 public static boolean isValid(String s) {
		 Map<Character, Character> map = new HashMap<Character, Character>();
		 map.put('}', '{');
		 map.put(']', '[');
		 map.put(')', '(');
		 
		 Stack<Character> stack = new Stack<Character>();
		 for(char c : s.toCharArray()) {
			 if(map.containsKey(c)) {
				 if((!stack.empty()) && stack.peek()==map.get(c)) {
					 stack.pop();
				 }
				 else return false;
			 }
			 else stack.push(c);
		 }
		 return stack.isEmpty();
	 }

}
