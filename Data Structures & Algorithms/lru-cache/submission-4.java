class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    public void add(Node node){
        Node previous = this.tail.prev;
        previous.next = node;
        node.prev = previous;
        node.next = this.tail;
        this.tail.prev = node;
    }
    public void remove(Node node){
        Node previous = node.prev;
        Node nextNode = node.next;
        previous.next = nextNode;
        nextNode.prev = previous;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            add(node);
        } else {
            Node node = new Node (key, value);
            map.put(key, node);
            add(node);
            if (map.size() > this.capacity){
                Node lru = this.head.next;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }
}
