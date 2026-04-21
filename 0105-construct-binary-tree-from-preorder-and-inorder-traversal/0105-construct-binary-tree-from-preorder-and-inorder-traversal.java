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
    int[] inorderIdx;
    final int OFFSET = 3000;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        inorderIdx = new int[3001 + OFFSET];
        for (int i = 0; i < n; i++) {
            inorderIdx[inorder[i] + OFFSET] = i;
        }

        return buildTree(0, n-1, 0, n-1, preorder, inorder);
    }

    public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preEnd) {
            return null;
        }

        // Start of preorder is parent
        int parent = preorder[preStart];
        TreeNode node = new TreeNode(parent);

        // By using parent val, find inorder's parent and size of left subtree.
        int inMid = inorderIdx[parent + OFFSET];
        int leftSize = inMid - inStart;

        int preMid = preStart + leftSize;

        node.left = buildTree(preStart + 1,  preMid, inStart,    inMid - 1, preorder, inorder);
        node.right = buildTree(preMid + 1,   preEnd, inMid + 1,  inEnd    , preorder, inorder);

        return node;
    }
}