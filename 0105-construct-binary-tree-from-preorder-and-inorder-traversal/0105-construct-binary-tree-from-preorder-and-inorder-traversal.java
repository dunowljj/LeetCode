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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart == preorder.length || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]); //이전에 찾은 루트의 인덱스로 루트 생성
        int findIdx = 0;
        for (int i = inStart; i <= inEnd; i++) { //부등호 차이로 오버플로가 나는 이유?
            if (inorder[i] == root.val) {
                findIdx = i; //inorder에서 root의 index
                break;
            }
        }
        
        root.left = buildTree(preorder, inorder, preStart + 1, inStart, findIdx - 1);
        root.right = buildTree(preorder, inorder, preStart + (findIdx - inStart) + 1 , findIdx + 1, inEnd);
            
        return root;
    }
}
/*
전위 순회의 첫 요소는 root를 나타낸다.
중위 순회의 첫 요소는 왼쪽 맨 아래 node를 나타낸다.
중위 순회 배열에서 root노드를 기준으로 양쪽을 나누면, left의 node들, right의 node들로 나뉘어진다.


preStart -> preOrder에서 루트노드의 위치
findIdx -> inOrder에서 루트노드의 위치
inStart -> inOrder에서 탐색 시작범위
inEnd -> inOrder에서 탐색 끝 범위

*/