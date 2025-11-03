// Design a HashMap without using any built-in hash table libraries.

// Implement the MyHashMap class:

// MyHashMap()initializes the object with an empty map.void put(int key,int value)inserts a(key,value)pair into the HashMap.If the key already exists in the map,update the corresponding value.int get(int key)returns the value to which the specified key is mapped,or-1 if this map contains no mapping for the key.void remove(key)removes the key and its corresponding value if the map contains the mapping for the key.

// Example 1:

// Input["MyHashMap","put","put","get","get","put","get","remove","get"][[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]Output[null,null,null,1,-1,null,1,null,-1]

// Explanation MyHashMap myHashMap=new MyHashMap();myHashMap.put(1,1); // The map is now [[1,1]]
// myHashMap.put(2,2); // The map is now [[1,1], [2,2]]
// myHashMap.get(1); // return 1, The map is now [[1,1], [2,2]]
// myHashMap.get(3); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
// myHashMap.put(2,1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
// myHashMap.get(2); // return 1, The map is now [[1,1], [2,1]]
// myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
// myHashMap.get(2); // return -1 (i.e., not found), The map is now [[1,1]]

import java.util.*;

public class HashMap {
    private int SIZE = 100;
    private LinkedList<Pair>[] buckets;
    
    private static class Pair {
        int key, value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMap() {
        buckets = new LinkedList[SIZE];
        for(int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    public int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int i = hash(key);
        for(Pair p : buckets[i]) {
            if(p.key == key) {
                p.value = value;
                return;
            }
        }
        buckets[i].add(new Pair(key, value));
    }
    
    public int get(int key) {
        int i = hash(key);
        for(Pair p : buckets[i]) {
            if(p.key == key) return p.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int i = hash(key);
        Iterator<Pair> it = buckets[i].iterator();
        while(it.hasNext()) {
            if(it.next().key == key) {
                it.remove();
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
