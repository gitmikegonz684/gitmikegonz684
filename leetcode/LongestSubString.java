import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        LongestSubString test = new LongestSubString();
        String s = "abcabcbb";
        int answer1 = test.longestSubstringNoRepeatingChars1(s);
        int answer2 = test.longestSubstringNoRepeatingChars2(s);

        System.out.println("answer1 = " + answer1);
        System.out.println("answer2 = " + answer2);
    }

    private int longestSubstringNoRepeatingChars1(String s) {
        String maxString = "";
        int max = 0;
        for(char c : s.toCharArray()) {
            String currChar = String.valueOf(c);
            if (maxString.contains(currChar)){
                maxString = maxString.substring(maxString.indexOf(currChar) + 1);
            }
            maxString = maxString + currChar;
            max = Math.max(max, maxString.length());
        }
        return max;
    }

    private int longestSubstringNoRepeatingChars2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
