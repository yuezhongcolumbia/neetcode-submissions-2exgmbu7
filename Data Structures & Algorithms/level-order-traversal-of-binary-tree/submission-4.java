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
    public List<List<Integer>> levelOrder(TreeNode root) {
         if (root == null) return new ArrayList<>();
         List<List<Integer>> res = new ArrayList<>();
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         while (!q.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                layer.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            res.add(layer);
         }   
         return res;
    }
}
