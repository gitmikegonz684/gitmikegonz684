public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reversed = 0;
        while (x > reversed) {
            // append the last number
            reversed = reversed * 10 + x % 10;
            // remove the last number
            x = x / 10;
        }
        return (x == reversed || x == reversed / 10);
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        int sample = 121;
        System.out.println(test.isPalindrome(sample));
    }
}
