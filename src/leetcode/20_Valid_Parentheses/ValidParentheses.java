import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses{
    // 20 Valid Parentheses https://leetcode.com/problems/valid-parentheses
    private static Map<Character, Character> inverseMap = new HashMap<>();

    private static boolean bruteForce(String s){

            return false;
    }
    private static boolean optimized1(String s){
        if(s.length() %2 != 0) return false;
        Stack<Character> stack= new Stack<Character>();

        for(int i =0; i < s.length(); i++){
            Character c = s.charAt(i);
            boolean isOpen = false;

            if(c == '{' || c == '[' || c == '(') isOpen = true;
            if(isOpen) {
                stack.add(c);

            }else {
                if(stack.isEmpty() || inverseMap.get(stack.pop()) != c) return false;
            }


        }


        return stack.isEmpty();

    }

    public static void main(String[] args){
        inverseMap.put('(',')');
        inverseMap.put('[',']');
        inverseMap.put('{','}');


// if i pop the stack and i find a closed bracket, render it invalid
        inverseMap.put(')','*');
        inverseMap.put(']','*');
        inverseMap.put('}','*');

        new TestCaseExecutor(
                computeTestCase("()", 0,1),
                computeTestCase("({})", 0,3),
                computeTestCase("}{}}", 0,3),
                computeTestCase("}}}", 0,2),
                computeTestCase("[({(())}[()])]", 0,13)


        );

    }

    @NotNull
    private static TestCase computeTestCase(String string, int i, int j) {
        return new TestCase(
                "%s ".formatted(
                        string
                ),

/*
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(string);
                    return String.valueOf(ans);
                }),
*/
                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(string);
                    return String.valueOf(ans);
                })
        );
    }

}
    
    