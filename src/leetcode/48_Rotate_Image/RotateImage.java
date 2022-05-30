import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateImage {
    // 48 Rotate Image https://leetcode.com/problems/rotate-image


    private static void bruteForce(int[][] matrix) {
        /*
Time O(N*N)
 Space O(N*N)
*/
        int[][] matrix2 = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int rev = matrix.length - 1 - i;

            for (int j = 0; j < row.length; j++) {


                matrix2[j][rev] = matrix[i][j];

            }
        }


        for (int i = 0; i < matrix2.length; i++) {
            int[] row = matrix2[i];
            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = matrix2[i][j];
            }
        }

    }

    private static void optimized1(int[][] matrix) {
/*
Time O(N*N)
 Space O(1)
*/
        // 9999099990

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < row.length; j++) {
                boolean isNeg = matrix[i][j] <0;
                matrix[i][j] = Math.abs(matrix[i][j]) * 1000000;
                if(isNeg){
                    matrix[i][j]+=100000;
                }
                //1000_0000
                //prev_current


            }
        }

        // add exchanged
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int rev = matrix.length - 1 - i;

            for (int j = 0; j < row.length; j++) {


                int curr = matrix[i][j] / 100000;

                matrix[j][rev] += curr;


            }
        }


        // replace with prev
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < row.length; j++) {
                // 9999099990
                // 99990
                matrix[i][j] = matrix[i][j] - ((matrix[i][j] / 100000) * 100000);
                // check if last digit is 1, if it is then change it to -
                int diff = matrix[i][j] - (matrix[i][j] / 10) * 10;

                matrix[i][j] = (diff == 1 ? -1 : 1) * (matrix[i][j]/10);
            }
        }

    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[][]{
                        new int[]{-1000, -2, -3},
                        new int[]{4, -5, 6},
                        new int[]{7, 8, 9}
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
                    int[][] matrix2 = new int[matrix.length][matrix.length];
                    for (int i = 0; i < matrix.length; i++) {
                        int[] row = matrix[i];
                        for (int j = 0; j < row.length; j++) {
                            matrix2[i][j] = matrix[i][j];
                        }
                    }
                    bruteForce(matrix2);
                    return Arrays.stream(matrix2).map(a -> Arrays.toString(a)).collect(Collectors.toList()).toString();
                }),
                new TestCaseFunctionGroup("optimized1", () -> {
                    int[][] matrix2 = new int[matrix.length][matrix.length];
                    for (int i = 0; i < matrix.length; i++) {
                        int[] row = matrix[i];
                        for (int j = 0; j < row.length; j++) {
                            matrix2[i][j] = matrix[i][j];
                        }
                    }
                    optimized1(matrix2);
                    return Arrays.stream(matrix2).map(a -> Arrays.toString(a)).collect(Collectors.toList()).toString();
                })


        );
    }


}
    
    /*

[[12,29,28,18,14,9,43],[23,45,44,-9969,42,18,39],[35,33,14,45,3,9,3],[32,44,23,11,23,-1,33],[22,20,40,8,12,40,37],[39,0,24,9999,14,22,20],[8,45,13,31,32,38,14]]




[[12,29,28,18,14,9,43],[23,45,44,31,42,18,39],[35,33,14,45,3,9,3],[32,45,23,11,23,-1,33],[22,20,40,8,12,40,37],[39,0,24,-1,14,22,20],[8,45,13,31,32,38,14]]
     */