package bitWise;

import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

public class Shifting {
    /*
    num/(2^no of shifts)
     */
    private static String rightShift(int num, int howManyShifts){
        String binaryA = Integer.toBinaryString(num);

        int ans = num>>howManyShifts;
        return "%d[%s] >> %d = %d[%s]".formatted(num,binaryA,howManyShifts, ans,Integer.toBinaryString(ans)) ;
    }

/*
num*(2^no of shifts)
 */

    private static String leftShift(int num, int howManyShifts){
        String binaryA = Integer.toBinaryString(num);

        int ans = num<<howManyShifts;
        return "%d[%s] << %d = %d[%s]".formatted(num,binaryA,howManyShifts, ans,Integer.toBinaryString(ans)) ;
    }






    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(15, 2)
                //  computeTestCase(new int[]{1, 2, 3,4,5},3)


        );

    }

    @NotNull
    private static TestCase computeTestCase(int num, int howManyShifts) {
        return new TestCase(
                "%d | %d".formatted(
                        num,howManyShifts
                ),

                new TestCaseFunctionGroup("RightShift(>>)", () -> {
                    var ans = rightShift(num, howManyShifts);
                    return ans;
                }),               new TestCaseFunctionGroup("LeftShift(<<)", () -> {
                    var ans = leftShift(num, howManyShifts);
                    return ans;
                })

        );
    }
}
