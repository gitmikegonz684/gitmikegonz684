import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.)

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 
Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println("\n\n\n%%% BEGIN %%%");
        /** Test 1 Output: [0,1] */
        // int[] nums = { 2, 4, 11, 3 };
        // int target = 6;
        /** Test 2 Output: [1,2] */
        int[] nums = { 3, 2, 4 };
        int target = 6;
        TwoSum ts = new TwoSum();
        ts.findTwoSum(nums, target);
    }

    private int[] findTwoSum(int[] nums, int target) {
        ArrayList<Integer> numList = convertArrayToList(nums);
        int indexA = -1;
        int indexB = -1;

        while (indexA < 0 && indexB < 0) {
            for (int i = 0; i < numList.size(); i++) {
                int remainder = target - numList.get(i);
                if (numList.contains(remainder)) {
                    for (int j = 0; j < numList.size(); j++) {
                        if (numList.get(j) == remainder && i != j) {
                            indexA = i;
                            indexB = j;
                            break;
                        }
                    }
                }
            }
        }
        int[] answer = { indexA, indexB };
        Arrays.sort(answer);
        System.out.println("indices: " + answer[0] + ", " + answer[1]);
        return answer;
    }

    private ArrayList<Integer> convertArrayToList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }
}
