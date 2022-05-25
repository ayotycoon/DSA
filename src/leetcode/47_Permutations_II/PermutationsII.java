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



    private static void bruteForce(int[][] matrix) {
/*
Time O(1)
 Space O(1)
*/

        for(int i =0; i < matrix.length; i++){
            int[] row =  matrix[i];
            int rev = row.length-1 - i;
            for(int j =0; j < row.length; j++){


                int temp = matrix[i][j];
                matrix[i][j] = matrix[rev][j];
                matrix[rev][j] = temp;


            }
        }

    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[][]{
                        new int[]{1,2,3},
                        new int[]{4,5,6},
                        new int[]{7,8,9}
                })


        );

    }


    @NotNull
    private static TestCase computeTestCase(int[][] matrix) {
        return new TestCase(
                "%s".formatted(
                        Arrays.stream(matrix).map(a -> Arrays.toString(a)).collect(Collectors.toList()).toString()
                ),

                new TestCaseFunctionGroup("bruteForce", () -> {
                  bruteForce(matrix);
                    return Arrays.stream(matrix).map(a -> Arrays.toString(a)).collect(Collectors.toList()).toString();
                })


        );
    }



}
    
    