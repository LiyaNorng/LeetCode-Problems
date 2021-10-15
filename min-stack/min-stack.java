class MinStack {

    Stack<Integer> stack;
    Stack<Integer> recordStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.recordStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (recordStack.isEmpty()){
            recordStack.push(x);  
        }
        else if(recordStack.peek() >= x){
            recordStack.push(x);
        }
    }
    
    public void pop() {
        int i = stack.pop();
        if (i == recordStack.peek()){
            recordStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return recordStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */