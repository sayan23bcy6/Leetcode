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
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ahead = dummy;
        ListNode current = dummy;
        while(n>=0)
        {
            ahead=ahead.next;
            n--;
        }
        while(ahead!=null)
        {
            current=current.next;
            ahead=ahead.next;
        }
        current.next=current.next.next;
        return dummy.next;
    }
}