class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
        if(!min.empty() && min.peek() > x)
            min.push(x);
        else{
            if(!min.empty()) min.push(min.peek());
            else min.push(x);
        }
    }
    
    public void pop() {
        if(!st.empty()){
            st.pop();
            min.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
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