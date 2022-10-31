package leetcode.binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		
		SerializeDeserialize s = new SerializeDeserialize();
		//System.out.println(s.serialize(node));
		System.out.println("---------------------");
		TreeNode n = s.deserialize(s.serialize(node));
		System.out.println("---------------------");
		/*System.out.println(n.val);
		System.out.println(n.left.val);
		System.out.println(n.right.val);*/
	}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfsSerialize(builder, root);
        return builder.toString();
    	
    }
    
    public void dfsSerialize(StringBuilder builder, TreeNode node) {
    	if (node == null) {
    		builder.append("N").append(",");
    	}
    	else {
        	builder.append(node.val).append(",");
        	dfsSerialize(builder, node.left);
        	dfsSerialize(builder, node.right);
    	}
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	System.out.println(data);
    	
    	Queue<String> queue = new LinkedList<String>();
    	queue.addAll(Arrays.asList(data.split(",")));
    	
        return dfs(queue);
    }
    
    public TreeNode dfs(Queue<String> queue) {
    	
    	String curr = queue.remove();    	
    	System.out.println(curr);
    	if(curr.trim().equals("N")) {
    		return null;
    	} else {
    	TreeNode n = new TreeNode(Integer.valueOf(curr.trim()))  ;
    	
    	n.left = dfs(queue);
    	n.right = dfs(queue);
    	return n;
    	}
    }

}
