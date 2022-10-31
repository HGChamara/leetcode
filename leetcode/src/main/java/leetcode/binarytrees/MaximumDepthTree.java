package leetcode.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthTree {

	/*
	 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 * */
	public static void main(String[] args) {

		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(2);
		node.right = new TreeNode(7);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(9);
		node.left.left.left = new TreeNode(8);
		int count = 0;
		System.out.println(maxDepthDIte(node));
		System.out.println(maxDepth(node));


	}

	public static int maxDepth(TreeNode node) {

		if (node == null)
			return 0;

		return 1 + Math.max(maxDepth(node.left),maxDepth(node.right));
		

	}
	
	
	public static int maxDepthDIte(TreeNode root) {
		if(root == null) return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		int count = 0;
		
		
		
		while(!stack.isEmpty()) {
			TreeNode currNode = stack.pop();
			
			if(currNode.right != null) stack.add(currNode.right);
			if(currNode.left != null) stack.add(currNode.left);
			
			if(currNode.right != null || currNode.left != null) {
				count++;
			}
		}
		return count;
	}
	
	public static int maxDepthBIte(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int count = 0;
		while(!q.isEmpty()) {
			
			for(int i=0; i< q.size(); i++) {
				TreeNode currNode = q.poll();
				if(currNode.right != null) q.add(currNode.right);
				if(currNode.left != null) q.add(currNode.left);
			}
			count++;
		}
		return count;
	}

}