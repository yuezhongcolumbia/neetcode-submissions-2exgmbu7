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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    public int[] dfs(TreeNode root){
        if (root == null){
            return new int[]{0, 0};
        }
        int[] res = new int[2];
        int[] leftPair = dfs(root.left);
        int[] rightPair = dfs(root.right);
        res[0] = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);
        res[1] = root.val + leftPair[0] + rightPair[0];
        return res;
    }
}