import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray{
    // 26 Remove Duplicates from Sorted Array https://leetcode.com/problems/remove-duplicates-from-sorted-array

    private static int bruteForce(int[] nums){
        /*
        Time O(N)
        Space O(N)
         */
        Set<Integer> set = new LinkedHashSet<>();
        for(int i: nums) set.add(i);
        return set.size();

    }
    private static int optimized1(int[] nums){
        /*
        Time O(N)
        Space O(1)
         */

        int i = 1;
        int j = 1;

        while (i <= j && j < nums.length){
            int currJ = nums[j];

            if(currJ ==nums[j-1]){
                j++;

            }else {
                nums[i] = currJ;
                i++;
                j++;
            }



        }



        return i;
    }


    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{1,1,2}),
                computeTestCase(new int[]{0,0,1,1,1,2,2,3,3,4})


        );

    }

    @NotNull
    private static TestCase computeTestCase(int[] nums) {
        return new TestCase(
                "%s ".formatted(
                        Arrays.toString(nums)
                ),


                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(nums);
                    return ans +"";
                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(nums);
                    return ans +"";
                })
        );
    }



}
    
    