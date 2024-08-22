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
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode mergedList = new ListNode();
        mergeTwoLists(mergedList, list1, list2);
        return mergedList;
    }

    public void mergeTwoLists(ListNode mergedList, ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return;
        } else if (list1 == null) {
            mergedList.val = list2.val;
            mergedList.next = list2.next;
            return;
        } else if (list2 == null) {
            mergedList.val = list1.val;
            mergedList.next = list1.next;
            return;
        }
        
        if (list1.val <= list2.val) {    
            mergedList.val = list1.val;
            mergedList.next = new ListNode();
            mergeTwoLists(mergedList.next, list1.next, list2);
            return;
        } else {
            mergedList.val = list2.val;
            mergedList.next = new ListNode();
            mergeTwoLists(mergedList.next, list1, list2.next);
            return;
        }
    }
}