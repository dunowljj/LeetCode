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
    ListNode tail; // remember lastNode
    ListNode target; // location which needs to change link
    
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        reverse(head);
        head.next = null;
        
        return tail;
    }
    
    private void reverse(ListNode head) {
        
        // find last node
        if (head.next == null) {
            tail = head; 
            target = head;
            return;
        }
        
        reverse(head.next);
        
        // 타겟의 다음을 자신을 가리키던 노드로 변경
        target.next = head;
        
        // 타겟을 타겟의 다음 노드(= 이전에 자신을 가리키던 노드)로 변경
        target = target.next;
        
        return;
    }
}