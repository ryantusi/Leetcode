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

public class Solution
{
    public int[] SortedSquares(int[] nums)
    {
        int n = nums.Length;
        int[] result = new int[n];
        int left = 0, right = n - 1, index = n - 1;
        int leftSquared = 0, rightSquared = 0;

        while (left <= right)
        {
            leftSquared = nums[left] * nums[left];
            rightSquared = nums[right] * nums[right];

            if (leftSquared > rightSquared)
            {
                result[index] = leftSquared;
                left++;
            }
            else
            {
                result[index] = rightSquared;
                right--;
            }

            index--;
        }

        return result;
    }
}
