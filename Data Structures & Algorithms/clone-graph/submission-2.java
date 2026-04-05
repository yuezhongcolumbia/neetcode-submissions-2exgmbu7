/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> newOld;
    public Node cloneGraph(Node node) {
        newOld = new HashMap<>();
        return dfs(node);
    }
    public Node dfs(Node node){
        //build node itself
        //build neighbors
        if (node == null) return null;
        if (newOld.containsKey(node)){
            return newOld.get(node);
        }
        Node clone = new Node(node.val);
        newOld.put(node, clone);
        for (Node nei: node.neighbors){
            clone.neighbors.add(dfs(nei));
        }
        
        return clone;
    }
}