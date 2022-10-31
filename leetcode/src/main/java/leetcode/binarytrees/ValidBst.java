package leetcode.binarytrees;

public class ValidBst {

	public static void main(String[] args) {
		
	}
	
	public boolean isValidBST(TreeNode root) {
        return valid(root, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }
	
	public boolean valid(TreeNode node, double left, double right) {
		if(node == null) return true;
		if(!((node.val>left) && (node.val<right))) return false;
		
		return valid(node.left, left, node.val) && valid(node.right, node.val, right);
	}

}
