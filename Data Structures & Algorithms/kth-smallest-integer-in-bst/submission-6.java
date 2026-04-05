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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[2];
        this.k = k;
        dfs(root, tmp);
        return tmp[1];


    }
    public void dfs(TreeNode root, int[] tmp){
        if (root == null) return;
        dfs(root.left, tmp);
        tmp[0] ++;
        if (tmp[0] == k){
            tmp[1] = root.val;
            return;
        }
        dfs(root.right, tmp);
    }
}
