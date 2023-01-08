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
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next2 = null;
        while(curr!=null){
        next2=curr.next;
        curr.next=prev;
        prev= curr;
        curr= next2;
        }
        
        return prev;
        
        
    }
}