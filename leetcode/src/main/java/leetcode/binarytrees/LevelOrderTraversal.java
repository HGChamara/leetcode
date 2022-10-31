package leetcode.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(2);
		node.right = new TreeNode(7);
		node.left.left = new TreeNode(1);
		//node.left.right = new TreeNode(3);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(9);
		
		System.out.println(levelOrder(node));

	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		
		if(root == null) return new ArrayList<List<Integer>>();
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			List<Integer> currList = new ArrayList<Integer>();
			int s = queue.size();
			for(int i=0; i<s; i++) {
				TreeNode currNode = queue.poll();
				System.out.println(currNode.val);
				currList.add(currNode.val);
				if(currNode.left != null) queue.add(currNode.left);
				if(currNode.right != null) queue.add(currNode.right);
			}
			list.add(currList);
		}
		return list;
		
    }

}
