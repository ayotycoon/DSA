import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MaxAreaOfIsland{
    // 695 Max Area of Island https://leetcode.com/problems/max-area-of-island

    private static void bruteForce(){
/*        
Time O(1)
 Space O(1)
*/

            
    }
    public static int numIslands(int[][] grid, int i, int j) {
        if(i <0 || j <0 || i >= grid.length || j >= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        int down = numIslands(grid, i+1,j);
        int up = numIslands(grid, i-1,j);
        int right = numIslands(grid, i,j+1);
        int left = numIslands(grid, i,j-1);

        return 1+ down+up+right+left;

    }
    private static int optimized1(int[][] grid) {
        /*
Time O(nm)^2055
 Space O(1)
*/
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, numIslands(grid, i, j));
            }
        }

        return max;
    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[][]{
                        new int[]{1, 1, 1, 1, 0},
                        new int[]{1, 1, 0, 1, 0},
                        new int[]{1, 1, 0, 0, 0},
                        new int[]{0, 0, 0, 0, 0}
                })


        );

    }

    @NotNull
    private static TestCase computeTestCase(int[][] grid) {
        return new TestCase(
                "%s ".formatted(
                        Arrays.toString(grid)
                ),

/*
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(ListNode.create(nums1), ListNode.create(nums2));
                    return ans != null ? ans.toString() : "";
                }),
                */

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(grid);
                    return ans + "";
                })
        );
    }



}
    
    