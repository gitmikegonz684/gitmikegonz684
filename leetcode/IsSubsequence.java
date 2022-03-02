import java.util.LinkedList;
import java.util.Queue;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        IsSubsequence isSubsequence = new IsSubsequence();
        Boolean answer = isSubsequence.test(s, t);
        System.out.println("\n\nis subsequence = " + answer);
    }

    public IsSubsequence() {
    };

    public Boolean test(String s, String t) {
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
