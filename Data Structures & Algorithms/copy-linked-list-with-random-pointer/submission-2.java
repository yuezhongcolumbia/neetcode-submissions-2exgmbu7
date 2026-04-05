/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(null, null);
        Node cur = head;
        while(cur != null){
            if (!oldToNew.containsKey(cur)){
                oldToNew.put(cur, new Node(0));
            }
            oldToNew.get(cur).val = cur.val;
            
            if (!oldToNew.containsKey(cur.next)){
                oldToNew.put(cur.next, new Node(0));
            }
            oldToNew.get(cur).next = oldToNew.get(cur.next);
            
            if (!oldToNew.containsKey(cur.random)){
                oldToNew.put(cur.random, new Node(0));
            }
            oldToNew.get(cur).random = oldToNew.get(cur.random);

            cur = cur.next;

        }
        return oldToNew.get(head);

    }
}
