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
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {            
            return -1;
        } else {
            return Math.max(lh, rh) + 1;
        }
    }
}
/**
맨 마지막 depth는 모자라도 null로 채워주지 않음
[1 / 2, 2 / 3, 3, n, n / 4, 4] n, n, n, n, n, n]


 */