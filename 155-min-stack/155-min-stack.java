class MinStack {
    PriorityQueue<Integer> queue;
    Stack<Integer> stack;
    
    public MinStack() {
        queue = new PriorityQueue();
        stack = new Stack();
    }
    
    public void push(int val) {
        queue.offer(val);
        stack.push(val);
    }
    
    public void pop() {
        queue.remove(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return queue.peek();
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

우선순위 큐에 값 넣으면서 스택 사용
스택에서 값 제거하면 해당 값으로 큐에 값 제거?
*/