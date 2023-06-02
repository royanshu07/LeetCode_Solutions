class MedianFinder {
    PriorityQueue<Integer> leftheap;
    PriorityQueue<Integer> rightheap;
    Boolean check;
    PriorityQueue<Integer>temp;
    public MedianFinder() {
     this.leftheap = new PriorityQueue<>(Collections.reverseOrder());
     this.rightheap = new PriorityQueue<>();
     temp = leftheap;
     check  = true;
        
        
        
    }
    
    public void addNum(int num) {
        if(leftheap.isEmpty()&&rightheap.isEmpty()){
            
            leftheap.add(num);
            check = false;
        }
        else if(leftheap.size()>rightheap.size()){
            check = true;
            if(num>leftheap.peek()){
                
                rightheap.add(num);
            }
            else{
                int num2= leftheap.poll();
                 
                leftheap.add(num);
                rightheap.add(num2);
            }
        }
         
        else if(rightheap.size()==leftheap.size()){
                 check = false;
                 if(num>leftheap.peek()){
                     rightheap.add(num);
                     temp = rightheap;
                 }
                 else{
                     leftheap.add(num);
                     temp=leftheap;
                 }
            
            
                 
             }
         else{
            check = true;
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
    if (check) {
        return (leftheap.peek() + rightheap.peek()) / 2.0;
 }
       else   {
        return temp.peek();}
    

        
    }}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */