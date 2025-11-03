/* 
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

*/

public class Solution
{
    public int FindMaxConsecutiveOnes(int[] nums)
    {
        int max = 0;
        int count = 0;

        foreach (int num in nums)
        {
            if (num == 1)
            {
                count++;
            }
            else
            {
                max = Math.Max(max, count);
                count = 0;
            }
        }

        return Math.Max(max, count);
    }
}
