import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

public class CountAndSay{
    // 38 Count and Say https://leetcode.com/problems/count-and-say

    private static String bruteForce(int n){
/*        
Time O(1)
 Space O(1)
*/
return "";
            
    }
    private static String optimized1(int n){
/*        
Time O(N)
 Space O(N)
*/

        if(n == 1) return "1";

        String prev = optimized1(n-1);
        StringBuilder sb = new StringBuilder();

        char curr = 'x';
        int index = 0;
        for(int i = 0; i < prev.length();i++){
            curr = prev.charAt(i);
            if(i == 0){
                index++;
                if(i == prev.length()-1){
                    sb.append(index+""+curr);
                }
                continue;
            }
            if(prev.charAt(i) == prev.charAt(i-1)){
                index++;
            }else {
                sb.append(index+""+prev.charAt(i-1));
                index = 1;

            }

            if(i == prev.length()-1){
                sb.append(index+""+curr);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(1),
                computeTestCase(4)


        );

    }


    @NotNull
    private static TestCase computeTestCase(int n) {
        return new TestCase(
                "%d".formatted(
                        n
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(n);

                }),

                new TestCaseFunctionGroup("optimized1", () -> {
                    return optimized1(n);
                })


        );
    }



}
    
    