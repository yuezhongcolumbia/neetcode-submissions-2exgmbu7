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
    public TreeNode deleteNode(TreeNode root, int key) {
        //recursion, search left if smaller, right if larger
        //if found
        //look for the left most node of root.right
        //replace it with root.left
        //delete root
        //return root.right 
        if (root == null){
            return null;
        }
        if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode cur = root.right;
            while (cur.left != null){
                cur = cur.left;
            }
            cur.left = root.left;
            TreeNode res = root.right;
            root = null;
            return res;
        }
        return root;
    }
}