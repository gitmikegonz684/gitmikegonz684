import java.util.LinkedList;
import java.util.Queue;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        IsSubsequence is = new IsSubsequence();
        Boolean answer = is.isSubsequence(s, t);
        System.out.println("\n\nIsSubsequence = " + answer);
    }

    /**
     * IS SUBSEQUENCE
     * A subsequence "s" is a string which can be formed by only removing characters from string "t"
     * @param s the subsequence
     * @param t is the string which may or may not contain the subsequence s
     * @return true if s is a subsequence of t
     */
    public Boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        } else if (t.isEmpty()) {
            return false;
        }
        boolean isSubsequence = false;
        Queue<Character> q = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        char compare = q.poll();
        for (char c : t.toCharArray()) {
            if (compare == c) {
                if (q.peek() != null) {
                    compare = q.poll();
                } else {
                    isSubsequence = true;
                    break;
                }
            }
        }
        return isSubsequence;
    }
}
