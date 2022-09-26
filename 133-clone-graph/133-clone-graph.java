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
    Map<Integer, Node> cloneMap = new HashMap();
    
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (cloneMap.containsKey(node.val)) {
            return cloneMap.get(node.val);
        }
        
        Node copy = new Node(node.val);
        cloneMap.put(copy.val, copy);
        
        for (int i = 0; i < node.neighbors.size(); i++) {   
            copy.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return copy;
    }
    
    
}

/*
무방향 그래프 복사본 만들기 
deep copy를 해야한다.

무방향인데 방문체크없이 진행이 되는 이유는? 해당 val 키를 가지고 있으면, 검색해서 반환하고 넝어간다.

지금 내가 짠 코드는 객체의 값을 매번 복사한다. 즉, 노드의 값이 같은 노드는 주소도 같아야하는데, 모두 다른주소로 다른 객체가 만들어지는 것이다.
사람들이 map에 복사한 객체를 넣는 이유는, 각 객체 값에 유일한 노드를 만들기 위해서이다.
*/