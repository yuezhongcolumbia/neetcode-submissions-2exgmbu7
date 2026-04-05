public class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }


}

class LRUCache {
    private Map<Integer, Node>map;
    private Node left;
    private Node right;
    private int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = right;
        this.right.prev = left;
    }
    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        
        this.right.prev = node;
        node.next = this.right;

    }
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp  = map.get(key);
            remove(temp);
            insert(temp);
            return temp.val;

            
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node temp = new Node(key,value);
        insert(temp);
        map.put(key,temp);
        
        if(map.size()>cap){
                Node lru = this.left.next;
                map.remove(lru.key);
                remove(lru);
            }
    }
}
