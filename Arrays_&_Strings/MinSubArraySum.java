// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

// Sliding Window / Two Pointer approach 

// Example 1:

// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.

// Example 2:

// Input: target = 4, nums = [1,4,4]
// Output: 1

// Example 3:

// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0


public class MinSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0; // left pointer of the window
        int sum = 0; // current window sum
        int minLen = Integer.MAX_VALUE; // track the minimum length found

        for (int right = 0; right < n; right++) {
            sum += nums[right]; // expand the window by including nums[right]

            // shrink window from the left while condition is satisfied
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left]; // shrink from left
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
