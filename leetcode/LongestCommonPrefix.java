import java.util.Currency;

/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
Constraints:
    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lower-case English letters.
 */

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = { "flower", "flow", "flight" };
        String answer = test.solution(strs);
        System.out.println(answer);
    }

    /**
     * 
     * @param words
     * @return
     */
    private String solution(String[] words) {
        StringBuilder prefix = new StringBuilder();
        boolean lettersMatch = true;
        if (words.length < 2) {
            lettersMatch = false;
            prefix.append(words[0]);
        }
        int index = 0;
        while (lettersMatch) {
            char currChar = ' ';
            try {
                currChar = words[0].charAt(index);
                for (String word : words) {
                    if (currChar != word.charAt(index)) {
                        lettersMatch = false;
                        break;
                    }
                }
            } catch (Exception e) {
                lettersMatch = false;
            }
            if (lettersMatch) {
                prefix.append(currChar);
                index++;
            }
        }
        return prefix.toString();
    }
}
