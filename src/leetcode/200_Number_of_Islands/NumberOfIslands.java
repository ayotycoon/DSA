import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class NumberOfIslands {
    // 200 Number of Islands https://leetcode.com/problems/number-of-islands

    private static void bruteForce() {
/*        
Time O(1)
 Space O(1)
*/


    }

    public static int numIslands(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if (grid[i][j] == '0') return 0;

        // turn to zero to prevent loop
        grid[i][j] = '0';

        numIslands(grid, i + 1, j);
        numIslands(grid, i - 1, j);
        numIslands(grid, i, j + 1);
        numIslands(grid, i, j - 1);

        return 1;

    }

    private static int optimized1(char[][] grid) {
/*        
Time O(nm)^2
 Space O(1)
*/
        int tot = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                tot += numIslands(grid, i, j);
            }
        }

        return tot;

    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new char[][]{
                        new char[]{'1', '1', '1', '1', '0'},
                        new char[]{'1', '1', '0', '1', '0'},
                        new char[]{'1', '1', '0', '0', '0'},
                        new char[]{'0', '0', '0', '0', '0'}
                })


        );

    }

    @NotNull
    private static TestCase computeTestCase(char[][] grid) {
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
    
    