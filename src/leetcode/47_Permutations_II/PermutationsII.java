import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class PermutationsII{
    // 47 Permutations II https://leetcode.com/problems/permutations-ii


    private static List<List<Integer>> dfs(int[] nums) {

        /*
Time O(N^N)
 Space O(N^N)
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


            var temp = dfs(wordsMod).stream().map(x -> {
                x.add(0,curr);
                return x;
            }).collect(Collectors.toList());
            ans.addAll(temp);

        }
        return ans;
    }



    private static List<List<Integer>> bruteForce(int[] nums) {
/*
Time O(1)
 Space O(1)
*/
        Map<String, List<Integer>> map = new HashMap<>();

List<List<Integer>> ans = dfs(nums);
for(List<Integer> each: ans){
    map.put(each.toString(),each);
}
        return map.values().stream().collect(Collectors.toList());
    }

    private static List<List<Integer>> optimized1(int[] nums) {

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
            if(i >0 && nums[i] == nums[i-1]) continue;
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
                computeTestCase(new int[]{ 1,1,1,1,2})


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
                }),

                new TestCaseFunctionGroup("optimized1", () -> {
                    Arrays.sort(nums);
                    var ans = optimized1(nums);
                    return ans + "";
                })
        );
    }



}
    
    