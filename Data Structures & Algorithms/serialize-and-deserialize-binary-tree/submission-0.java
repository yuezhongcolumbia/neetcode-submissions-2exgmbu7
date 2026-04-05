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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String>res = new ArrayList<>();
        dfsSerialize(root,res);
        return String.join(",",res);
    }
    private void dfsSerialize(TreeNode root, List<String>res){
        if(root == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsSerialize(root.left,res);
        dfsSerialize(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]ar = data.split(",");
        int[]index = new int[1];
        return dfsDeserialize(ar,index);
    }

    private TreeNode dfsDeserialize(String[]ar, int[]index ){
        if(ar[index[0]].equals("N")){
            index[0]++;
            return null;
        }
        int i =index[0];
        index[0]++;
        TreeNode node = new TreeNode(Integer.parseInt(ar[i]));
        node.left = dfsDeserialize(ar,index);
        node.right = dfsDeserialize(ar,index);
        return node;
    }
}
