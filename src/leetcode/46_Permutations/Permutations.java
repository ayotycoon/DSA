import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations{
    // 46 Permutations https://leetcode.com/problems/permutations

    private static int bruteForce(int[] nums) {
/*
Time O(1)
 Space O(1)
*/

        return 0;
    }
static int k = 0;
    private static List<List<Integer>> optimized1(int[] nums) {
        k++;
        /*
Time O(N^N)
 Space O(N)
*/
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) {
ans.add(new ArrayList<>());
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            var curr = nums[i];
            int[] wordsMod = new int[nums.length - 1];

            int v = 0;

            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                wordsMod[v] = nums[j];
                v++;
            }


            var temp = optimized1(wordsMod).stream().map(x -> {
                x.add(0,curr);
                return x;
            }).collect(Collectors.toList());
            ans.addAll(temp);

        }
        return ans;
    }



    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{ 1,2,3})


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
                    return ans + "";
                },true),

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(nums);
                    return ans + "";
                })
        );
    }


}
    
    