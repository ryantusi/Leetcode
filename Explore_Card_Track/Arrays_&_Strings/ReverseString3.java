// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

// Example 1:

// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"

// Example 2:

// Input: s = "Mr Ding"
// Output: "rM gniD"

public class ReverseString3 {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            word.reverse();
            words[i] = word.toString();
        }

        return String.join(" ", words);
    }
}
