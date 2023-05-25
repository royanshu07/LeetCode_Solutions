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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }
        ListNode head = lists[0];
        
        ListNode pointer1;
        ListNode pointer2;
        
        for(int i = 1;i<lists.length;i++){
           if(lists[i]==null){
               continue;
           }
           else if(lists[0]==null){
               lists[0]=lists[i];
               head = lists[0];
               
               continue;
           }
           
            else{
                pointer1 = lists[0];
                pointer2 = lists[i];
                lists[0] = merge(pointer1,pointer2);
                head = lists[0];
            } 
               
           }
        
        return head;
    }
    
    
    public static ListNode merge(ListNode pointer1 , ListNode pointer2){
        
               ListNode head;
               ListNode tail;
               if(pointer2.val<pointer1.val){
                   head=pointer2;
                   tail = pointer2;
                   pointer2=pointer2.next;
               }
               else{
                   head = pointer1;
                   tail = pointer1;
                   pointer1=pointer1.next;
               }
               while(pointer1!=null&&pointer2!=null){
                   if(pointer1.val<=pointer2.val){
                       tail.next = pointer1;
                       tail = tail.next;
                       pointer1= pointer1.next;
                   }
                    else if(pointer2.val<pointer1.val){
                       tail.next = pointer2;
                       tail = tail.next;
                       pointer2=pointer2.next;
                   }
                   
               }
               if(pointer1!=null){
                   tail.next = pointer1;
                   tail = tail.next;
               }
               if(pointer2!=null){
                   tail.next=pointer2;
                   tail = tail.next;
               }
           return head;
        
    }
}