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
    public int maxPathSum(TreeNode root) {
        int[]curr_max = new int[1];
        curr_max[0] = Integer.MIN_VALUE;
        dfs(root,curr_max);
        return curr_max[0];

    }
    private int dfs(TreeNode root,int[]curr_max){
        if(root==null){
            return 0;
        }
        int left_branch = dfs(root.left,curr_max);
        int right_branch = dfs(root.right,curr_max);
        int res = Math.max(root.val,root.val+Math.max(left_branch,right_branch));
        curr_max[0] = Math.max(curr_max[0],Math.max(res, left_branch+right_branch+ root.val));
        return res;
    }
}
