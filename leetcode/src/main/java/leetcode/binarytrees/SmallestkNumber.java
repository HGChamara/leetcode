package leetcode.binarytrees;

import java.util.Stack;

public class SmallestkNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int kthSmallest(TreeNode root, int k) {
		TreeNode curr = root;
		int c = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(curr != null && !stack.empty()) {
			while(curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			
			curr = stack.pop();
			c++;
			
			if(c == k) {
				return curr.val;
			}
			
			curr = curr.right;
		}
		
		
		
		return 0;
    }

}
