import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
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
        if (nums.length == 0) return;
/*        
Time O(N^N)
 Space O(N)
*/
        String[] ans = new String[0];
        var sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        StringBuilder sb = new StringBuilder();
        for (int n : nums) sb.append(n);
        String str = sb.toString();
        var values = getAll(sorted).stream().sorted((a, b) -> Integer.parseInt(a) - Integer.parseInt(b)).collect(Collectors.toList());


        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(str)) {
                if (i + 1 < values.size()) {
                    if (values.get(i + 1).equals(str)) continue;
                    ans = values.get(i + 1).split("");
                } else {
                    ans = values.get(0).split("");
                }

                break;

            }

        }

        for (int i = 0; i < ans.length; i++) {
            nums[i] = Integer.parseInt(ans[i]);
        }

    }

    private static void optimized1(int[] nums) {
/*        
Time O(N)
 Space O(1)
lexographically
 Step 1: scan from right to left and stop at 4 because it less than 5. Here, index = 0
Step 2: Again scan from right to left and stop at 5 because it is greater. Here, j = 1
Step 3: Swap the elements at index and j. The array will become [5,4,3,2,1].
Step 4: Reverse the array after index. The array will become [5,1,2,3,4]
*/
        int j = -1;
        int k = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 < nums.length && nums[i] < nums[i + 1]) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[j]) {
                k = i;
                break;
            }
        }


        int temp = nums[j];
        nums[j] = nums[k];
        nums[k] = temp;

        for (int i = j + 1; i <= (nums.length + j - 1) / 2; i++) {
            int other = nums.length - i + j;

            int temp2 = nums[i];
            nums[i] = nums[other];
            nums[other] = temp2;

        }


    }


    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{1, 2, 3}),
                computeTestCase(new int[]{3, 2, 1}),
                computeTestCase(new int[]{4, 5, 3, 2, 1}),
                computeTestCase(new int[]{4, 3, 5, 2, 1}),
                computeTestCase(new int[]{4, 3, 1, 2, 5}),
                computeTestCase(new int[]{}),
                computeTestCase(new int[]{4, 2, 0, 2, 3, 2, 0}),
                computeTestCase(new int[]{1, 5, 1})


        );

    }



    @NotNull
    private static TestCase computeTestCase(int[] nums) {
        return new TestCase(
                "%s ".formatted(
                        Arrays.toString(nums)
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var copy = Arrays.copyOf(nums, nums.length);
                    bruteForce(copy);
                    return Arrays.toString(copy);
                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    var copy = Arrays.copyOf(nums, nums.length);
                    optimized1(copy);
                    return Arrays.toString(copy);
                })

        );
    }


}
    
    