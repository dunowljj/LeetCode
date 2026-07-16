import java.util.*;

/*
// Definition for a Node.
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
*/

class Solution {

    Node[] nodes = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (nodes[node.val] != null) return nodes[node.val];

        Node copy = new Node(node.val);
        nodes[copy.val] = copy;

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}