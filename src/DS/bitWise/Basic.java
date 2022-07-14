package bitWise;

import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

public class Basic {

    private static String ANDOperator(int a, int b){
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);

        int ans = a&b;
        return "%d[%s] & %d[%s] = %d[%s]".formatted(a,binaryA,b,binaryB, ans,Integer.toBinaryString(ans)) ;
    }


    private static String OROperator(int a, int b){
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);

        int ans = a|b;
        return "%d[%s] | %d[%s] = %d[%s]".formatted(a,binaryA,b,binaryB, ans,Integer.toBinaryString(ans)) ;
    }

    private static String XOROperator(int a, int b){
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);

        int ans = a^b;
        return "%d[%s] ^ %d[%s] = %d[%s]".formatted(a,binaryA,b,binaryB, ans,Integer.toBinaryString(ans)) ;
    }

    private static String OneCompliment(int a){
        String binaryA = Integer.toBinaryString(a);

        int ans = ~a;
        return "~%d[%s]  = %d[%s]".formatted(a,binaryA, ans,Integer.toBinaryString(ans)) ;
    }




    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(15, 27)
                //  computeTestCase(new int[]{1, 2, 3,4,5},3)


        );

    }

    @NotNull
    private static TestCase computeTestCase(int a, int b) {
        return new TestCase(
                "%d | %d".formatted(
                        a,b
                ),

                new TestCaseFunctionGroup("ANDOperator(&)", () -> {
                    var ans = ANDOperator(a, b);
                    return ans;
                }),
                new TestCaseFunctionGroup("OROperator(|)", () -> {
                    var ans = OROperator(a, b);
                    return ans;
                }),
                new TestCaseFunctionGroup("XOROperator(^)", () -> {
                    var ans = XOROperator(a, b);
                    return ans;
                }) ,
                new TestCaseFunctionGroup("OneCompliment(~)", () -> {
                    var ans = OneCompliment(a);
                    return ans;
                })
        );
    }
}
