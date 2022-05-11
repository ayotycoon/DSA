import java.util.HashMap;
import java.util.Stack;

public class LongestCommonPrefix {
    // 14 Longest Common Prefix https://leetcode.com/problems/longest-common-prefix

    private static int bruteForce(String str) {
        return 0;
    }

    private static String optimized1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;


    }

    public static void main(String[] args) {


        String optimized1Solution = optimized1(new String[]{"dog", "racecar", "car"});


        System.out.println(optimized1Solution);

    }


}
    
    