import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // 1 Two Sum https://leetcode.com/problems/two-sum

    private static int[] bruteForce(int[] nums, int target) {

        /*
        Time O(N^2)
        Space O(1)
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) return new int[]{i, j};

            }
        }

        return new int[]{};
    }

    private static int[] optimized1(int[] nums, int target) {
        /*
        Time O(N)
        Space O(N)
         */

        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var curr = nums[i];
            var diff = target - curr;
            if (map.containsKey(diff)) return new int[]{map.get(diff), i};
            map.put(curr, i);

        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        String bruteForceSolution = Arrays.toString(bruteForce(nums, target));
        String optimized1Solution = Arrays.toString(optimized1(nums, target));

        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);

    }


}
    
    