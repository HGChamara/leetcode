package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        return (node != null) ? clone(node, map) : null;
    }

    public Node clone(Node node, HashMap<Node, Node> map) {
        if(map.containsKey(node)) return  map.get(node);
        Node copy = new Node(node.val);
        map.put(node, copy);
        for(Node n : node.neighbors) {
            copy.neighbors.add(clone(n, map));
        }
        return copy;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
