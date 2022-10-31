package binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeSum {

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
		
		System.out.println(treeMaxReccursive(a));
	}
	
	private static int treeMaxReccursive(NodeInt node) {
		if(node == null) return Integer.MIN_VALUE;
		if(node.leftNode == null && node.rightNode == null) return node.value;
		int max = Math.max(treeMaxReccursive(node.leftNode), treeMaxReccursive(node.rightNode));
		return node.value + max;
		
	}
	
}
