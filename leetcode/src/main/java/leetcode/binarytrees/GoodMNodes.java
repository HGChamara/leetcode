package leetcode.binarytrees;

public class GoodMNodes {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(1);
		node.right = new TreeNode(4);
		node.left.left = new TreeNode(3);
		node.right.left = new TreeNode(1);
		node.right.right = new TreeNode(5);
		System.out.println(goodNodes(node));
	}
	
	public static int goodNodes(TreeNode node) {
        
		
		return goodNodesCal(node, node.val);
		
    }
	
	public static int goodNodesCal(TreeNode node, int maxValue) {
        
		int result = 0;
		
		if(node == null) return 0;
		
		if(node.val >= maxValue) {
			result = 1;
			maxValue = node.val;
		}
		
		result += goodNodesCal(node.left, maxValue);
		result += goodNodesCal(node.right, maxValue);
		
		return result;
		
    }

}
