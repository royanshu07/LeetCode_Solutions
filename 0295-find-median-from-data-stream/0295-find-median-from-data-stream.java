class MedianFinder {
    PriorityQueue<Integer> leftheap;
    PriorityQueue<Integer> rightheap;
    public MedianFinder() {
     this.leftheap = new PriorityQueue<>(Collections.reverseOrder());
     this.rightheap = new PriorityQueue<>();
        
        
        
    }
    
    public void addNum(int num) {
        if(leftheap.isEmpty()&&rightheap.isEmpty()){
            
            leftheap.add(num);
        }
        else if(leftheap.size()>rightheap.size()){
            if(num>leftheap.peek()){
                 
                rightheap.add(num);
            }
            else{
                int num2= leftheap.poll();
                 
                leftheap.add(num);
                rightheap.add(num2);
            }
        }
         else {
            if(num<rightheap.peek()){
                 
                leftheap.add(num);
            }
            else{
                int  num2= rightheap.poll();
                 
                rightheap.add(num);
                leftheap.add(num2);
            }
        }
        }
        
    
    
   public double findMedian() {
    if (leftheap.size() == rightheap.size()) {
        return (leftheap.peek() + rightheap.peek()) / 2.0;
 }
       else   {
        return leftheap.peek();}
    // // else {
    //     return rightheap.peek();
    // }


        
    }}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */