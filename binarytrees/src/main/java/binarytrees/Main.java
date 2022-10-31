package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		
		a.leftNode = b;
		a.rightNode = c;
		b.leftNode = d;
		b.rightNode = e;
		c.rightNode = f;
		
		depthFirstTraverseRec(a).stream()
		.map(node -> node.value)
		.forEach(node -> System.out.println(node));;
		
		System.out.println(breathFirstTraverse(a));
	}
	
	public static List depthFirstTraverse(Node node) {
		
		List<String> list = new ArrayList<String>();
		Stack<Node> stack = new Stack<Node>();
		if(node != null) {
			stack.push(node);
		}
		
		
		while(!stack.isEmpty()) {
			Node currNode = stack.pop();
			list.add(currNode.value);
			
			if(currNode.rightNode != null) {
				stack.push(currNode.rightNode);
			}
			if(currNode.leftNode != null) {
				stack.push(currNode.leftNode);
			}
			
		}
		return list;
	}
	
	public static List<Node> depthFirstTraverseRec(Node node) {
		List<Node> nodes = new ArrayList<Node>();
		
		if(node == null) {
			return new ArrayList<Node>();
		}
		
		List<Node> nodesLeft = depthFirstTraverseRec(node.leftNode);
		List<Node> nodesRight = depthFirstTraverseRec(node.rightNode);
		nodes.add(node);
		nodes.addAll(nodesLeft);
		nodes.addAll(nodesRight);
		return nodes;
	}
	
	public static List<String> breathFirstTraverse(Node node) {
		List<String> list = new ArrayList<String>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		
		if(node == null) return new ArrayList<String>();
		
		while(queue.size() > 0) {
			Node currentNode = queue.remove();
			if(currentNode.leftNode != null) queue.add(currentNode.leftNode);
			if(currentNode.rightNode != null) queue.add(currentNode.rightNode);
			list.add(currentNode.value);
		}
		return list;
	}

}
