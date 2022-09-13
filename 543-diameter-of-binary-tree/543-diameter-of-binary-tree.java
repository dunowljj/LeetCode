/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDiameter(root);
        
        return max;
    }
    
    // 각 노드에서 하위노드 방향으로 가장 긴 값을 구한다.
    private int getDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int count1 = getDiameter(node.right);
        int count2 = getDiameter(node.left);
        
        max = Math.max(max, count1 + count2);        
        
        return Math.max(count1, count2) + 1;
    }
}

/*
1) 각 노드에 대해서 해당 노드부터 하위노드까지의 길이 중 최장 길이를 구한다.
2) 각 노드의 (왼쪽 노드의 최장길이 + 오른쪽 노드의 최장길이)는 해당 노드의 지름이 된다.
3) 지름끼리 비교한다.
*/