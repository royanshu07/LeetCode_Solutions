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
    
   
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        if(head.next.next==null){
            if(head.val==head.next.val){
                return true;
            }return false;
        }
        if(head.next.next.next==null){
            if(head.val==head.next.next.val){
                return true;
            }return false;
        }
       
       ListNode slow = head;
       ListNode fast = head;
       while(fast.next!=null&&fast.next.next!=null){
        
           slow = slow.next;
           fast=fast.next.next;
       }
        
      // ListNode orghead2 = slow.next.next;
       ListNode curr = slow.next.next;
       ListNode prev = slow.next;
       ListNode temp ;
        prev.next=null;
       while(curr!=null){
           temp = curr.next;
           curr.next=prev;
           // prev.next=null;
           prev=curr;
           curr= temp;
           
       }
        
       ListNode orghead2=prev;
       while(orghead2!=slow&&orghead2!=null){
           // System.out.print(orghead2.val);
           // System.out.println(head.val);
           if(head.val!=orghead2.val){
               return false;
               
           }head= head.next;
           orghead2=orghead2.next;
       }
       
        return true;
        
    }
}