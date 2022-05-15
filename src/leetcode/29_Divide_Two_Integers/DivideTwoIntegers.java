import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class DivideTwoIntegers {
    // 29 Divide Two Integers https://leetcode.com/problems/divide-two-integers

    private static int bruteForce(int dividend, int divisor) {
/*        
Time O(1)
 Space O(1)
*/

        if (divisor == 1) return dividend;
        int ans = 0;
        boolean isAnsPositive = true;
        if (dividend < 0 && divisor > 0) {
            while (dividend < 0) {
                if (dividend + divisor > 0) break;
                dividend += divisor;
                ans--;
                isAnsPositive = false;
            }
        } else if (dividend >= 0 && divisor < 0) {
            while (dividend > 0) {
                if (dividend + divisor < 0) break;
                dividend += divisor;
                ans--;
                isAnsPositive = false;
            }
        } else if (dividend < 0 && divisor < 0) {

            while (dividend < 0) {
                if (dividend - divisor > 0) break;
                dividend -= divisor;
                ans++;
                isAnsPositive = true;
            }
        } else if (dividend >= 0 && divisor > 0) {
            while (dividend > 0) {
                if (dividend - divisor < 0) break;
                dividend -= divisor;
                ans++;
                isAnsPositive = true;
            }
        }
        if (isAnsPositive && ans < 0) return Integer.MAX_VALUE;
        if (!isAnsPositive && ans > 0) return Integer.MIN_VALUE;


        return ans;
    }

    private static int optimized1(int dividend, int divisor) {
/*        
Time O(log N)
 Space O(1)
*/
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res=0;

        while(a-b >=0)
        {
            int x=0;
            while(a-(b<<1<<x) >= 0)
                x++;
            res += (1<<x);
            a -= (b<<x);
        }

        return (dividend>0 == divisor>0) ? res : -res;
    }


    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(-2147483648, 2)


        );

    }

    @NotNull
    private static TestCase computeTestCase(int dividend, int divisor) {
        return new TestCase(
                "%d | %d".formatted(
                        dividend, divisor
                ),


                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(dividend, divisor);
                    return ans + "";
                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(dividend, divisor);
                    return ans + "";
                })
        );
    }


}
    
    