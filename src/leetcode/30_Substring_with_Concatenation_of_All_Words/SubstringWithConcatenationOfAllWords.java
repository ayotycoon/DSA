import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringWithConcatenationOfAllWords {
    // 30 Substring with Concatenation of All Words https://leetcode.com/problems/substring-with-concatenation-of-all-words


    private static List<String> permutate(String[] words) {
        List<String> ans = new ArrayList<>();
        if (words.length == 0) {
            ans.add("");
            return ans;
        }
        for (int i = 0; i < words.length; i++) {
            var curr = words[i];
            String[] wordsMod = new String[words.length - 1];

            int v = 0;

            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                wordsMod[v] = words[j];
                v++;
            }


            var temp = permutate(wordsMod).stream().map(x -> curr + x).collect(Collectors.toList());
            ans.addAll(temp);

        }
        return ans;
    }

    private static List<Integer> bruteForce(String s, String[] words) {
        /*
            Time O((N^N)M)
            Space O(1)
        */

        List<String> possibilities = permutate(words);

        var ans = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++) {

            for (String possibility : possibilities) {
                if (possibility.length() + i >= s.length()) break;
                if (s.startsWith(possibility, i)) {
                    ans.add(i);
                    break;
                }
            }

        }


        return ans;
    }

    private static List<Integer> optimized1(String s, String[] words, int stringIndex) {
    /*
    Time O(1)
     Space O(1)
    */

        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) return ans;
        if (stringIndex >= s.length()) return null;


        for (int i = 0; i < words.length; i++) {
            var curr = words[i];
            if (s.substring(stringIndex).startsWith(curr)) {

                String[] wordsMod = new String[words.length - 1];
                int v = 0;
                for (int j = 0; j < words.length; j++) {
                    if (i == j) continue;
                    wordsMod[v] = words[j];
                    v++;
                }
                var temp = optimized1(s, wordsMod, stringIndex + curr.length());
                if (temp != null && words.length == 2) {
                    temp.add(0, stringIndex);
                    System.out.println(temp);
                    System.out.println(Arrays.toString(words));
                    System.out.println("\n");
                    ans.addAll(temp);
                }
            }
        }

            var temp = words.length != 0 ? optimized1(s, words, stringIndex + words[0].length()): null;
            if(temp!= null && words.length == 2) ans.addAll(temp);



        return ans;
    }

    private static List<Integer> optimized1(String s, String[] words) {
        return optimized1(s, words, 0);

    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase("barfoothefoobarman", new String[]{"bar", "foo"})
//                computeTestCase("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}),
//                computeTestCase("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"})


        );

    }

    @NotNull
    private static TestCase computeTestCase(String s, String[] words) {
        return new TestCase(
                "%s | %s".formatted(
                        s, Arrays.toString(words)
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(s, words);
                    return ans.toString();
                }),


                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(s, words);
                    return ans.toString();
                })
        );
    }


}
    
    