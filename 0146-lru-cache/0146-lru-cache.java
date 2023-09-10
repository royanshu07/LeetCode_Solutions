class LRUCache {
    class DoublyLnk{
    int val;
    int key;
    DoublyLnk prev, next;
    DoublyLnk(int val, int key, DoublyLnk p, DoublyLnk n){
        this.val=val;
        this.key=key;
        this.prev=p;
        this.next=n;
    }
    }
    
    int cty;
    HashMap<Integer, DoublyLnk> see;
    DoublyLnk head=null;
    DoublyLnk ptr=null;
    public LRUCache(int capacity) {
        this.cty=capacity;
        see=new HashMap<>();
    }
    
    public void update(DoublyLnk node){
        if(node==head&&node==ptr){
            return;
        }
        else if(node==ptr){
            return;
        }
        else if(node==head){
            head=head.next;
            head.prev=null;
            ptr.next=node;
            node.next=null;
            node.prev=ptr;
            ptr=ptr.next;
        }
        else{
            DoublyLnk p=node.prev;
            DoublyLnk n=node.next;
            p.next=n;
            n.prev=p;
            ptr.next=node;
            node.prev=ptr;
            node.next=null;
            ptr=ptr.next;
        }
    }

    public void add(int key, int value){
        if(head==null){
            DoublyLnk x=new DoublyLnk(value, key, null, null);
            head=x;
            ptr=x;
            see.put(key, x);
        }
        else{
        DoublyLnk x=new DoublyLnk(value, key, ptr, null);
        ptr.next=x;
        ptr=x;
        see.put(key, x);
        }
    }

    public int get(int key) {
        if(this.see.containsKey(key)){
            update(see.get(key));
            return this.see.get(key).val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(see.containsKey(key)){
            DoublyLnk temp=see.get(key);
            update(temp);
            temp.val=value;
        }
        else if(see.size()+1>cty){
        see.remove(head.key);
        if(head.next==null){
            head=null;
            ptr=null;
        }
        else{
        head=head.next;
        head.prev=null;
        }
        add(key, value);
        }
        else{
            add(key, value);
        }
    }
}

// class LinkedList1{
//     int key;
//     int val;
//     LinkedList1 left;
//     LinkedList1 right;
    
    
// } 
// class LRUCache {
//       HashMap<Integer,LinkedList1> map = new HashMap<>();
//       int size;
//       int currsize;
//       LinkedList1 head;
//       LinkedList1 tail;
    
//     public LRUCache(int capacity) {
//         size = capacity;
//         currsize = 0;
//         head = new LinkedList1();
//         tail = new LinkedList1();
//         head.right = tail;
//         tail.left = head;
//         head.key = -1; // Add this line
//        tail.key = -1;
        
        
        
//     }
    
//     public int get(int key) {
//         if(!map.containsKey(key)){
//             return -1;
//         }
//         LinkedList1 temp = map.get(key);
//         int val = temp.val;
        
//         temp.left.right = temp.right;
//         temp.right.left = temp.left;
        
//         LinkedList1 headleft = head.right;
//         head.right = temp;
//         headleft.left =temp;
//         temp.left = head;
//         temp.right= headleft;
//         return val;
        
        
//     }
    
//     public void put(int key, int value) {
//        if(map.containsKey(key)){
//            LinkedList1 temp = map.get(key);
//            temp.val = value;
//         temp.left.right = temp.right;
//         temp.right.left = temp.left;
        
//         LinkedList1 headleft = head.right;
//         head.left = temp;
//         headleft.right =temp;
//         temp.left = head;
//         temp.right= headleft;
//         return;
//        } 
//         if(currsize>=size){
//             currsize--;
//             LinkedList1 last = tail.left;
//             tail.left = last.left;
//             last.left.right = tail;
//             map.remove(last.key);
//         }
//         currsize++;
//         LinkedList1 temp = new LinkedList1();
//         temp.val = value;
//         temp.key = key;
//         map.put(key,temp);
//          LinkedList1 headleft = head.right;
//         head.right = temp;
//         headleft.left =temp;
//         temp.left = head;
//         temp.right= headleft;
//         return;
        
        
//     }
// }

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */