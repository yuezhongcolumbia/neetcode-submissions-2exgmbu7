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
    public boolean isBalanced(TreeNode root) {
        Set<Boolean>res = new HashSet<>();
        dfs(root, res);
        return (res.contains(false))?false:true;
    }
    private static int dfs(TreeNode root, Set<Boolean>res){
        if(root == null){
            return 0;
        }

        int left_height = dfs(root.left, res);
        int right_height = dfs(root.right, res);

        if(Math.abs(left_height-right_height)>1){
            res.add(false);
        }
        return 1+ Math.max(left_height,right_height);
    }
}
