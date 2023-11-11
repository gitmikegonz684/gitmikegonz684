/**
 * RUNNING SUM OF 1D ARRAY
 * 
 * GIVEN AN ARRAY "NUMS", RETURN AN ARRAY CONTAINING THE RUNNING SUM
 * THE RUNNING SUM ARRAY CONTAINS THE SUM OF INDICES 0 thru N AT INDEX N
 * 
 * EXAMPLE:
 * NUMS = [1, 2, 3, 4]
 * RUNNING SUM = [1, 3, 6, 10]
 */
public class RunningSum {
    public static void main(String[] args) {
        System.out.println("\nBEGIN...");
        RunningSum rs = new RunningSum();
        int[] test = {1,2,3,4};
        System.out.println(Utils.arrToString(test));
        System.out.println(Utils.arrToString(rs.runningSum(test)));
        System.out.println("...END");
    }

    public int[] runningSum(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
