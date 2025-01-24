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
    public ListNode reverseBetween(ListNode head, int left, int right) {
         if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev1 = dummy;

        for (int i = 1; i < left; i++) {
            prev1 = prev1.next;
        }

        ListNode start = prev1.next;
        ListNode next = start.next;
        
        for (int i = 0; i < right - left; i++) {
            start.next = next.next;
            next.next = prev1.next;
            prev1.next = next;
            next = start.next;
        }

        return dummy.next;
    }
}