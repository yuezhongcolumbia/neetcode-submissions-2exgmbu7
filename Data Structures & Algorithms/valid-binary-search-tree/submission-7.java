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
        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public boolean dfs(TreeNode root, int upper, int lower){
        if (root == null) return true;
        if (root.val >= upper || root.val <= lower) return false;
        return dfs(root.left, root.val, lower) && dfs(root.right, upper, root.val);
    }
}
