class MinStack {
    Node node;
    
    public void push(int val) {
        if (node == null) {
            node = new Node(val, val, null);
        } else {
            node = new Node(val, Math.min(node.min, val), node);
        }
    }

    public void pop() {
        node = node.next;
    }
    
    public int top() {
        return node.val;
    }
    
    public int getMin() {
        return node.min;
    }
}

class Node {
    int val;
    int min;    
    Node next;
    
    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
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
- 현재 노드를 새로 생성되는 노드의 next로 설정하면, 다음 노드만 계속해서 저장해서 해결할 수 있다.
*/