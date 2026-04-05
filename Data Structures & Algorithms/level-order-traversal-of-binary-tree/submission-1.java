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
        Queue<TreeNode>queue = new LinkedList<>();
        List<List<Integer>>res = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>curr_lvl = new ArrayList<>();
            for(int i =0; i < size; i++){
                   TreeNode node = queue.poll();
                   if(node!=null){
                    curr_lvl.add(node.val);     
                   if(node.left!=null)queue.offer(node.left);
                   if(node.right!=null)queue.offer(node.right);
                   }

            }
            if(curr_lvl.size()>0)res.add(curr_lvl);


        }
        return res;
    }
}
