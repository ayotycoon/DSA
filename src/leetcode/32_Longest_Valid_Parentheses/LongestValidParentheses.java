import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Stack;

public class LongestValidParentheses {
    // 32 Longest Valid Parentheses https://leetcode.com/problems/longest-valid-parentheses

    private static boolean isValid(String s, int j ,int k){
        if((k-j+1) %2 != 0) return false;
        Stack<Character> stack= new Stack<Character>();

        for(int i =j; i <= k; i++){
            Character c = s.charAt(i);



            if(c == '(') {
                stack.add(c);
continue;
            }

            if(c == ')') {
                if(stack.isEmpty() ) {
                    return false;
                }
                if(stack.pop() !='('){
                    return false;
                }
continue;
            }




        }


        return stack.isEmpty();

    }


    private static int bruteForce(String s) {
/*        
Time O(N3)
 Space O(N)
*/
        int max = 0;
        for(int i=0; i < s.length();i++){
            for(int j=i+1; j < s.length();j++){
                if(isValid(s,i,j)){
                    max = Math.max(max, j-i+1);
                }

            }
        }


        return max;
    }

    private static int optimized1(String s) {
/*        
Time O(N)
 Space O(N)
*/
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
                if (c == '(') {
                  stack.push(i);
                }else{
                    stack.pop();
                    if(stack.isEmpty())stack.add(i);
                    else max=Math.max(max, i-stack.peek());

            }


        }

        return max;

    }


    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase("()()(()"),
                computeTestCase(")()())"),
                computeTestCase("())()")


        );

    }


    @NotNull
    private static TestCase computeTestCase(String s) {
        return new TestCase(
                "%s ".formatted(
                        s
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(s) + "";

                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    return optimized1(s) + "";
                })



        );
    }


}
    
    