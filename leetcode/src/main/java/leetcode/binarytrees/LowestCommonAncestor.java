package leetcode.binarytrees;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
		if(root.val==p.val || root.val==q.val) return root;
		if(root.val>p.val && root.val<q.val) return root;
		if(root.val<p.val && root.val>q.val) return root;
		
		if(root.val>p.val && root.val>q.val) lowestCommonAncestor(root.left, p, q);
		if(root.val<p.val && root.val<q.val) lowestCommonAncestor(root.right, p, q);
		return null;
	}

}
