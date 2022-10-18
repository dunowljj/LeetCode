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
    List<Integer> view = new ArrayList();
    
    public List<Integer> rightSideView(TreeNode root) {
        
        findRight(root, 0);
        return view;
    }
    
    private void findRight(TreeNode node, int depth) {
        if (node == null) return;
        
        if (view.size() == depth) {
            view.add(node.val);
        }
        
        findRight(node.right, depth + 1);
        findRight(node.left, depth + 1);
    }
}


/*
오른쪽에서 서있는 자신을 상상해라. (트리가 오른쪽으로 서있는게 아니다.)
그 방향에서 볼 수 있는 위에서부터 수를 return하기.
level 별로 가장 오른쪽에 있는 노드를 반환하자.
*/


/*
첫 잘못된 풀이. 오른쪽에 있는 노드만 탐색했다.
List<Integer> view = new ArrayList();
    
    public List<Integer> rightSideView(TreeNode root) {
        if (findRight(root)) return view;
        return view;
    }
    
    private boolean findRight(TreeNode node) {
        if (node == null) return false;
        view.add(node.val);
        
        if (!findRight(node.right)) findRight(node.left);
        
        return true;
    }
*/

/*
bfs로 풀면 간단하겠다.
*/

