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
        dummy.next=head;
        //start the slow pointer to dummy which is prior to head
        ListNode slow=dummy, fast=head;
        //move the fast to n places first
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        //move both pointers at same pace now
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        //remove the connection with nth element and attach to next
        slow.next = slow.next.next;

        return dummy.next;
    }
}
