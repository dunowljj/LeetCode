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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
}

// public ListNode middleNode(ListNode head) {
//         return find(head);
//     }
    
//     private ListNode find(ListNode head) {
//         int count = count(head);
//         count = count / 2; // count / 2 + 1 까지 도달해야함
        
//         while (count-- > 0) {
//             head = head.next;
//         }
//         return head;
//     }
    
//     private int count(ListNode head) {
//         if (head == null) {
//             return 0;
//         }
        
//         return count(head.next) + 1;
//     }
    