/**
 * 231. Power of Two
 * 
 * Easy
 * 
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2x.
 * 
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * 
 * Example 2:
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * 
 * Example 3:
 * Input: n = 3
 * Output: false
 * 
 * Constraints:
 * -231 <= n <= 231 - 1
 * 
 * Follow up: Could you solve it without loops/recursion?
 */

class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (n % 2 == 0) {
            n = n / 2;
            return isPowerOfTwo(n);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PowerOfTwo test = new PowerOfTwo();
        int sample = 6;
        boolean result = test.isPowerOfTwo(sample);
        System.out.print(sample + " is a power of 2: ");
        System.out.println(result);
    }
}