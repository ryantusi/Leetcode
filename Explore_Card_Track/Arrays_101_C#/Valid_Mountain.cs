/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:

Input: arr = [2,1]
Output: false

Example 2:

Input: arr = [3,5,5]
Output: false

Example 3:

Input: arr = [0,3,2,1]
Output: true
 */

public class Solution
{
    public bool ValidMountainArray(int[] arr)
    {
        int len = arr.Length;
        int i = 0;

        if (len < 3) return false;

        // Walk up
        while (i + 1 < len && arr[i] < arr[i + 1])
        {
            i++;
        }

        // Peak can't be first or last
        if (i == 0 || i == len - 1) return false;

        // Walk down
        while (i + 1 < len && arr[i] > arr[i + 1])
        {
            i++;
        }

        return i == len - 1;
    }
}
