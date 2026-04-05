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
    Map<Node, Node> cloned;
    public Node cloneGraph(Node node) {
        // 1. return: node
        // 2. choices: every node in the adj
        // 3. base: null
        cloned = new HashMap<>();
        return dfs(node);
    }
    public Node dfs(Node node){
        if (node == null) return null;
        if (cloned.containsKey(node)){
            return cloned.get(node);
        }
        Node clone = new Node(node.val);
         
        clone.neighbors = new ArrayList<>();
        cloned.put(node, clone);
        for (Node nei: node.neighbors){
            clone.neighbors.add(dfs(nei));
        }
       
        return clone;
    }
}