package leetcode.binarytrees;

public class SameSubTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if(root != null && subRoot == null) return true; 
		if(root == null && subRoot != null) return false; 
		if(isSametree(root, subRoot)) return true;
		else return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
	
	
	public static boolean isSametree(TreeNode root, TreeNode subRoot) {;
		if(root == null && subRoot != null) return false; 
		if(root != null && subRoot == null) return false; 
		if(root == null && subRoot == null) return true; 
		if(root.val != subRoot.val) return false;
		else return (isSametree(root.left, subRoot.left) && isSametree(root.right, subRoot.right));
    }

}
