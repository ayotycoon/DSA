import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;
import utils.Permutate;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringWithConcatenationOfAllWords {
    // 30 Substring with Concatenation of All Words https://leetcode.com/problems/substring-with-concatenation-of-all-words


    private static List<Integer> bruteForce(String s, String[] words) {
        /*
            Time O((N^N)M)
            Space O(1)
        */

        List<String> possibilities = Permutate.getAll(words);

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

//    private static List<Integer> optimized1(String s, String[] words, int stringIndex) {
//    /*
//     Time O(1)
//     Space O(1)
//    */
//
//
//        List<Integer> ans = new ArrayList<>();
//        if (words.length == 0) return ans;
//        if (stringIndex >= s.length()) return null;
//
//
//        for (int i = 0; i < words.length; i++) {
//            var curr = words[i];
//            if (s.substring(stringIndex).startsWith(curr)) {
//
//                String[] wordsMod = new String[words.length - 1];
//                int v = 0;
//                for (int j = 0; j < words.length; j++) {
//                    if (i == j) continue;
//                    wordsMod[v] = words[j];
//                    v++;
//                }
//                var temp = optimized1(s, wordsMod, stringIndex + curr.length());
//                if (temp != null && words.length == 2) {
//                    ans.addAll(temp);
//                }
//            }
//        }
//
//        var temp = words.length != 0 ? optimized1(s, words, stringIndex + words[0].length()) : null;
//        if (temp != null && words.length == 2) ans.addAll(temp);
//
//
//        return ans;
//    }
//
//    private static List<Integer> optimized1(String s, String[] words) {
//        return optimized1(s, words, 0);
//
//    }

    private static List<Integer> optimized2(String s, String[] words) {
            /*
     Time O(N*M*len)
     Space O(M=N)
    */
        Map<String, Integer> map = new HashMap();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> result = new ArrayList();
    
        int eachWordLength = words[0].length();
        for (int i = 0; i <= s.length() - (words.length * eachWordLength); i++) {
            Map<String, Integer> seen = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int nextIndexOfWord = i + j * eachWordLength;
                String nextWord = s.substring(nextIndexOfWord, nextIndexOfWord + eachWordLength);
                if (!map.containsKey(nextWord))break;
                seen.put(nextWord, seen.getOrDefault(nextWord, 0) + 1);
                if (seen.get(nextWord) > map.getOrDefault(nextWord, 0)) break;
                if (j + 1 == words.length) result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase("foothefoobarman", new String[]{"bar", "foo"})
//                computeTestCase("barfoothefoobarman", new String[]{"bar", "foo"})
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


//                new TestCaseFunctionGroup("optimized1", () -> {
//                    var ans = optimized1(s, words);
//                    return ans.toString();
//                }),
                new TestCaseFunctionGroup("optimized2", () -> {
                    var ans = optimized2(s, words);
                    return ans.toString();
                })
        );
    }


}
    
    