import java.util.*;

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode node : lists) {
            if (node == null) continue;
            pq.offer(node);
        }

        if (pq.isEmpty()) return null;

        ListNode root = new ListNode();
        ListNode now = root;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            if (minNode.next != null) pq.offer(minNode.next);
            
            now.next = minNode;
            now = now.next;
        }

        return root.next;
    }
}