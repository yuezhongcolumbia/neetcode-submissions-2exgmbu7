class LFUCache {
    static class Node {
        int val;
        int key;
        int freq;
        Node prev;
        Node next;


        public Node (int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
            this.prev = null;
            this.next = null;
        }

    }

    static class DoubleLinkedList {
        Node dummyFirst;
        Node dummyLast;
        int size;

        public DoubleLinkedList(){
            dummyFirst = new Node(-1, -1);
            dummyLast = new Node(-1, -1);
            dummyFirst.next = dummyLast;
            dummyLast.prev = dummyFirst;
            size = 0;
        }
        public void drop(Node node){
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
        public void insert(Node node){
            Node prevNode = this.dummyLast.prev;
            prevNode.next = node;
            node.prev = prevNode;
            node.next = this.dummyLast;
            this.dummyLast.prev = node;
            size++;
        }
        public Node lfu(){
            return dummyFirst.next;
        }

    }

    Map<Integer, Node> keyNode;
    Map<Integer, DoubleLinkedList> freqDLL;
    int minFreq;
    int capacity;
    int size;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        keyNode = new HashMap<>();
        freqDLL = new HashMap<>();
    }
    
    public int get(int key) {
        if (keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            update(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (keyNode.containsKey(key)){
            Node node = keyNode.get(key);
            node.val = value;
            update(node);
        } else {
            if (size == capacity){
                Node lfu = freqDLL.get(minFreq).lfu();
                keyNode.remove(lfu.key);
                freqDLL.get(minFreq).drop(lfu);
                if (freqDLL.get(minFreq).size == 0){
                    freqDLL.remove(minFreq);
                    minFreq++;
                }
                size--;
            }
            Node node = new Node(key, value);
            keyNode.put(key, node);
            freqDLL.putIfAbsent(1, new DoubleLinkedList());
            freqDLL.get(1).insert(node);
            minFreq = 1;
            size ++;
            
            
        }
    }
    public void update(Node node){
            int nodeFreq = node.freq;
            freqDLL.get(nodeFreq).drop(node);
            if (minFreq == nodeFreq && freqDLL.get(nodeFreq).size == 0){
                minFreq++;
                freqDLL.remove(nodeFreq);
            }


            freqDLL.putIfAbsent(nodeFreq + 1, new DoubleLinkedList());
            freqDLL.get(nodeFreq + 1).insert(node);
            node.freq++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 