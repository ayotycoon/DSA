import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    // 41 First Missing Positive https://leetcode.com/problems/first-missing-positive

    private static int bruteForce(int[] nums) {
/*        
Time O(NLogN)
 Space O(1)
*/
        Arrays.sort(nums);
        if (nums.length == 0) return 1;
        boolean seenPositive = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= 0) continue;
            if (!seenPositive && nums[i] != 1) return 1;
            seenPositive = true;
            if (nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;

            }

        }

        return Math.max(nums[nums.length - 1] + 1, 1);

    }

    private static int optimized1(int[] nums) {
/*        
Time O(N)
 Space O(N)
*/
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        for(int i=1; i <= nums.length+1; i++) if(!set.contains(i)) return i;

        return 0;
    }

    private static int optimized2(int[] nums) {
/*
Time O(N)
 Space O(1)
*/


        for(int i=0; i < nums.length; i++) if(nums[i] <0) nums[i] = 0;
        for(int i=0; i < nums.length; i++) if(Math.abs(nums[i]) > nums.length || Math.abs(nums[i]) < 1) continue;else nums[Math.abs(nums[i])-1] = Math.abs(nums[Math.abs(nums[i])-1]) != 0 ? -Math.abs(nums[Math.abs(nums[i])-1]) : -(nums.length*2); ;
        for(int i=1; i <= nums.length; i++) if(nums[i-1] >=0) return i;
        return nums.length+1;
    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{0, 1, 2}),
                computeTestCase(new int[]{1, 2, 0}),
                computeTestCase(new int[]{3, 4, -1, 1}),
                computeTestCase(new int[]{7, 8, 9, 11, 12})


        );

    }


    @NotNull
    private static TestCase computeTestCase(int[] nums) {
        return new TestCase(
                "%s ".formatted(
                        Arrays.toString(nums)
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(Arrays.copyOf(nums,nums.length)) + "";

                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    return optimized1(Arrays.copyOf(nums,nums.length)) + "";
                }),

                new TestCaseFunctionGroup("optimized2", () -> {
                    return optimized2(Arrays.copyOf(nums,nums.length)) + "";
                })


        );
    }


}
    
    