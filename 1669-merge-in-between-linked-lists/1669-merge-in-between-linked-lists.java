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
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {       
                                                                                         
                                                                                        ListNode orghead= list1;
       if(a==0){
        orghead= list2;}                                                                               
    
                                                                                  
        ListNode athnode=list1;
        ListNode bthnode=list1;
        for(int i =0;i<=b+1;i++){
            if(i==a-1){
                athnode=list1;
            }
            if(i==b+1){
                bthnode=list1;
            }
            list1=list1.next;
        }
        
        athnode.next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=bthnode;
        
        
       return orghead; 
    }
}