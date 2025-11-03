/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Example 2:
 * 
 * Input: nums = [0]
 * Output: [0]
 */

// Two Pointers Approach
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0, n = nums.length;
        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }

        while (slow < n) {
            nums[slow++] = 0;
        }
    }
}
