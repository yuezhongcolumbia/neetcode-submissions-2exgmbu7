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
    //     lvl nodes saved in a list
    // impl:
    //     1. algos to traverse the tree
    //     2. we have to pass down the last level, how?
    //         1. what ds?
    private List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode root, int depth){
        if (root == null) return;
        if (depth == res.size()){
            res.add(new ArrayList<>());
        }
        //save node val
        res.get(depth).add(root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
