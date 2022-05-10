import java.util.*;

public class ThreeSumClosest {
    // 15 3Sum https://leetcode.com/problems/3sum


    private static int bruteForce(int[] nums, int target) {
        /**
         * time O(N3)
         * space O(N)
         */
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int numI = nums[i];
                    int numJ = nums[j];
                    int numK = nums[k];

                    int add = numI + numJ + numK;
                    if(Math.abs(target- add) < Math.abs(min)) min = add;

                }
            }
        }

        return min;
    }

    private static int optimized1(int[] nums, int target) {
        /**
         * time O(N2)
         */
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int numI = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int add = nums[left] + nums[right] + numI;
                if (add > target) {
                    right--;
                } else {
                    left++;
                }


                if(Math.abs(add - target) < Math.abs(ans-target)) ans = add;


            }


        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int bruteForceSolution = bruteForce(nums, target);
        int optimized1Solution = optimized1(nums, target);


        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);


    }


}
    
    