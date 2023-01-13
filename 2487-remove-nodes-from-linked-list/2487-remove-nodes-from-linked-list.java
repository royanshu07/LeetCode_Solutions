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
    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while(curr!=null){
           temp= curr.next;
           curr.next=prev;
           prev = curr; 
           curr = temp;
        }
        ListNode tail = prev;
        curr=prev;
        prev = null;
        int max = curr.val;
        while(curr!=null){
        if(curr.val<max){
            prev.next=curr.next;
            curr=prev.next;
        }
        else{
            max= curr.val;
            temp=curr;
            curr = curr.next;
            prev=temp;
           
        }}
        prev = null;
        curr = tail;
        temp=null;
        while(tail!=null){
           temp= tail.next;
           tail.next=prev;
           prev = tail; 
              tail= temp;
         }
        
        return prev;
        
    }
}