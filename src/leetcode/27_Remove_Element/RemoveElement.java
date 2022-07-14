import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class RemoveElement{
    // 27 Remove Element https://leetcode.com/problems/remove-element

    private static int bruteForce(int[] nums, int val){
    /*
    Time O(1)
    Space O(1)
    */
return 0;
            
    }

    private static int optimized1(int[] nums, int val){
    /*
    Time O(N)
    Space O(1)
    */


        int i =0;
        int j = 1;


        while(j < nums.length){
            if(i > j || nums[j] == val){
                j++;
                continue;
            }


            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            i++;

        }

        if(nums.length == 0) return 0;
        return i == 0 ? nums[i] == val ?  0 : 1 : i;

            
    }

    private static int optimized2(int[] nums, int val){
    /*
    Time O(N)
    Space O(1)
    */


        int left = 0;

        for(int right =0;right < nums.length; right++){

            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;


    }


    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{0,1,2,2,3,0,4,2},2),
                computeTestCase(new int[]{3,3,2,2},2),
                computeTestCase(new int[]{3,2,2},2),
                computeTestCase(new int[]{2,2,2},2)


        );

    }

    @NotNull
    private static TestCase computeTestCase(int[] nums, int val) {
        return new TestCase(
                "%s | %d".formatted(
                        Arrays.toString(nums),  val
                ),


                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(nums,  val);
                    return ans +"";
                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(nums,  val);
                    return ans +"";
                }),

                new TestCaseFunctionGroup("optimized2", () -> {
                    var ans = optimized2(nums,  val);
                    return ans +"";
                })
        );
    }




}
    
    