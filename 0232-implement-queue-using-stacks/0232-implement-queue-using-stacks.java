class MyQueue {
    Stack<Integer> left;
    Stack<Integer> right;

    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }
    
    public void push(int x) {
        left.push(x);
    }
    
    public int pop() {
        moveAll(left, right);
        int pop = right.pop();
        moveAll(right, left);

        return pop;
    }
    
    public int peek() {
        moveAll(left, right);
        int peek = right.peek();
        moveAll(right, left);
        
        return peek;
    }
    
    public boolean empty() {
        return left.isEmpty();
    }

    private static void moveAll(Stack<Integer> src, Stack<Integer> dest) {
        while (!src.isEmpty()) {
            dest.push(src.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */