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
//     1.dfs
//     2.bst最小的在最左，we need a counter
//     3.how to traverse, left -> node ->right?
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] counter = new int[2];
        counter[0] = k;
        dfs(root, counter);
        return counter[1];
    }
    public void dfs(TreeNode root, int[] tmp ){
        if (root == null) return;
        dfs(root.left, tmp);
        // counter update
        tmp[0] --;
        if (tmp[0] == 0){
            tmp[1] = root.val;
            return;
        }
        dfs(root.right, tmp);
    }
}
