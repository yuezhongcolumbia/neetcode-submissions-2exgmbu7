class LRUCache {
    static class Node{
        int val;
        Node next;
        Node prev;
        
        public Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        // public void drop (Node node){
        //     Node prevNode = node.prev;
        //     Node nextNode = node.next;
        //     prevNode.next = prev.next.next;
        //     nextNode.prev = prevNode;
            
        // }

        // public void insert (Node node){

        // }
    }
    Map<Integer, Integer> map;
    Map<Integer, Node> mapToNode;
    int capacity;
    Node head;
    Node tail;

    // 1. what ds we use to find LRU key value pair?
    //     a. queue, The problem is that we cannot directly locate the key in the queue efficiently
    //     b. linkedlist?      
    //         b1. when used(get, put(update, insert)), we move the node to the back off the list
    //         b2. if full, we evict the one in the front. 
    //         b3. need doubly linked list, because we need to locate the end of the list

    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        mapToNode = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public void drop (Node node){
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = prevNode.next.next;
            nextNode.prev = prevNode;
            
    }
    public void insert(Node node){
        Node prevNode = tail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = tail;
        tail.prev = node;
    }

        
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = mapToNode.get(key);
        drop(node);
        insert(node);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        //update
        if (map.containsKey(key)){
            Node node = mapToNode.get(key);
            map.put(key, value);
            drop(node);
            insert(node);
        } else {
            //insert
            if (map.keySet().size() == capacity){
                Node lruNode = head.next;
                map.remove(lruNode.val);
                mapToNode.remove(lruNode.val);
                drop(lruNode);     
            } 
                Node newNode = new Node(key);
                map.put(key, value);
                mapToNode.put(key, newNode);
                insert(newNode);
            
        }
        
    }
}
