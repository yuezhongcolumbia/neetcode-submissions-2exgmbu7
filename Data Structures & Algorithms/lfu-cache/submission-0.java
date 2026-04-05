class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val){
        this.key=key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class DoublyLinkedList{
    Node head;
    Node tail;
    public DoublyLinkedList(){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev=head;
    }
    public void insert(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next= node;
        
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;;
        node.prev = null;
        node.next = null;
    }
    public Node pop_last(){
        Node node = tail.prev;
        remove(node);
        return node;
    }
    public boolean isEmpty(){
        return head.next == tail;
    }
}
class LFUCache {
    int capacity;
    Map<Integer,Node>cache;
    Map<Integer,DoublyLinkedList>freq_node;
    Map<Integer,Integer>freq;

    int min_freq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freq = new HashMap<>();
        this.freq_node = new HashMap<>();
        min_freq = 0;
    }
    
    public int get(int key) {
        if(cache.keySet().contains(key)){
            int old_freq = freq.get(key);
            Node node = cache.get(key);
            freq_node.get(old_freq).remove(node);
            freq_node.computeIfAbsent(old_freq+1,k->new DoublyLinkedList()).insert(node);
            freq.put(key,old_freq+1);
            if(freq_node.get(old_freq).isEmpty()){
                min_freq = old_freq+1;
            }
            return node.val;

        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cache.keySet().contains(key)){
            cache.get(key).val = value;
            get(key);
        }else{
            if(cache.size()>=capacity){
                Node remove = freq_node.get(min_freq).pop_last();
                cache.remove(remove.key);
                freq.remove(remove.key);
                
            }
            Node new_node = new Node(key,value);
            cache.put(key,new_node);
            freq.put(key,1);
            freq_node.computeIfAbsent(1,k->new DoublyLinkedList()).insert(new_node);
            min_freq= 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */