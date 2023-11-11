/**
 * Given an array of integers arr, return true if and only if it is a valid
 * mountain array.
 * 
 * Recall that arr is a mountain array if and only if:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 * 
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * 
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 * 
 * Constraints:
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 */

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        // strictly increase
        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }
        // check for no increase or only increase
        if (i == 0 || i == arr.length - 1) {
            return false;
        }
        // strictly decrease
        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }
        // true if we reached the end of the array
        return i == arr.length - 1;

    }

    public static void main(String[] args) {
        ValidMountainArray vma = new ValidMountainArray();
        System.out.println("\n\n\n%%% BEGIN %%%");
        int[] nums = { 1, 2, 3, 4, 3, 2, 1, 0 };
        System.out.println(vma.validMountainArray(nums));
    }
}
