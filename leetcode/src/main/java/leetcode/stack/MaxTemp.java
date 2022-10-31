package leetcode.stack;

import java.util.Stack;

public class MaxTemp {
	public static void main(String[] args) {

		int[] a = { 73, 74, 75, 71, 69, 72, 76, 73 };

		for (int o : dailyTemperatures(a)) {
			System.out.println(o);
		}
	}

	public static int[] dailyTemperatures(int[] temperatures) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		int[] outputList = new int[temperatures.length];
		
		for (int i = 1; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				outputList[stack.peek()] = (i - stack.peek());
				stack.pop();
			}
			stack.add(i);
		}
		return outputList;
	}
}
