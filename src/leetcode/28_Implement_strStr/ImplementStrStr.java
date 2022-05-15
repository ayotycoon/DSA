
import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ImplementStrStr {
    // 28 Implement strStr() https://leetcode.com/problems/implement-strstr

    private static int bruteForce(String haystack, String needle) {
/*
Time O(1)
 Space O(1)
*/

        if (needle.length() == 0) return 0;

        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() > haystack.length()) return -1;

                if (needle.equals(haystack.substring(i, i + needle.length()))) {
                    return i;
                }
            }
        }
        return -1;


    }

    private static int optimized1(String haystack, String needle) {
/*
Time O(1)
 Space O(1)
*/
        if (needle.length() == 0) return 0;

        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() > haystack.length()) return -1;

                if (needle.equals(haystack.substring(i, i + needle.length()))) {
                    return i;
                }
            }
        }
        return -1;

    }


    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase("hello","ll"),
                computeTestCase("aaaaa","bba")


        );

    }

    @NotNull
    private static TestCase computeTestCase(String haystack, String needle) {
        return new TestCase(
                "%s | %s".formatted(
                         haystack,  needle
                ),


                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(haystack,  needle);
                    return ans +"";
                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(haystack,  needle);
                    return ans +"";
                })
        );
    }




}

