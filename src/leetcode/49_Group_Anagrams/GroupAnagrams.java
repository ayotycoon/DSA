import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams{
    // 49 Group Anagrams https://leetcode.com/problems/anagrams

    private static List<List<String>> bruteForce(String[] strs){
/*        
Time O((N * MLogM)
 Space O(M*N)
*/
        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedS = str.equals("") ? "" : Arrays.toString(charArray);
            if(!map.containsKey(sortedS)) map.put(sortedS, new ArrayList<>());
            map.get(sortedS).add(str);
        }

       return map.values().stream().collect(Collectors.toList());
    }
    private static List<List<String>> optimized1(String[] strs){
/*        
Time O(1)
 Space O(1)
*/

            return new ArrayList<>();
    }


    public static void main(String[] args) {

        new TestCaseExecutor(

                computeTestCase(new String[]{
                        "eat","tea","tan","ate","nat","bat"
                }),
                computeTestCase(new String[]{
                        ""
                })

        );

    }

    @NotNull
    private static TestCase computeTestCase(String[] strs) {
        return new TestCase(
                "%s".formatted(
                         Arrays.toString(strs)
                ),

                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(strs).toString();
                }),
                new TestCaseFunctionGroup("optimized1", () -> {

                    return optimized1(strs).toString();
                })


        );
    }


}
    
    