//Approach : Bruteforce
// Time & Space Complexity
// Time complexity: O(1) for set() and O(n) for get().
// Space complexity: O(m∗n)
// Where n is the total number of unique timestamps associated with a key and m is the total number of keys.

public class TimeMap {
    private Map<String, Map<Integer, List<String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyStore.containsKey(key)) {
            keyStore.put(key, new HashMap<>());
        }
        if (!keyStore.get(key).containsKey(timestamp)) {
            keyStore.get(key).put(timestamp, new ArrayList<>());
        }
        keyStore.get(key).get(timestamp).add(value);
    }

    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key)) {
            return "";
        }
        int seen = 0;

        for (int time : keyStore.get(key).keySet()) {
            if (time <= timestamp) {
                seen = Math.max(seen, time);
            }
        }
        if (seen == 0) return "";
        int back = keyStore.get(key).get(seen).size() - 1;
        return keyStore.get(key).get(seen).get(back);
    }
}




 
//Approach : Binary Search. (Sorted Map)
// Time & Space Complexity
// Time complexity: O(n) or O(logn) for set() depending on the language and O(logn) for get().
// Space complexity: O(m∗n)
// Where n is the total number of values associated with a key and m is the total number of keys.

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> m;

    public TimeMap() {
        m = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        m.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = m.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}










Great! Let’s go through the other TreeMap navigation methods and how they differ from floorEntry. These are all O(log N) operations.

1. floorEntry(K key)

Definition: Returns the entry with the largest key ≤ given key

Return: Map.Entry<K,V> or null if none exists

Use case: “Get the latest value at or before this timestamp”

Example:

TreeMap<Integer, String> map = new TreeMap<>();
map.put(1, "a");
map.put(3, "b");
map.put(5, "c");

map.floorEntry(4); // returns 3 -> "b"
map.floorEntry(5); // returns 5 -> "c"
map.floorEntry(0); // returns null

2. ceilingEntry(K key)

Definition: Returns the entry with the smallest key ≥ given key

Return: Map.Entry<K,V> or null if none exists

Use case: “Get the next value at or after this timestamp”

Example:

map.ceilingEntry(4); // returns 5 -> "c"
map.ceilingEntry(5); // returns 5 -> "c"
map.ceilingEntry(6); // returns null

3. lowerEntry(K key)

Definition: Returns the entry with the largest key < given key

Return: Map.Entry<K,V> or null if none exists

Use case: “Get the last value strictly before this timestamp”

Example:

map.lowerEntry(4); // returns 3 -> "b"
map.lowerEntry(1); // returns null

4. higherEntry(K key)

Definition: Returns the entry with the smallest key > given key

Return: Map.Entry<K,V> or null if none exists

Use case: “Get the next value strictly after this timestamp”

Example:

map.higherEntry(4); // returns 5 -> "c"
map.higherEntry(5); // returns null

✅ Quick Reference
Method	Meaning	Inclusive/Exclusive	Example
floorEntry(k)	≤ k	inclusive	4 → 3
ceilingEntry(k)	≥ k	inclusive	4 → 5
lowerEntry(k)	< k	exclusive	4 → 3
higherEntry(k)	> k	exclusive	4 → 5
Why HashMap cannot do this efficiently

HashMap has no order → cannot find “largest key ≤ k” in O(log N)

TreeMap maintains sorted order → predecessor/successor queries are fast













// Binary Search (Sorted Map)
// Intuition
// For each key, we store all its (timestamp, value) pairs in sorted order by timestamp.

// When we call get(key, timestamp), we don’t want to scan everything.
// Instead, we want to quickly find the largest timestamp ≤ given timestamp for that key.

// Because the timestamps are sorted, we can use binary search to find this position in O(log n) time:

// If we find an exact match, return its value.
// Otherwise, return the value at the closest smaller timestamp.
// If there is no smaller or equal timestamp, return "".
// So the idea is:

// Per key → keep timestamps sorted.
// On get → binary search over those timestamps.
// Algorithm
// Maintain a map:
// key -> sorted list of (timestamp, value) (or two parallel arrays: one for timestamps, one for values).
// set(key, value, timestamp):
// Insert (timestamp, value) into the list for that key, keeping timestamps in sorted order.
// (If timestamps are always added in increasing order, you can just append.)
// get(key, timestamp):
// If key does not exist, return "".
// Let times be the sorted list of timestamps for this key.
// Use binary search on times to find the rightmost index i such that times[i] ≤ timestamp.
// If such an index exists:
// Return the value associated with times[i].
// Otherwise:
// Return "" (no value was set at or before that time).