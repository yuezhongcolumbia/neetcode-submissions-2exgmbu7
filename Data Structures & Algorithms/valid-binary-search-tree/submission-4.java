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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean dfs(TreeNode root, int left_bound, int right_bound){
        if(root == null){
            return true;
        }
        if(root.val>left_bound && root.val<right_bound){
            return dfs(root.left, left_bound, Math.min(right_bound,root.val)) && dfs(root.right, Math.max(left_bound, root.val),right_bound);
        }else{
            return false;
        }

        


    }
}
