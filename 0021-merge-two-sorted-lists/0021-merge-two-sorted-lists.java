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
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
            
            list1.next = mergeTwoLists(list1.next, list2.next);
        }

        return list1;
    }
}
/**
함수 최초의 return은 결국에는 맨앞 요소중에 작은 요소를 가진 연결리스트의 헤드를 리턴한다.

그 후에는 list1와 list2을 비교해서 list1에 더 작은 노드를 위치시키고,
해당 더 작은 노드의 다음 노드에 연결될 값을 다음 재귀에서 찾는다.
마찬가지로 다음 재귀에서 

 */