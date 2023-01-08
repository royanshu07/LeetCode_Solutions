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
    public int getDecimalValue(ListNode head) {
       
        int num=0;
        while(head!=null){
           // System.out.print(num);
            //System.out.println(head.val);
            num+=num+head.val;
            
            head = head.next;
            
        }
        return num;
    }
}