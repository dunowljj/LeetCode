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
        if (root == null) return true;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        if (Math.abs(lh - rh) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return false;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return getHeight(root.right) + 1;
        }
        else if (root.right == null) {
            return getHeight(root.left) + 1;
        }
        else {
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }
}
/**
맨 마지막 depth는 모자라도 null로 채워주지 않음
[1 / 2, 2 / 3, 3, n, n / 4, 4] n, n, n, n, n, n]


 */