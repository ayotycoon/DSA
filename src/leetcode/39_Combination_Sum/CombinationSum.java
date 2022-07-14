import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {
    // 39 Combination Sum https://leetcode.com/problems/combination-sum


    private static List<List<Integer>> bruteForce(int[] nums, int target) {
/*        
Time O(target * nums)
 Space O(nums)
*/
        List<List<Integer>> ans = new ArrayList<>();


        return ans;
    }

    private static  List<List<Integer>> optimized1(int[] candidates, int target, int j) {
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
            List<List<Integer>> temp = optimized1(candidates, target - num, i);
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
        List<List<Integer>> ans = optimized1(candidates,target,0);

        return ans;
    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{2,7,6,3,5,1}, 9)
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
    
    