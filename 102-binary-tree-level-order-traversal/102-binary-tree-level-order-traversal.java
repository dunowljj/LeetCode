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
    List<List<Integer>> answer = new ArrayList();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return answer;
    }
    
    public void levelOrder(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        
        if (answer.size() == index) {
            answer.add(new ArrayList());
        }
        
        answer.get(index).add(root.val);
        
        levelOrder(root.left, index + 1);
        levelOrder(root.right, index + 1);
    }
}