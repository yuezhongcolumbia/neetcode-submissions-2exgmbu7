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
        if (preorder.length == 0 || inorder.length == 0) return null;
        //find mid
        int rootVal = preorder[0];
        int mid = 0;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == rootVal){
                mid = i;
            }
        }

        //make root
        TreeNode root = new TreeNode(rootVal);
        //leftPreorder, leftInorder, build left
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + mid);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree(leftPreorder, leftInorder);
        //rightPreorder, rightInorder, build right
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + mid, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, 1 + mid, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
}
