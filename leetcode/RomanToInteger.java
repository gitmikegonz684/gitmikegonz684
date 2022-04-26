import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Roman numerals are represented by seven different symbols:
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * 
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 * 
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * 
 * Constraints:
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {
    private HashMap<Character, Integer> dict = new HashMap<Character, Integer>();

    public RomanToInteger(){
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
    }
    public static void main(String[] args) {
        System.out.println("\n== BEGIN ==");
        RomanToInteger object = new RomanToInteger();
        String sample = "XLVI"; // 46
        int answer = object.romanToInt(sample);
        System.out.println(sample + " = " + answer);
        System.out.println("==  END  ==");
    }

    private int romanToInt(String s) {
        int prev = 0;
        char p = ' ';
        char c = ' ';
        int cValue = 0;
        int pValue = 0;
        int totalSum = 0;

        for(int curr = s.length()-1; curr>=0; curr--){
            c = s.charAt(curr);
            cValue = dict.get(c);
            prev = curr + 1;
            if (prev < s.length()) {
                p = s.charAt(prev);
                pValue = dict.get(p);
                if (cValue >= pValue) {
                    totalSum += cValue;
                } else {
                    totalSum -= cValue;
                }
            } else {
                totalSum += cValue;
            }
        }

        return totalSum;
    }
}
