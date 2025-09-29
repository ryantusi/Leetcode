// Two Pointer - Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

 

// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]

// Example 2:

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

class ReverseString {
    public void reverseString(char[] s) {
        // Two Pointer Approach
        int i = 0, j = s.length - 1;
        char temp = ' ';
        
        while (j > i) {
            temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            j--;
            i++;
        }
    }
}