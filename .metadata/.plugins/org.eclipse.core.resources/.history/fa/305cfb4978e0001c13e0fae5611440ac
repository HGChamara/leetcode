package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inputs = {"4","13","5","/","+"};
		int output = evalRPN(inputs);
		System.out.println(output);
	}
	
	public static int evalRPN(String[] tokens) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("/", "/");
		map.put("+", "+");
		map.put("-", "-");
		map.put("*", "*");
		
		Stack<Integer> stack = new Stack<Integer>();
		for(String s : tokens) {
			
			if(map.containsKey(s)) {
				
				int a = stack.pop();
				int b = stack.pop();
				System.out.println(a+" "+b);
				int c = 0;
				if(s.equals("+")) {
					c = a+b;
				} else if(s.equals("-")) {
					c = b-a;
				}else if(s.equals("*")) {
					c = a*b;
				}else if(s.equals("/")) {
					c = b/a;
				}
				stack.push(c);
			} else {
				stack.push(Integer.valueOf(s));
			}
		}
		return stack.pop();
    }

}
