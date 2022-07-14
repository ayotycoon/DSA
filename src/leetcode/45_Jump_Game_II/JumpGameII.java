import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class JumpGameII {
    // 45 Jump Game II https://leetcode.com/problems/jump-game-ii

    private static int bruteForce(int[] nums) {
/*        
Time O(1)
 Space O(1)
*/

        return 0;
    }
//
//    private static int optimized1(int[] nums, int start) {
//        /*
//Time O(N)
// Space O(1)
//*/
//        if (start == nums.length - 1) return 0;
//
//        int ans = 0;
//        int curr = 0;
//
//        for (int i = start; i < nums.length; i++) {
//            int num = nums[i];
//            if (num > curr) {
//                int pos1 = (curr == 0) ? Integer.MAX_VALUE :optimized1(nums, i + 1); // leave
//                int pos2 = ans;// choose
//
//                if (pos1 <= pos2) {
//
//
//return pos1;
//                } else {
//                    curr = num;
//                    ans++;
//
//
//                }
//            }
//            if(i == nums.length-1)return ans;
//            if(curr == 0 ) return Integer.MAX_VALUE;
//            curr--;
//
//
//        }
//
//
//        return ans;
//    }

    private static int optimized2(int[] nums) {
        /*
            Time O(N^2)
            Space O(1)
        */
        int ans = 0;
        int l = 0;
        int r = 0;

        while(r < nums.length-1){
            int farthest = 0;
            for(int i = l; i <= r; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r+1;
            r = farthest;
            ans++;
        }


        return ans;

    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{3, 2, 1}),
                computeTestCase(new int[]{2, 3, 1}),
                computeTestCase(new int[]{2, 3, 1, 1, 4}),
                computeTestCase(new int[]{4, 1, 1, 3, 1, 1, 1}),
                computeTestCase(new int[]{5, 1, 2, 9, 1, 1, 1})


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

//                new TestCaseFunctionGroup("optimized1", () -> {
//                    var ans = optimized1(nums, 0);
//                    return ans + "";
//                }),

                new TestCaseFunctionGroup("optimized2", () -> {
                    var ans = optimized2(nums);
                    return ans + "";
                })
        );
    }


}
    
    