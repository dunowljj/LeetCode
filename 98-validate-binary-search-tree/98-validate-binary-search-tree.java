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
    Set<Integer> set = new HashSet();
    
    public boolean isValidBST(TreeNode root) {
        set.add(root.val);
        return isValidBST(root.left, root.val, Integer.MIN_VALUE) && isValidBST(root.right, Integer.MAX_VALUE, root.val);
    }
    
    private boolean isValidBST(TreeNode root, int max, int min) {
        if (root == null) {
            return true;    
        }
        
        if (set.contains(root.val)) {
            return false;
        }
        
        set.add(root.val);
        
        if (root.val > max || root.val < min) return false;
        
        boolean left =  isValidBST(root.left, root.val, min);
        boolean right = isValidBST(root.right, max, root.val);
        
        
        return left && right;
    }
}


/*
The number of nodes in the tree is in the range [1, 10^4].
3이 왼쪽에 들어갔어야 한다. 이전 값보다 커야한다. 이진트리에 넣어버리면 되긴 하는데..
전위 순회하면서 값 비교

같은 값을 처리하려고 부등호를 포함관계로 설정하면, Integer 최솟값이나 최댓값이 주어지면 부등호에 걸린다.
첫 값만 처리하면 코드가 이상해져서 그냥 Set으로 중복체크를 한다.
*/