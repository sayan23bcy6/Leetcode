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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

 
        ListNode start1 = list1;
        ListNode start2 = list2;

        
        while (start1 != null && start2 != null) {
            if (start1.val <= start2.val) {
                current.next = start1;
                start1 = start1.next;
            } else {
                current.next = start2;
                start2 = start2.next;
            }
            current = current.next;
        }
        if (start1 != null) {
            current.next = start1;
        } else {
            current.next = start2;
        }

        return dummy.next;
    }
}