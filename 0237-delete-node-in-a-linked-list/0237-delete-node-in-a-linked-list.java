/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode next1 = node.next;
        
        while(next1.next!=null){
            curr.val=next1.val;
            curr= curr.next;
            next1=next1.next;
            
            
        } curr.val=next1.val;
        curr.next=null;
    }
}