import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    // 33 Search in Rotated Sorted Array https://leetcode.com/problems/search-in-rotated-sorted-array

    private static int bruteForce(int[] nums, int target) {
/*        
Time O(N)
 Space O(1)
*/
        for (int i = 0; i < nums.length; i++) if (nums[i] == target) return i;
        return -1;
    }

    private static int[] findPivot(int[] nums) {
        int[] pivot = new int[]{0, nums.length - 1};
        if (nums[0] < nums[nums.length - 1]) return pivot;

        int l = nums.length-1;
        int b =0, mid = (b+l)/2;

        //find min index
        while(b < l){
            if(nums[mid] < nums[l]){
                l= mid;
            }else{
                b = mid+1;
            }
            mid = (l+b)/2;
        }

        pivot[0] = l;
        pivot[1] = l-1 >=0 ? l-1 : nums.length-1;
        return pivot;
    }

    private static int resolve(int max, int a, int b) {
        int sum = a + b;
        if (sum > max) {
            return (sum) - max - 1;
        } else if (sum < 0) {
            return max + sum + 1;
        } else {
            return sum;
        }
    }

    private static int optimized1(int[] nums, int target) {
        /*
        Time O(logN)
         Space O(1)
        */
        int[] pivot = findPivot(nums);
        int i = pivot[0];
        int j = pivot[1];

        while (resolve(nums.length - 1, i, -pivot[0]) <= resolve(nums.length - 1, j, -pivot[0])) {


            if (nums[i] == target) return i;
            if (nums[j] == target) return j;
            int midIndex = (resolve(nums.length - 1, j, -pivot[0]) + resolve(nums.length - 1, i, -pivot[0])) / 2;
            midIndex = resolve(nums.length - 1, midIndex, pivot[0]);
            int mid = nums[midIndex];
            if (mid == target) {
                return midIndex;
            } else if (target < mid) {
                j = resolve(nums.length - 1, midIndex, -1);
            } else {
                i = resolve(nums.length - 1, midIndex, 1);
            }

        }
        return -1;

    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
                computeTestCase(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)


        );

    }


    @NotNull
    private static TestCase computeTestCase(int[] nums, int target) {
        return new TestCase(
                "%s | %d".formatted(
                        Arrays.toString(nums), target
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(nums, target) + "";

                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    return optimized1(nums, target) + "";
                })


        );
    }


}
    
