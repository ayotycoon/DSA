import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateImage{
    // 48 Rotate Image https://leetcode.com/problems/rotate-image


    private static void bruteForce(int[][] matrix) {
        /*
Time O(N*N)
 Space O(N*N)
*/
        int[][] matrix2 = new int[matrix.length][matrix[0].length];

        for(int i =0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int rev = matrix.length - 1 - i;

            for (int j = 0; j < row.length; j++) {


                matrix2[j][rev] = matrix[i][j];

            }
        }


        for(int i =0; i < matrix2.length; i++) {
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
        for(int i =0; i < matrix.length; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < row.length; j++) {

                matrix[i][j] = matrix[i][j] * 10000;
                //1000_0000
                //prev_current


            }
        }

// add exchanged
        for(int i =0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int rev = matrix.length - 1 - i;

            for (int j = 0; j < row.length; j++) {


                matrix[j][rev] += matrix[i][j]/10000;

            }
        }

        System.out.println(Arrays.stream(matrix).map(a -> Arrays.toString(a)).collect(Collectors.toList()).toString());

        // replace with prev
        for(int i =0; i < matrix.length; i++) {
            int[] row = matrix[i];

            for (int j = 0; j < row.length; j++) {

                matrix[i][j] = matrix[i][j]  - ((matrix[i][j] / 10000)  * 10000);

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
                    int[][] matrix2 = new int[matrix.length][matrix.length];
                    for(int i =0; i < matrix.length; i++) {
                        int[] row = matrix[i];
                        for (int j = 0; j < row.length; j++) {
                            matrix2[i][j] = matrix[i][j];
                        }
                    }
                    bruteForce(matrix2);
                    return Arrays.stream(matrix2).map(a -> Arrays.toString(a)).collect(Collectors.toList()).toString();
                }) ,
                new TestCaseFunctionGroup("optimized1", () -> {
                    int[][] matrix2 = new int[matrix.length][matrix.length];
                    for(int i =0; i < matrix.length; i++) {
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
    
    