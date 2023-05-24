/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//intializing and 
// O(klogk)+n*O(logk)+n*O(logk) = O(nlogk)
class Solution {
    class helper implements Comparator<ListNode>{
       
        @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
}

    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {return null;}
        helper he = new helper();
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,he);
        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null){
            pq.add(lists[i]);}
        }
        ListNode orghead = pq.poll();
        if(orghead==null){
            return orghead;
        }
        if(orghead.next!=null){
            pq.add(orghead.next);
        }
        ListNode head = orghead;
        ListNode tail;
        while(!pq.isEmpty()){
            tail = pq.poll();
            head.next = tail;
            head = head.next;
            if(tail.next!=null){
                pq.add(tail.next);
            }
            
        }
        
        return orghead;
        
        
    }
}