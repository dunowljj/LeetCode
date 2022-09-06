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
        ListNode head = new ListNode(0);
        
        merge(head, list1, list2);
        
        return head.next;
    }
    
    private void merge(ListNode head, ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return;
        }
        
        if (list1 == null) {
            head.next = list2;   
            return;
        }
        
        if (list2 == null) {
            head.next = list1;
            return;
        }
        
        if (list1.val < list2.val) {
            head.next = list1;
            merge(head.next, list1.next, list2);
            
        } else {
            head.next = list2;
            merge(head.next, list1, list2.next);
        }
        
        
    }
}
/*
1) Compare two Node
2) Attatch smaller one at head.next
3) Recursion with next ListNode
*/