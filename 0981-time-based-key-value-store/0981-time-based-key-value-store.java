import java.util.*;

class TimeMap {

    Map<String, TreeMap<Integer, String>> timeMap; // <key, <stamp, value>>

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new TreeMap<Integer,String>());
        TreeMap<Integer, String> treeMap = timeMap.get(key);

        treeMap.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";

        TreeMap<Integer, String> tree = timeMap.get(key);
        Integer floorStamp = tree.floorKey(timestamp);
        if (floorStamp == null) return "";

        return tree.getOrDefault(floorStamp, "");
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */