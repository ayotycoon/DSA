import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSumII{
    // 40 Combination Sum II https://leetcode.com/problems/combination-sum-ii

    private static List<List<Integer>> bruteForce(int[] nums, int target) {
/*
Time O(target * nums)
 Space O(nums)
*/
        List<List<Integer>> ans = new ArrayList<>();


        return ans;
    }

    private static  List<List<Integer>> optimized1(int[] candidates, int target, int j, boolean[] used) {
        /*
            Time O(1)
            Space O(1)
        */
        if (target < 0) return new ArrayList<>();
        if (target == 0) return new ArrayList<>(){{
            add(new ArrayList<>());
        }};
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = j; i < candidates.length; i++) {
            int num = candidates[i];
            if(i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) continue;
            used[i] = true;
            List<List<Integer>> temp = optimized1(candidates, target - num, i+1,used);
            used[i] = false;
            if(temp.size() != 0){
                List<List<Integer>> val = temp.stream().map(a -> {
                    a.add(0, num);
                    return a;
                }).collect(Collectors.toList());
                ans.addAll(val);
            }
        }
        return ans;
    }

    private static List<List<Integer>> optimized1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = optimized1(candidates,target,0, new boolean[candidates.length]);

        return ans;
    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{10,1,2,7,6,1,5}, 8),
                computeTestCase(new int[]{1,1,1,1,1,1,1,1,1,1,1}, 8)
        );

    }


    @NotNull
    private static TestCase computeTestCase(int[] candidates, int target) {
        return new TestCase(
                "%s | %d".formatted(
                        Arrays.toString(candidates), target
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(candidates, target) + "";

                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    return optimized1(candidates, target) + "";
                })


        );
    }




}
    
    