import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;
import utils.Permutate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {
    // 31 Next Permutation https://leetcode.com/problems/next-permutation


    public static List<String> getAll(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            ans.add("");
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


            var temp = getAll(wordsMod).stream().map(x -> curr + x).collect(Collectors.toList());
            ans.addAll(temp);

        }
        return ans;
    }


    private static void bruteForce(int[] nums) {
/*        
Time O(N^N)
 Space O(N)
*/
        String[] ans = new String[0];
        var sorted = Arrays.copyOf(nums,nums.length);
        Arrays.sort(sorted);
        StringBuilder sb = new StringBuilder();
        for(int n: nums) sb.append(n);
        String str = sb.toString();
        var values = getAll(sorted);

        for(int i = 0; i < values.size(); i++){
            if(values.get(i).equals(str)){
                if(i+1 < values.size()){
                    ans = values.get(i+1).split("");
                }else {
                    ans = values.get(0).split("");
                }

                break;

            }

        }

        for(int i =0; i < ans.length; i++){
            nums[i] = Integer.parseInt(ans[i]);
        }

    }

    private static void optimized1(int[] nums) {
/*        
Time O(1)
 Space O(1)
*/

        List<List<Integer>> ans = new ArrayList<>();



    }


    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{1,2,3}),
                computeTestCase(new int[]{3,2,1})


        );

    }

    @NotNull
    private static TestCase computeTestCase(int[] nums) {
        return new TestCase(
                "%s ".formatted(
                         Arrays.toString(nums)
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var copy = Arrays.copyOf(nums,nums.length);
                    bruteForce( copy);
                    return Arrays.toString(copy);
                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    var copy = Arrays.copyOf(nums,nums.length);
                  optimized1( copy);
                     return Arrays.toString(copy);
                })

        );
    }


}
    
    