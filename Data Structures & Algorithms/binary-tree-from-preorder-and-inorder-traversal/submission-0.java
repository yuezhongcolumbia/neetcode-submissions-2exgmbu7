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
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        int mid = Integer.MIN_VALUE;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                mid = i;
            }
        }

        int[]left_preorder = Arrays.copyOfRange(preorder,1,1+mid);
        int[]left_inorder = Arrays.copyOfRange(inorder,0,mid);
        int[]right_preorder= Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int[]right_inorder = Arrays.copyOfRange(inorder,1+mid,inorder.length);

        root.left = buildTree(left_preorder,left_inorder);
        root.right = buildTree(right_preorder,right_inorder);
        return root;
    }
}
