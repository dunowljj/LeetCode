/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
/**
p,q에 해당하는 하위 노드가 아닌 경우 상위 노드(함수)에 null을 반환하도록 한다.
- left, right에 값이 모두 있다면 현재 root가 LCA이다.
- left, right중 하나에만 값이 있다면, 둘 중 값이 있는 노드가 LCA이다.
 */