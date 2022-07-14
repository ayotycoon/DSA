import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class SearchForARange{
    // 34 Search for a Range https://leetcode.com/problems/search-for-a-range


    private static int[] bruteForce(int[] nums, int target) {
/*
Time O(N)
 Space O(1)
*/
        int[] ans = new int[]{-1,-1};
        for (int i = 0; i < nums.length; i++) if (nums[i] == target) {
            if(ans[0] == -1) {
                ans[0] = i;
                ans[1] = i;
            } else ans[1] = i;
        }
        return ans;
    }


    private static int[] bruteForce2(int[] nums, int target) {
        /*
        Time O(N)
         Space O(1)
        */

        int i = 0;
        int j = nums.length-1;
        int[] ans = new int[]{-1,-1};
        while (i<=j) {

            int midIndex = (i+j) / 2;
            int mid = nums[midIndex];
            if (mid == target) {
                ans[0] = midIndex;
                ans[1] = midIndex;

                for(int k = midIndex-1; k>= 0; k--){
                    if(nums[k] == nums[midIndex])ans[0] = k;
                    else break;
                }
                for(int k = midIndex+1; k< nums.length; k++){
                    if(nums[k] == nums[midIndex])ans[1] = k;
                    else break;
                }

                break;
            } else if (target < mid) {
                j = midIndex-1;
            } else {
                i = midIndex+1;
            }

        }
        return ans;

    }


    private static int[] optimized1(int[] nums, int target) {
        /*
        Time O(logN)
         Space O(1)
        */

        int i = 0;
        int j = nums.length-1;
        int[] ans = new int[]{-1,-1};
        while (i<=j) {
            int midIndex = (i+j) / 2;
            int mid = nums[midIndex];
            if (mid == target) {
                ans[0] = midIndex;
                ans[1] = midIndex;
                break;
            } else if (target < mid) {
                j = midIndex-1;
            } else {
                i = midIndex+1;
            }
        }
        if(ans[0] == -1) return ans;
        // get left bound
        i = 0;
        j = ans[0];
        while (i<=j) {
            int midIndex = (i+j) / 2;
            int mid = nums[midIndex];
            if (mid == target && (midIndex-1 <0 || nums[midIndex-1] != target)) {
                ans[0] = midIndex;
                break;
            }  else if(mid < target){
                i= midIndex+1;
            }else {
                j = midIndex -1;
            }
        }
        // get right bound
        i = ans[1];
        j = nums.length-1;

        while (i<=j) {
            int midIndex = (i+j) / 2;
            int mid = nums[midIndex];
            System.out.println(midIndex);
            if (mid == target && (midIndex+1 >=nums.length || nums[midIndex+1] != target)) {
                ans[1] = midIndex;

                break;
            } else if(mid > target){
                j= midIndex-1;


            }else {
                i= midIndex+1;
            }
        }

        return ans;

    }


    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{5,7,7,8,8,10}, 8),
                computeTestCase(new int[]{5,7,7,8,8,10}, 6),
                computeTestCase(new int[]{}, 0),
                computeTestCase(new int[]{5,7,7,6,7,6,5,6,7,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,10}, 8)


        );

    }


    @NotNull
    private static TestCase computeTestCase(int[] nums, int target) {
        return new TestCase(
                "%s | %d".formatted(
                        Arrays.toString(nums), target
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return Arrays.toString(bruteForce(nums, target));

                }),
                new TestCaseFunctionGroup("bruteForce2", () -> {
                    return Arrays.toString(bruteForce2(nums, target));
                }),
                new TestCaseFunctionGroup("optimized1", () -> {
                    return Arrays.toString(optimized1(nums, target));
                })


        );
    }



}

