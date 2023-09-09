class MyStack {
    Queue<Integer> helper;
    
    public MyStack() {
        helper = new LinkedList<>();
        
    }
    
    public void push(int x) {
        helper.add(x);
        int b = helper.size();
        for(int i = 0;i<b-1;i++){
            helper.add(helper.poll());
        }
       
        
    }
    
    public int pop() {
        return helper.poll();
        
    }
    
    public int top() {
        return helper.peek();
        
    }
    
    public boolean empty() {
        if(helper.size()==0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */