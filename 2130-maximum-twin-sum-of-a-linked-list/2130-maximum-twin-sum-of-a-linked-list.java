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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int max = Integer.MIN_VALUE;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = slow.next;
        ListNode curr = slow.next.next;
        ListNode temp;
        slow.next=null;
        prev.next=null;
        while(curr!=null){
            temp = curr.next;
            curr.next= prev;
            prev = curr;
            curr= temp;
        }
        while(head!=null){
            if(head.val+prev.val>=max){
                max= head.val+prev.val;
            }
            head=head.next;
            prev = prev.next;
        }
        return max;
    }
}