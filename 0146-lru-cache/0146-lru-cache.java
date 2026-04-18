import java.util.*;

class LRUCache {

    Map<Integer, Node> ref = new HashMap<>();
    int capacity;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node find = ref.get(key);
        if (find == null) {
            return -1;
        }

        update(find);
        return find.value;
    }

    private void update(Node node) {
        detach(node);
        insertFirst(node);
    }

    private void detach(Node node) {
        (node.prev).next = node.next;
        (node.next).prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    private void insertFirst(Node node) {
        node.prev = head;
        node.next = head.next;

        (head.next).prev = node;
        head.next = node;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        ref.put(key, newNode);
      
        insertFirst(newNode);

        if (ref.size() > capacity) {
            ref.remove(tail.prev.key);
            detach(tail.prev);
        }
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node() {}
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */