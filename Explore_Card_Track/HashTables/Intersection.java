// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.

import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                resultSet.add(i);  // duplicates automatically ignored
            }
        }
        
        int[] res = new int[resultSet.size()];
        int idx = 0;
        for (int num : resultSet) res[idx++] = num;
        
        return res;
    }
}
