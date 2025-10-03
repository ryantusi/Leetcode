// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

 

// Example 1:

// Input: nums = [2,2,1]

// Output: 1

// Example 2:

// Input: nums = [4,1,2,1,2]

// Output: 4

// Example 3:

// Input: nums = [1]

// Output: 1

import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int i : nums) {
            if(hash.contains(i)) {
                hash.remove(i);
            } else {
                hash.add(i);
            }
        }
        Iterator<Integer> it = hash.iterator();
        return it.next();
    }
}
