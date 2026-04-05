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
// impl:
//     1.both left and right has to be true;
//     2. left.val< root and right.val > root; But how to handle one branch is null elegantly?
// mistake:
//     1. has to passdown two limiting values, lowerBound and upperBound;

//     2. stuck on dont know what bound is passed to next level
//     3. dfs逻辑判定是this node + left node + right node

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean dfs(TreeNode root, int lower, int upper){
        if (root == null){
            return true;
        }
        if (!(root.val > lower && root.val < upper)) return false;

        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }
}
