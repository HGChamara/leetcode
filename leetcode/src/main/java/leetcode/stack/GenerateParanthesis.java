package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParanthesis {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));

	}
	
	 public static List<String> generateParenthesis(int n) {
		 List<String> result = new ArrayList<String>();
		 Stack<String> stack = new Stack<String>();
		 
		 backtrack(0, 0, stack, n, result);
		 
		 
		 return result;
	        
	 }
	 
	 
	 public static void backtrack(int open, int closed, Stack<String> stack, int n, List<String> result) {
		 
		 System.out.println(open+" "+closed+" "+stack.toString());
		 
		 if(open==n && closed==n) {
			 String r = stack.stream().collect(Collectors.joining());
			 
			 result.add(r);
		 }
		 
		 if(open < n) {
			 stack.add("(");
			 backtrack(open+1, closed, stack, n, result);
			 stack.pop();
		 }
		 
		 if(open > closed) {
			 stack.add(")");
			 backtrack(open, closed+1, stack, n, result);
			 stack.pop();
		 }
	 }

}
