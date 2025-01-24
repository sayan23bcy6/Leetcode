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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)
        return head;
        ListNode current=head;
        int num=1;
        int length=1;
        while (current.next != null) {
            current = current.next;
            length++;
        }current.next=head;
        current=head;
        k=k%length;
        k=length-k;
        while(num<k)
        {
           current=current.next;
           num++;
        }head=current.next;
        current.next=null;
        return head;
    }
}