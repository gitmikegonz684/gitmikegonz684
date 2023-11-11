import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * ISOMORPHIC STRINGS
 * Determines if two strings are isomorphic
 * 
 * Example 1:
 * Input: a = "egg", b = "add"
 * Output: true
 * 
 * Example 2:
 * Input: a = "foo", b = "bar"
 * Output: false
 * 
 * Example 3:
 * Input: a = "paper", b = "title"
 * Output: true
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings is = new IsomorphicStrings();
        String s1 = "add"; // badc abcd paper add
        String s2 = "egg"; // baba eeff title egg
        System.out.println(is.isIsomorphic(s1, s2));
    }

    /**
     * IS ISOMORPHIC
     * 
     * @param a the first string in the comparison
     * @param b the second string in the comparison
     * @return true if the strings are isomorphic, false if not
     */
    public boolean isIsomorphic(String a, String b) {
        Map<Character,Character> dict = new HashMap<Character,Character>();
        List<Character> values = new ArrayList<Character>();
        for (int i=0; i<a.length(); i++) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (dict.keySet().contains(ca)) {
                if (!dict.get(ca).equals(cb)) {
                    return false;
                }
            } else {
                if (!values.contains(cb)) {
                    dict.put(ca, cb);
                    values.add(cb);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
