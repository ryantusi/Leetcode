/*Given an Long array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3, 2, 1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:

Input: nums = [1, 2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: nums = [2, 2, 3, 1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 */

/*class Solution {
    public int thirdMax(int[] nums) {
        int flag = (nums.length > 3) ? 3 : nums.length;
        int count = 0;
        int max = Long.MIN_VALUE;
        int pointer = 0;

        while(count < flag) {
            pointer = 0;
            max = Long.MIN_VALUE;
            for(int i = 0; i < nums.length - count; i++) {
                max = Math.max(max, nums[i]);
                if(nums[i] != max) {
                    nums[pointer] = nums[i];
                    pointer++;
                }
            }
            count++;
        }

        return max;
    }
}*/

public class Solution
{
    public int ThirdMax(int[] nums)
    {
        long first = long.MinValue, second = long.MinValue, third = long.MinValue;

        foreach (int num in nums)
        {
            if (num == first || num == second || num == third)
                continue; // Skip duplicates

            if (num > first)
            {
                third = second;
                second = first;
                first = num;
            }
            else if (num > second)
            {
                third = second;
                second = num;
            }
            else if (num > third)
            {
                third = num;
            }
        }

        return third == long.MinValue ? (int)first : (int)third;
    }
}
