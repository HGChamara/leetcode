package binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMin {

	public static void main(String[] args) {
		NodeInt a = new NodeInt(1);
		NodeInt b = new NodeInt(2);
		NodeInt c = new NodeInt(3);
		NodeInt d = new NodeInt(4);
		NodeInt e = new NodeInt(5);
		NodeInt f = new NodeInt(6);
		
		a.leftNode = b;
		a.rightNode = c;
		b.leftNode = d;
		b.rightNode = e;
		c.rightNode = f;
		
		System.out.println(treeSumReccursive(a));
		System.out.println(treeSumDepthFirst(a));
		System.out.println(treeSumBreathFirst(a));
	}
	
	private static int treeSumReccursive(NodeInt node) {
		if(node == null) return 0;
		return node.value + treeSumReccursive(node.leftNode) + treeSumReccursive(node.rightNode);
	}
	
	private static int treeSumDepthFirst(NodeInt node) {
		int total = 0;
		Stack<NodeInt> stack  = new Stack<NodeInt>();
		
		if(node != null) stack.add(node);
		
		while(!stack.isEmpty()) {
			NodeInt curr = stack.pop();
			total += curr.value;
			if(curr.rightNode != null) stack.add(curr.rightNode);
			if(curr.leftNode != null) stack.add(curr.leftNode);
		}
		
		return total;
	}
	
	private static int treeSumBreathFirst(NodeInt node) {
		int total = 0;
		Queue<NodeInt> queue = new LinkedList<NodeInt>();
		
		if(node != null) queue.add(node);
		
		while(!queue.isEmpty()) {
			NodeInt curr = queue.poll();
			if(curr.leftNode != null) queue.add(curr.leftNode);
			if(curr.rightNode != null) queue.add(curr.rightNode);
			total += curr.value;
		}
		
		
		return total;
	}
	

}
