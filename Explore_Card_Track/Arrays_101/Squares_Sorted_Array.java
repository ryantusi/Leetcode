/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */

/*class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1, index = n -1;
        int left2 = 0, right2 = 0;

        while(left <= right) {
            left2 = nums[left] * nums[left];
            right2  = nums[right] * nums[right];

            if(left2 > right2) {
                result[index] = left2;
                left++;
            } else {
                result[index] = right2;
                right--;
            }

            index--;
        }

        return result;
    }
}