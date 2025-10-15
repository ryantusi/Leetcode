    // 4Sum II

    // Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

    //     0 <= i, j, k, l < n
    //     nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

    

    // Example 1:

    // Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
    // Output: 2
    // Explanation:
    // The two tuples are:
    // 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
    // 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

    // Example 2:

    // Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
    // Output: 1


public class 4SumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Store all possible sums of nums1 + nums2
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        
        // Step 2: For every sum of nums3 + nums4, check for its negative in the map
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                if (map.containsKey(target)) {
                    count += map.get(target);
                }
            }
        }

        return count;
    }
}
