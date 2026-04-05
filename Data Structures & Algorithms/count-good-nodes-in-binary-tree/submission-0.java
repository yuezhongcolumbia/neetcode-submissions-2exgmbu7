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
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int[]res = new int[1];
        dfs(root,max,res);
        return res[0];
    }
    private void dfs(TreeNode root, int max, int[] res){
        if(root == null){
            return;
        }
        max = Math.max(root.val,max);
        if(root.val>=max){
            res[0]++;
        }
        dfs(root.left,max,res);
        dfs(root.right,max,res);



    }
}
