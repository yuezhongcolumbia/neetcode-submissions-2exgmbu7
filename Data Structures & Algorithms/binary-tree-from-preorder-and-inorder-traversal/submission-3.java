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
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
       int rootVal = preorder[0];
       int rootIdx = 0;
       for (int i = 0; i < inorder.length; i++){
        if (inorder[i] == rootVal){
            rootIdx = i;
            break;
        }
       }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] leftpreorder = Arrays.copyOfRange(preorder, 1, 1+leftInorder.length);
        int[] rightpreorder = Arrays.copyOfRange(preorder, 1 + leftInorder.length, preorder.length);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(leftpreorder, leftInorder);
        root.right = buildTree(rightpreorder, rightInorder);
        return root;
       }
    }
    

