import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MultiplyStrings {
    // 43 Multiply Strings https://leetcode.com/problems/multiply-strings


    private static StringBuilder strAdd(StringBuilder total, StringBuilder sb2, int ran) {
//(N+M)
        StringBuilder ans = new StringBuilder();
        while (ran > 0) {
            sb2.insert(0, "0");
            ran--;
        }


        if (total.length() < sb2.length()) {
            StringBuilder temp = total;
            total = sb2;
            sb2 = temp;
        }


        int remainder = 0;
        for (int i = 0; i < total.length(); i++) {
            int add = Character.getNumericValue(total.charAt(i)) + (i >= sb2.length() ? 0 : Character.getNumericValue(sb2.charAt(i)));

            add += remainder;

            int x = add / 10;
            add = add - ((x) * 10);
            remainder = x;

            ans.append(add);


        }
        if (remainder != 0) ans.append(remainder);


        return ans;
    }

    private static String bruteForce(String num1, String num2) {
/*
Time O(N*M* (N+M))
 Space O(N+M)
*/
        if(num1.equals("0") || num2.equals("0")) return "0";
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int remainder = 0;
        StringBuilder total = new StringBuilder();
        int ran = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {

                int multiply = Character.getNumericValue(num2.charAt(i)) * Character.getNumericValue(num1.charAt(j));
                multiply += remainder;
                int x = multiply / 10;
                multiply = multiply - ((x) * 10);
                remainder = x;
                sb.append(multiply);

            }
            if (remainder != 0) {
                sb.append(remainder);
                remainder = 0;
            }
            total = strAdd(total, sb, ran);
            ran++;
        }

        return total.reverse().toString();
    }

    private static String optimized1(String num1, String num2) {
/*        
Time O(1)
 Space O(1)
*/

        return "";
    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase("100000000080000000", "2")


        );

    }


    @NotNull
    private static TestCase computeTestCase(String num1, String num2) {
        return new TestCase(
                "%s | %s".formatted(
                        num1, num2
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(num1, num2) + "";

                }),


                new TestCaseFunctionGroup("optimized2", () -> {
                    return optimized1(num1, num2) + "";
                })


        );
    }


}
    
    