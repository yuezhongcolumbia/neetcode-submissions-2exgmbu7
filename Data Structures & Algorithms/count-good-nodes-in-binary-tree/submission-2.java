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
    // obj:
    //     how many nodes are greater or equal to curMax
    // impl:
    //     1. dfs or bfs?
    //     2. 先考虑dfs:
    //         1. curMax, have to consider pathing, parameter in dfs to pass down
    //         2. 
    private int res;
    public int goodNodes(TreeNode root) {
        res = 0;
        int curMax = root.val;
        dfs(root, curMax);
        return res;
    }
    public void dfs(TreeNode root, int curMax){
        if (root == null) return;
        // update curMax
        curMax = Math.max(curMax, root.val);
        if (root.val >= curMax) res++;
        
        dfs(root.left, curMax);
        dfs(root.right, curMax);
    }
}
