import java.util.*;

class LRUCache {

    Map<Integer, Node> searchMap = new HashMap<>();
    
    // pointers
    Node recent;
    Node old;
    
    int size = 0;
    final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!searchMap.containsKey(key)) {
            return -1;
        }

        Node find = searchMap.get(key);
        
        if (find != recent) {
            moveToFirst(find);
        } 
        
        return find.value;
    }
    
    public void put(int key, int value) {
        if (recent == null) {
            size++;
            
            Node newNode = new Node(key, value);
            searchMap.put(key, newNode);

            recent = newNode;
            old = newNode;
            return;
        }

        Node find = searchMap.get(key);
        if (find == null) {
            Node newNode = new Node(key, value);
            searchMap.put(key, newNode);

            // exceed
            if (capacity == size) {
                pasteFirst(newNode);

                // remove last
                searchMap.remove(old.key);
                
                Node before = old.before;
                before.next = null;
                old.before = null;
                old = before;

            } else {
                pasteFirst(newNode);
                size++;
            }
            
        // key is exist -> replace
        } else {
            find.value = value;
            moveToFirst(find);
        }
    } 

    private void moveToFirst(Node node) {
        if (size == 1 || node == recent) return;

        cut(node);
        pasteFirst(node);
    }
    
    private void cut(Node node) {
        if (node == old) {
            old = node.before;
            node.before.next = null;
            return;
        }
        
        // when middle node
        Node before = node.before;
        Node next = node.next;
        before.next = next;
        next.before = before;
        
        node.before = null;
        node.next = null;
    }

    private void pasteFirst(Node node) {
        recent.before = node;
        node.next = recent;
        node.before = null;
        recent = node;
    }

    static class Node {
        int key;
        int value;
        Node before;
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

init
- LinkedList를 직접 구현

put
- 캐시에 값을 추가한다면, 맨 앞에 추가. 기존 key가 있는지 여부를 map으로 판단.
- 기존 값을 대체해야 한다면 map으로 찾아가 변경 후, 맨 앞 순서로 이동시키기
- 용량 초과 시, 가장 뒤에 오래된 값을 제거하고, 맨 앞에 새 값 추가

 */