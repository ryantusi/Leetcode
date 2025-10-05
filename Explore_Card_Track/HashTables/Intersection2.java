// HashMap

// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
// Explanation: [9,4] is also accepted.

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Intersection2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count frequency of each number in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Check nums2 for intersections
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1); // decrease count
            }
        }
        
        // Convert list to array
        int[] numbers = new int[result.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = result.get(i);
        }
        
        return numbers;
    }
}
