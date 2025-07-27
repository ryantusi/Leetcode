/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]
 */

public class Solution
{
    public IList<int> FindDisappearedNumbers(int[] nums)
    {
        List<int> result = new List<int>();
        int index = 0;

        for (int i = 0; i < nums.Length; i++)
        {
            index = Math.Abs(nums[i]) - 1;
            nums[index] = -Math.Abs(nums[index]);
        }

        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] > 0)
            {
                result.Add(i + 1);
            }
        }

        return result;
    }
}
