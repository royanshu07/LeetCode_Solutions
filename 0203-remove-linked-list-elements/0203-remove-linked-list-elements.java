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
    public ListNode removeElements(ListNode head, int val) {
      ListNode prev = head;
      ListNode orghead = head;
      
      while(head!=null&&head.val==val){
       head= head.next;
       prev=head;
       orghead = head;}
    
       if(prev==null||prev.next==null){
        return prev;}
       ListNode curr = prev.next;
        
        while(curr!=null){
        if(curr.val==val){
        prev.next=prev.next.next;
        curr= prev.next;}
        else{
            curr= curr.next;
            prev = prev.next;
        }}
        return orghead;
    }
}