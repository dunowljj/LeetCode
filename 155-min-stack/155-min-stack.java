class MinStack {
    Node node;
    
    
    public MinStack() {
        node = new Node();
    }
    
    public void push(int val) {
        node.child = new Node(val);
        node.child.parent = node;
        
        node.child.min = Math.min(node.min, val);
        node = node.child;
    }

    public void pop() {
        node = node.parent;
    }
    
    public int top() {
        return node.val;
    }
    
    public int getMin() {
        return node.min;
    }
}

class Node {
    Node child;
    Node parent;
    int min;
    int val;
    
    public Node() {
        min = Integer.MAX_VALUE;
    }
    
    public Node(int val) {
        this.val = val;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/*
30_000
1 + 2^2 + 3^3...

스택 없이 구현해보자.

- 최솟값을 언제나 찾을 수 있어야 한다.
- stack의 기능 : 마지막에 추가한 값을 확인하고 뺄 수 있어야 한다.

Node에 다음 Node를 연결시키고, 포인터를 이동시키는 방식.
- Node를 연결시킬때마다 작은 값을 갱신한다.
- pop되면 포인터를 이전으로 돌린다. 그러면 최솟값도 자동으로 해당 지점까지의 최솟값으로 갱신된다.
*/