/**
 * GIVEN AN INTEGER ARRAY "NUMS", RETURN THE LEFT-MOST PIVOT INDEX OF THE ARRAY
 * A PIVOT INDEX IS ONE IN WHICH SATISFIES THE FOLLOWING CONDITION:
 * THE SUM OF THE LEFT VALUES == SUM OF THE RIGHT VALUES
 * 
 * IF THERE ARE NO VALUES ON A SIDE, THE SUM OF THAT SIDE IS 0
 * IF THERE IS NOT AN INDEX WHICH MEETS THE CONDITION, RETURN -1
 * 
 * EXAMPLE:
 * nums = [1,7,3,6,5,6]
 * pivot index = 3
 * 
 * EXAMPLE:
 * nums = [2,1,-1]
 * pivot index = 0
 */
public class PivotIndex {
    public static void main(String[] args) {
        System.out.println("\nBEGIN...");
        PivotIndex pi = new PivotIndex();
        int[] test1 = {1,3,10,1,12,-1,3}; // 3
        int[] test2 = {1,7,3,6,5,6}; // 3
        int[] test3 = {1,2,3}; // -1
        int[] test4 = {2,1,-1}; // 0
        System.out.println(Utils.arrToString(pi.runningSumLR(test4)));
        System.out.println(Utils.arrToString(pi.runningSumRL(test4)));
        System.out.println(pi.pivotIndex(test4));
        System.out.println("...END");
    }

    /**
     * PIVOT INDEX
     * CREATES AN ARRAY WITH THE RUNNING SUM OF NUMS FROM LEFT TO RIGHT
     * CREATES ANOTHER ARRAY WITH THE RUNNING SUM OF NUMS FROM RIGHT TO LEFT
     * USES THE TWO ARRAYS CREATED ABOVE TO FIND THE LEFT-MOST PIVOT INDEX
     * 
     * @param nums
     * @return THE LEFT-MOST PIVOT INDEX
     */
    public int pivotIndex(int[] nums) {
        int[] sumLR = runningSumLR(nums);
        int[] sumRL = runningSumRL(nums);
        int left = 0;
        int right = 0;
        for (int i=0; i<nums.length; i++) {
            if (sumLR[i] == sumRL[i]) {
                if (i-1 > -1) {
                    left = sumLR[i-1];
                }
                if (i+1 < nums.length) {
                    right = sumRL[i+1];
                }
                if (left == right) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int[] runningSumLR(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = nums[0];
        for (int i=1; i<output.length; i++) {
            output[i] = output[i-1] + nums[i];
        }
        return output;
    }

    private int[] runningSumRL(int[] nums) {
        int[] output = new int[nums.length];
        output[output.length-1] = nums[nums.length-1];
        for (int i=output.length-2; i>-1; i--) {
            output[i] = output[i+1] + nums[i];
        } 
        return output;
    }

    public int pivotIndexLite(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int num: nums) sum += num;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
