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
//BFS
//edge case: 1,2
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList<>();
        List<Integer>res = new ArrayList<>();
        
        if(root!=null)queue.add(root);
        while(!queue.isEmpty()){
            int curr_size = queue.size();
            TreeNode right_side = null;
            for(int i = 0; i < curr_size;i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    right_side = node;
                    
                    if(node.left!=null)queue.add(node.left);
                     if(node.right!=null)queue.add(node.right);
                    
                }
            }
            res.add(right_side.val);
        }
        return res;
    }
}
