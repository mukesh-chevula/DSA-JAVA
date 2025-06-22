class LFUCache {
    class Node {
        int key, val, freq = 1;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoublyLinkedList {
        Node head = new Node(-1, -1), tail = new Node(-1, -1);
        int size = 0;

        DoublyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node lru = tail.prev;
            remove(lru);
            return lru;
        }
    }

    private final int capacity;
    private int minFreq = 0;
    private final Map<Integer, Node> keyNode = new HashMap<>();
    private final Map<Integer, DoublyLinkedList> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) return -1;
        Node node = keyNode.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.val = value;
            update(node);
        } else {
            if (keyNode.size() == capacity) {
                Node evict = freqMap.get(minFreq).removeLast();
                keyNode.remove(evict.key);
            }
            Node node = new Node(key, value);
            keyNode.put(key, node);
            freqMap.computeIfAbsent(1, z -> new DoublyLinkedList()).addFirst(node);
            minFreq = 1;
        }
    }

    private void update(Node node) {
        int freq = node.freq;
        DoublyLinkedList oldList = freqMap.get(freq);
        oldList.remove(node);

        if (freq == minFreq && oldList.size == 0) minFreq++;

        node.freq++;
        freqMap.computeIfAbsent(node.freq, z -> new DoublyLinkedList()).addFirst(node);
    }
}


/**
* Your LFUCache object will be instantiated and called as such:
* LFUCache obj = new LFUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/