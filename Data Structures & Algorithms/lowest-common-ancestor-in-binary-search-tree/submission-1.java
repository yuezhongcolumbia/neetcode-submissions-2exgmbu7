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
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = root;
        dfs(root, p, q);
        return res;
    }
    public void dfs(TreeNode root, TreeNode p, TreeNode q){
        //terminal condition
        if (root == null) {
            return;
        }
        if (p.val < root.val && q.val < root.val) {
            dfs(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val){
            dfs(root.right, p, q);
        } else {
            //update result
            res = root;
            return;
        }
        return;
    }
}
