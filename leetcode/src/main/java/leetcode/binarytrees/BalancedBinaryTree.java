package leetcode.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BalancedBinaryTree {
	
	static int maxDiff = 0;
	public static void main(String[] args) {

		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		//node.left.left = new TreeNode(1);
		//node.left.right = new TreeNode(3);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		
		System.out.println(isBalanced(node));
		System.out.println(maxDiff);

	}
	
	public static boolean isBalanced(TreeNode node) {

		maxDiff(node);
		if(maxDiff>1) return false;
		else return true;

	}
	
	public static int maxDiff(TreeNode node) {

		if(node == null) return -1;
		
		int lr = maxDiff(node.left);
		int rt = maxDiff(node.right);
		
		if(Math.abs(lr-rt)> maxDiff) maxDiff = Math.abs(lr-rt);
		
		
		return 1+ Math.max(lr, rt);

	}
		
		

}
