class Trie {
    List<String> trie;
    String previous;
    
    public Trie() {
        this.trie = new LinkedList();
    }
    
    public void insert(String word) {
        int start = 0;
        int end = trie.size() - 1;
        int mid = 0;
        String midVal = "";
        
        while (start <= end) {
            mid = (start + end) / 2;
            midVal = trie.get(mid);
            
            if (midVal.equals(word)) {
                trie.add(mid, word);
                return;
            } else if (midVal.compareTo(word) > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        trie.add(start, word);
    }
    
    public boolean search(String word) {
        int start = 0;
        int end = trie.size() - 1;
        int mid = 0;
        String midVal = "";
        
        while (start <= end) {
            mid = (start + end) / 2;
            midVal = trie.get(mid);
            
            
            if (midVal.equals(word)) {
                return true;
            } else if (midVal.compareTo(word) > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
            
        return false;
    }
    
    public boolean startsWith(String prefix) {
        int start = 0;
        int end = trie.size() - 1;
        int mid = 0;
        String midVal = "";
        
        while (start <= end) {
            mid = (start + end) / 2;
            midVal = trie.get(mid);
            
            if (midVal.startsWith(prefix)) {
                return true;
            } else if (midVal.compareTo(prefix) > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
            
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


/* 0~6 -> 0 + 7 / 2 -> 3  
1) 0~2 -> 2 / 2 -> 1
    1 -1) 1 / 2 -> 0 -> 0~0 mid0 s1,e0 or s0,e-1
2) 4~7 -> 11/ 2 -> 5

1 <= word.length, prefix.length <= 2000
3 * 10^4 calls in total
binarySearch
*/ 