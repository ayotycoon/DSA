
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class FourSum{
    // 18 4Sum https://leetcode.com/problems/4sum

    private static void sort(List<Integer> item) {
        // O(1)

        if (item.get(0) > item.get(1)) {
            Collections.swap(item, 0, 1);
        }
        if (item.get(0) > item.get(2)) {
            Collections.swap(item, 0, 2);
        }
        if (item.get(0) > item.get(3)) {
            Collections.swap(item, 0, 3);
        }
        if (item.get(1) > item.get(2)) {
            Collections.swap(item, 1, 2);
        }
        if (item.get(1) > item.get(3)) {
            Collections.swap(item, 1, 3);
        }
        if (item.get(2) > item.get(3)) {
            Collections.swap(item, 2, 3);
        }


    }

    private static List<List<Integer>> bruteForce(int[] nums, int target) {
        /**
         * time O(4)
         * space O(N)
         */
        Map<String, List<Integer>> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            sort(list);
                            if (!ans.containsKey(list.toString())) ans.put(list.toString(), list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ans.values());
    }

    private static List<List<Integer>> optimized1(int[] nums, int target) {
        /**
         * time O(3)
         * space O(N)
         * 3sumlike
         */
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i+1 && nums[j - 1] == nums[j]) continue;
                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    int add = nums[i] + nums[j] + nums[k] + nums[l];
                    if (add == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (add < target) {
                        k++;
                    } else {
                        l--;
                    }
                }

            }
        }

        return ans;

    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new int[]{1, 0, -1, 0, -2, 2}, 0),
                computeTestCase(new int[]{2,2,2,2,2}, 8),
                computeTestCase(new int[]{2,2,2,2,2,2,2,2,2}, 8)


        );


    }

    @NotNull
    private static TestCase computeTestCase(int[] nums, int target) {
        return new TestCase(
                "%s | %s".formatted(
                        Arrays.toString(nums),
                        String.valueOf(target)),

                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(nums, target);
                    return ans.toString();
                }),

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(nums, target);
                    return ans.toString();
                })
        );
    }


}
    
    