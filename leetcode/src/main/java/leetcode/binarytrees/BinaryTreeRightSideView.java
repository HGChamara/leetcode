package leetcode.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		System.out.println(rightSideView(node));
	}
	
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		if(root == null) return list;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode currNode = root;
		while(!q.isEmpty()) {
			
			int k = q.size();
			for(int i=0; i<k; i++) {
				
				currNode = q.poll();
				if(currNode.left != null) q.add(currNode.left);
				if(currNode.right != null) q.add(currNode.right);
				
			}
			list.add(currNode.val);
		}
        return list;
    }

}
