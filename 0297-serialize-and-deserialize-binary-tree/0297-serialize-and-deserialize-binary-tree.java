import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private final String NULL = "#";
    private final String SEPERATOR = ",";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serialize(root, result);
        System.out.println(result);
        return result.toString();
    }

    private void serialize(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append(NULL).append(SEPERATOR);
            return;
        }
        
        result.append(node.val).append(SEPERATOR);

        serialize(node.left, result);
        serialize(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(SEPERATOR)));
        return buildTree(tokens);
    }

    private TreeNode buildTree(Queue<String> tokens) {
        String token = tokens.poll();
        if (token.equals(NULL)) return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = buildTree(tokens);
        node.right = buildTree(tokens);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));