import java.util.HashMap;
import java.util.Stack;

public class MinimumDeciBinaryNumbers {
    public static void main(String[] args) {
        System.out.println("\n\n\n%%% BEGIN %%%");
        String a = "2419";
        MinimumDeciBinaryNumbers test = new MinimumDeciBinaryNumbers();
        test.calculateMinimumNumbers(a);
    }

    /**
     * Steps
     * 1. insert into stack (can do this without a stack?)
     * 2. pop from stack and depending on postion do mod 10,100,1000, etc.
     * 3. insert into a map the count needed for 1s 10s 100s etc.
     * 4.
     */
    private void calculateMinimumNumbers(String a) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        int length = a.length();
        char[] arr = a.toCharArray();
        /* INSERT NUBMERS INTO STACK */
        for (char c : arr) {
            String s = String.valueOf(c);
            stack.push(Integer.valueOf(s));
        }
        /* CALCULATE DECI BINARIES NEEDED FOR EACH DECIMAL PLACE */
        for (int i = 0; i < length; i++) {
            int temp = stack.pop();

            Double base = new Double(10);
            Double keyExponent = new Double(i);
            int key = (int) Math.pow(base, keyExponent);

            Double valueExponent = new Double(i + 1);
            int mod = (int) Math.pow(base, valueExponent);
            int value = temp % mod;

            tracker.put(key, value);
        }

        System.out.println(tracker.toString());
    }
}
