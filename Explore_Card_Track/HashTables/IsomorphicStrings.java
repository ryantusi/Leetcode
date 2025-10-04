// Given two strings s and t, determine if they are isomorphic.

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

// Example 1:

// Input: s = "egg", t = "add"

// Output: true

// Explanation:

// The strings s and t can be made identical by:

//     Mapping 'e' to 'a'.
//     Mapping 'g' to 'd'.

// Example 2:

// Input: s = "foo", t = "bar"

// Output: false

// Explanation:

// The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

// Example 3:

// Input: s = "paper", t = "title"

// Output: true

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hash = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char S = s.charAt(i), T = t.charAt(i);
            if (hash.containsKey(S)) {
                if (hash.get(S) != T)
                    return false;
            } else {
                if (set.contains(T))
                    return false;
                hash.put(S, T);
                set.add(T);
            }
        }

        return true;
    }
}