package bitWise;

import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;

public class Applications {

    private static boolean isPowerOfTwo(int num){

        if(num > 0 && (num & (num - 1)) == 0){
            return true;
        }

        return false;
    }






    public static void main(String[] args) {

        int isPowerOfTwo = 32;
        new TestCaseExecutor(
                new TestCase(
                        "%d ".formatted(
                                isPowerOfTwo
                        ),

                        new TestCaseFunctionGroup("isPowerOfTwo", () -> {
                            var ans = isPowerOfTwo(isPowerOfTwo);
                            return String.valueOf(ans);
                        })

                )


        );

    }

}
