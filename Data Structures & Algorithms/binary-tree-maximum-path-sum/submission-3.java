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
    int[] res;
    public int maxPathSum(TreeNode root) {
        res = new int[]{root.val};
        dfs(root);
        return res[0];
    }
    private int dfs(TreeNode root){
        //base
        if (root == null){
            return 0;
        }
        //choices left and right
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        //before return we want to update ans
        res[0] = Math.max(res[0], root.val + leftMax + rightMax);
        //but we only return root.val + max(left, right), and this has to be greater than 0
        return Math.max(0, root.val + Math.max(leftMax, rightMax));
    }
}
