// Given an integer array nums and an integer k,return the k most frequent elements.You may return the answer in any order.

// Example 1:

// Input:nums=[1,1,1,2,2,3],k=2

// Output:[1,2]

// Example 2:

// Input:nums=[1],k=1

// Output:[1]

// Example 3:

// Input:nums=[1,2,1,2,1,2,3,1,3,2],k=2

// Output:[1,2]

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TopK {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);

        // Buckets: index = frequency
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : freq.keySet()) {
            int f = freq.get(n);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(n);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) res.addAll(bucket[i]);
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}