class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        pushAllToStack2();
        int x = stack2.pop();
        pushAllToStack1();
        
        return x;
    }
    
    public int peek() {
        pushAllToStack2();
        int x = stack2.peek();
        pushAllToStack1();
        
        return x;
    }
    
    public boolean empty() {
        return stack1.empty();
    }
    
    private void pushAllToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());        
        }
    }
    
     private void pushAllToStack2() {
         while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
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