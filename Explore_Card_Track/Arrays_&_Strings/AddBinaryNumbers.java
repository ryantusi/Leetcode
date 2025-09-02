// Given two binary strings a and b, return their sum as a binary string.

 

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"

// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0'; // convert char to int
            if (j >= 0)
                sum += b.charAt(j--) - '0';

            result.append(sum % 2); // new digit
            carry = sum / 2; // update carry
        }

        if (carry > 0)
            result.append(carry); // leftover carry

        return result.reverse().toString(); // reverse final string
    }
}
