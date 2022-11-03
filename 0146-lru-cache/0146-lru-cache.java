class LRUCache {
    Map<Integer, Node> map = new HashMap();
    Node head; //최신값의 앞
    Node tail; //오래된 값의 뒤 -> 이 두개는 map에 더하지 않는다.
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    // 최근에 사용한 여부를 나타내야함
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            update(node);            
            
            return node.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        
        // 이미 키가 존재 : element 개수가 그대로이다. 
        if (map.containsKey(key)) {
            
            Node node = map.get(key);
            node.value = value;
            
            update(node);
        
        // 키가 존재하지 않을 때 : element 개수가 추가되어 capacity를 신경써야한다.
        } else {
            
            // 추가하면 capacity 초과 -> 오래된 요소제거
            if (map.size() == this.capacity) removeLRU();
            
            update(key, value);
        }
    }
    
    // 이미 존재하는 노드 갱신
    private void update(Node node) {
        detach(node);
        insert(node);
    }
    
    private void detach(Node node) {
        // 있던 자리에서 빼내고, 양쪽노드 이어주기 -> null일때 문제 발생할듯 -> head와 tail을 기본으로 양쪽에 두는 것으로 해결
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // 최신값으로 만들기
    private void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;
        
        head.next = node;
        node.prev = head;
    }
    
    // 새로운 노드 갱신
    private void update(int key, int value) {
        Node node = new Node(key, value);
        
        insert(node);
        map.put(key, node);
    }
    
       
    private void removeLRU() {
        map.remove(tail.prev.key);
                
        // tail 앞의 요소에 대한 참조 제거
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
    }
}

class Node {
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


/*
The functions get and put must each run in O(1) average time complexity.
get, put -> O(1)
수용량이 꽉찬 경우 가장 오래된 값을 없앤다. 

*/