import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    // 3 Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters

    private static int bruteForce(String input) {
        /*
            Time O(m^2 )
            Space O(m)
         */
        if(input == null || input.length() == 0) return 0;
        int max = 1;
        for (int i = 0; i < input.length(); i++) {
            Set<Character> set = new LinkedHashSet();
            set.add(input.charAt(i));
            for (int j = i + 1; j < input.length(); j++) {
                char charJ = input.charAt(j);

                if (!set.contains(charJ)) {
                    set.add(charJ);
                }else {
                    if(set.size() < max) break;
                    max = set.size();
                    break;
                }

                if(j == input.length()-1){
                    if(set.size() < max) break;
                    max = set.size();
                    break;
                }

            }
        }
        return max;
    }

    private static int bruteForce2(String input) {
        /*
            Time O(m^2)
            Space O(m)
         */
        if(input == null || input.length() == 0) return 0;

        int j = 1;
        int max = 1;
        Map<Character,Integer> set = new LinkedHashMap<>();
        set.put(input.charAt(0),0);
        while(j < input.length()){
            char charJ = input.charAt(j);
            if(set.containsKey(charJ)){
                max = Math.max(max, set.size());
                j = set.get(charJ)+1;
                set = new LinkedHashMap();
                continue;

            }else {
                set.put(charJ,j);
            }
            j++;
        }
        max = Math.max(max, set.size());

        return max;
    }

    private static int optimized1(String input) {
        /*
            Time O(m)
            Space O(m)
         */
        if(input == null || input.length() == 0) return 0;

        int start = 0, max = 1;
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0;i<input.length();i++) {
            char ch = input.charAt(i);
            if (map.containsKey(ch)) {
                max = Math.max(max,i-start);
                int prevIndex = map.get(ch);
                start = Math.max(prevIndex+1, start);
            }
            map.put(ch, i);
        }
        max = Math.max(max,input.length()-start);

        return max;
    }

    public static void main(String[] args) {
        String input = "qdvilpdf";

        int bruteForceSolution = bruteForce(input);
        int bruteForce2Solution = bruteForce2(input);
        int optimized1Solution = optimized1(input);

        System.out.println(bruteForceSolution);
        System.out.println(bruteForce2Solution);
        System.out.println(optimized1Solution);

    }


}
    
    