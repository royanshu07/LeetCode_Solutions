class MinStack {
    ArrayList<ArrayList<Integer>> helper;
    int start;
    public MinStack() {
      helper = new ArrayList<>();
      start= 0;
    }
    
    public void push(int val) {
        ArrayList<Integer> temp = new ArrayList<>();
        if(start==0){
           temp.add(val);
           temp.add(val);
        }
        else{
            temp.add(val);
            int min  = Math.min(val,helper.get(start-1).get(1));
            temp.add(min);
        }
        helper.add(temp);
        start++;
    }
    
    public void pop() {
        helper.remove(start-1);
        start--;
        
    }
    
    public int top() {
        if(start==0){
            return -1;
        }
        return helper.get(start-1).get(0);
        
    }
    
    public int getMin() {
         return helper.get(start-1).get(1);
        
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