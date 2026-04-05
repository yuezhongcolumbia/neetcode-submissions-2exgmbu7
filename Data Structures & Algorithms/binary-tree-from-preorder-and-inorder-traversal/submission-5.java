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
        // 1. return: tree
        // 2. passing down: preorder, inorder
        // 3. current node processing:
        //     build new tree
        //     attach left and right tree
        return dfs(preorder, inorder);
        
    }
    public TreeNode dfs(int[] preorder, int[] inorder){
        if (preorder.length == 0) return null;
        int val = preorder[0];
        TreeNode node = new TreeNode(val);
        int valIdxInorder = 0;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == val){
                valIdxInorder = i;
                break;
            }
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, valIdxInorder);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, 1 + inorderLeft.length);
        int[] inorderRight = Arrays.copyOfRange(inorder, valIdxInorder + 1, inorder.length);
        int[] preorderRight = Arrays.copyOfRange(preorder, 1 + inorderLeft.length, preorder.length);
        node.left = dfs(preorderLeft, inorderLeft);
        node.right = dfs(preorderRight, inorderRight);
        return node;

    }
}
