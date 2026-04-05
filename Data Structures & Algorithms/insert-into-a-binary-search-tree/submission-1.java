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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        dfs(root,val);
        return root;
    }
    private void dfs(TreeNode root, int val){
        if(root==null){
            return;
        }
        if(root.val<val ){
            if(root.right == null){
                TreeNode temp = new TreeNode(val);
                root.right = temp;
                return;
            }else{
                dfs(root.right,val);
            }
            
        }
        if(root.val>val){
            if(root.left==null){
                TreeNode temp2 = new TreeNode(val);
                root.left = temp2;
                return;
            }else{
                dfs(root.left,val);
            }
        }
        return;
    }
}