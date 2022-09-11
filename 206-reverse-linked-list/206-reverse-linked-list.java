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
    ListNode tail;
    
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        reverse(head, head.next);
        head.next = null;
        
        return tail;
    }
    
    private void reverse(ListNode head, ListNode nextHead) {
        if (head.next == null) {
            tail = head;
            return;
        }
        
        reverse(head.next, nextHead.next);
        nextHead.next = head;
        
        return;
    }
}