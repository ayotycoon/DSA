import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class SearchInsertPosition{
    // 35 Search Insert Position https://leetcode.com/problems/search-insert-position

    private static int bruteForce(int[] nums, int target){
/*        
Time O(N)
 Space O(1)
*/
        if(nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;

            if(nums[i] > target) return i;

        }


        return nums.length;
            
    }
    private static int optimized1(int[] nums, int target){
/*        
Time O(logN)
 Space O(1)
*/
        if(nums.length == 0) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        int i = 0;
        int j = nums.length-1;
        while (i<=j) {

            int midIndex = (i+j) / 2;
            int mid = nums[midIndex];
            if (mid == target) {
                return midIndex;


            } else if (target < mid) {
                j = midIndex-1;
            } else {
                i = midIndex+1;
            }

        }

            return j+1;
    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{1,3,5,6}, 5),
                computeTestCase(new int[]{1,3,5,7}, 2),
                computeTestCase(new int[]{1,3,5,6}, 7)


        );

    }


    @NotNull
    private static TestCase computeTestCase(int[] nums, int target) {
        return new TestCase(
                "%s | %d".formatted(
                        Arrays.toString(nums), target
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(nums, target)+"";

                }),

                new TestCaseFunctionGroup("optimized1", () -> {
                    return optimized1(nums, target)+"";
                })


        );
    }


}
    
    