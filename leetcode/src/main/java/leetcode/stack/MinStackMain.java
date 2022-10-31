package leetcode.stack;

import java.util.Stack;

public class MinStackMain {
	
	public static void main(String[] args) {
		
	}
	
	

}

class MinStack {

	Stack<Integer> stack;
	Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() > val) minStack.add(val);
    }
    
    public void pop() {
    	
    	if(stack.pop() == minStack.peek()) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
    	
        return minStack.peek();
    }
}
