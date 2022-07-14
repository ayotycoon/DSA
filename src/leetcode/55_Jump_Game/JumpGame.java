import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class JumpGame{
    // 55 Jump Game https://leetcode.com/problems/jump-game

    private static boolean bruteForce(int[] nums){
/*
Time O(1)
 Space O(1)
*/

        return true;
    }
    private static boolean optimized1(int[] nums){
        /*
Time O(N)
 Space O(1)
*/

        int max = 0;
        for(int i =0; i < nums.length-1; i++){
            int curr = nums[i];

            max = Math.max(max, curr);
            if(max == 0 ) return false;
            max --;
        }


        return true;
    }
    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{3,2,1}),
                computeTestCase(new int[]{2,3,1}),
                computeTestCase(new int[]{2,3,1,1,4}),
                computeTestCase(new int[]{4,1,1,3,1,1,1})


        );

    }


    @NotNull
    private static TestCase computeTestCase(int[] nums) {
        return new TestCase(
                "%s".formatted(
                        Arrays.toString(nums)
                ),

                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(nums);
                    return ans+ "";
                }),

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(nums);
                    return ans + "";
                })
        );
    }



}
    
    