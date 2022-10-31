package leetcode.binarytrees;

public class InvertBinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(2);
		node.right = new TreeNode(7);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(9);
		
		
		invertTree(node);
		
		
		System.out.println(node.left.left.val);
		
	}
	
	
	public static TreeNode invertTree(TreeNode node) {
		
		
		if(node==null) return null;
		System.out.println(node.val);
		
			invertTree(node.left);
			invertTree(node.right);
			
			TreeNode tnl = node.left;
			TreeNode tnr = node.right;
			
			node.left = tnr;
			node.right = tnl;
			return node;

	}

}
