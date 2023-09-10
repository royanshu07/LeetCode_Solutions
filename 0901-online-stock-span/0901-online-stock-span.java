class StockSpanner {
    Stack<int[]> sk;
    public StockSpanner() {
        sk= new Stack<>();
    }
    
    public int next(int price) {
        int c = 1;
        while(!sk.isEmpty()&&sk.peek()[0]<=price){
            c+=sk.peek()[1];
            sk.pop();
        }
        int[]arr = new int[2];
        arr[0]=price;
        arr[1]=c;
        
        sk.push(arr);
        return c;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */