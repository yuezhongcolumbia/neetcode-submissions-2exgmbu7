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
//There is only two situations:
//
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    private  int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int left_max = Math.max(0,dfs(root.left));
        int right_max = Math.max(0,dfs(root.right));
        
        res = Math.max(res, root.val+left_max+right_max);
        return root.val+Math.max(left_max,right_max);
    }
}
