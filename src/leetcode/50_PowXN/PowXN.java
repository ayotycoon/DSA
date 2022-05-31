import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PowXN{
    // 50 "Pow(x, n)" https://leetcode.com/problems/powx-n

    private static double bruteForce(double x, int n){
    /*
    Time O(n)
     Space O(1)
    */
        if(x == 1) return 1d;
        if(x == 0) return 0d;
        boolean isNNeg = n <0;
        n = Math.abs(n);
        double ans = 1d;
        for(int i =0; i < n; i++)ans*=x;
        if(isNNeg) return 1/ans;
        return ans;
    }
    private static double optimized1(double x, int n, Map<Integer,Double> memo){
/*        
Time O(logN)
 Space O(logN)
*/

        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) return 1d;
        if(n == 1) return x;
        if(n == -1) return (double)(1/x);
        boolean isNNeg = n <0;
        double ans = optimized1(x, n/2,memo) * optimized1(x, n/2,memo);
        if((n%2) != 0){
            // is odd
            ans *= optimized1(x, isNNeg ? -1 : 1,memo);
        }
        memo.put(n,ans);
        return ans;


    }


    public static void main(String[] args) {

        new TestCaseExecutor(

                computeTestCase(34.00515d, -3 )

        );

    }

    @NotNull
    private static TestCase computeTestCase(double x, int n) {
        return new TestCase(
                "%s | %s".formatted(
                        x+"",n+""
                ),

                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(x,n)+"";
                }),
                new TestCaseFunctionGroup("optimized1", () -> {

                    return optimized1(x,n, new HashMap<>())+"";
                })


        );
    }




}
    
    