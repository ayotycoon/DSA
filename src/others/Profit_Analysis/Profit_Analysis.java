package Profit_Analysis;
/*

A data analyst wants to analyze the performance of his
investments in the HackShare stock. The PL of his portfolio
is represented by an array pn/where pnl[i] represents the
profit earned in the ith month that can possibly be negative
indicating a loss.

Given the pnl array of n months, find the maximum net profit
(sum of profits) gained in any contiguous segment of months
i.e. a subarray of months such that the number of months in
the segment does not exceed a given integer k.

Example
Given n=6, pnl= [-3, 4, 3, -2, 2, 5] k=4
 */


import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Profit_Analysis {

    private static int bruteForce(int[] pnl, int k) {
    /*
    Time O(N^2)
     Space O(1)
    */
        int max = 0;

        for (int i = 0; i < pnl.length; i++) {
            int temp = 0;
            for (int j = i; j < i + k; j++) {
                if(j >= pnl.length) break;
                temp += pnl[j];
            }
            max = Math.max(max, temp);
        }


        return max;

    }

    private static int optimized(int[] pnl, int k) {
    /*
    Time O(N)
     Space O(1)
    */
        int max;
        int state = 0;

        for (int j = 0; j < k; j++) {
            if(j >= pnl.length) return state;
            state += pnl[j];
        }
        max = state;

        for(int i = 1; i < pnl.length; i++){
            state -= pnl[i-1];

            if(i+k-1 >= pnl.length) break;
            state += pnl[i+k-1];
            max = Math.max(max, state);

        }
        return max;
    }




    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{9, 4, 3, -2, 2, 5}, 4, 14),
                computeTestCase(new int[]{-3, 4, 3, -2, 2, 5}, 4, 8),
                computeTestCase(new int[]{-3, 4, 3, -2, 2, 5,0,0,0}, 4, 8)


        );

    }


    @NotNull
    private static TestCase computeTestCase(int[] nums, int k, int output) {
        return new TestCase(
                "%s".formatted(
                        Arrays.toString(nums)
                ),
                "%s".formatted(
                        ""+output
                ),

                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(nums,k);
                    return ans + "";
                }),

                new TestCaseFunctionGroup("optimized", () -> {
                    var ans = optimized(nums,k);
                    return ans + "";
                })
        );
    }
}
