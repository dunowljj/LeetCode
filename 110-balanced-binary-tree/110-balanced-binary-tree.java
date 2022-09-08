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
        if (root == null) {
            return true;
        }
        
        setHeightInVal(root);
        
        int leftHeight = root.left == null ? 0 : root.left.val;
        int rightHeight = root.right == null ? 0 : root.right.val;
          
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);

    }
    
    private int setHeightInVal(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            node.val =  Math.max(setHeightInVal(node.left), setHeightInVal(node.right)) + 1;
        }
        
        return node.val;
    }
}