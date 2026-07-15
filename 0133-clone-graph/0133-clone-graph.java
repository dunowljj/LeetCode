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

    Map<Integer, Node> visit = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visit.containsKey(node.val)) return visit.get(node.val);

        Node copy = new Node(node.val);
        visit.put(copy.val, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}