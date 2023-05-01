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
class ans{
    ListNode head;
    ListNode prev;
}

class Solution {
    
    public ListNode reverseList(ListNode head) {
        ans re = rev2(head);
        return re.head;
        
    }
    
    public ans rev2(ListNode head){
        ans re = new ans();
        if(head==null){
            re.head= head;
            re.prev = head;
            return re;
        }
        if(head.next==null){
            re.head=head;
            re.prev = head;
            return re;
        }
         re = rev2(head.next);
         head.next = null;
         re.prev.next = head;
         re.prev = head;
         return re;
    }
}