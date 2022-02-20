import common.Pair;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    // 10 Regular Expression Matching https://leetcode.com/problems/regular-expression-matching

    private static void bruteForce() {


    }

    private static boolean optimized1(String s, String p) {
        List<Integer[]> group = new ArrayList<>();
        // group string
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                Integer[] groupItem = group.get(group.size() - 1);
                groupItem[1]++;
            } else {
                Integer[] groupItem = new Integer[]{Integer.valueOf(c), 1};
                group.add(groupItem);
            }
            prev = c;
        }
        // reset prev
        prev = ' ';
        // iterate through the pattern
        int groupIndex = 0;
        for (int i = 0; i < p.length(); i++) {
            char patternChar = p.charAt(i);
            if (groupIndex >= group.size()) {
                while (i < p.length()){
                    if (p.charAt(i) == '*' || (i + 1 < p.length() && p.charAt(i + 1) == '*')) {


                    }else return false;
                    i++;
                }
                return true;
            }
            Integer[] groupItem = group.get(groupIndex);
            char groupChar = (char) groupItem[0].intValue();
            if (patternChar == '.' || patternChar == groupChar) {
                groupItem[1]--;
            } else if (patternChar == '*' && prev != ' ') {
                int prevCharAhead = getPrevCharAhead(p, prev, i + 1);

                groupItem[1] = prevCharAhead;
            } else if (patternChar != groupChar && i + 1 < p.length() && p.charAt(i + 1) == '*') {
                i++;
                continue;

            } else {
                return false;
            }
            prev = groupChar;
            if (groupItem[1] < 0) return false;
            if (groupItem[1] == 0) groupIndex++;
        }


        return group.get(group.size() - 1)[1] == 0;
    }

    private static int getPrevCharAhead(String p, char c, int i) {

        int num = 0;
        while (i < p.length() && c == p.charAt(i)) {
            num++;
            i++;
        }
        return num;

    }

    public static void main(String[] args) {


        for (Pair<String, String> s : new Pair[]{

//                new Pair<>("a", "."),
//                new Pair<>("a", "a"),
//                new Pair<>("aa", "a"),
//                new Pair<>("aa", "a*"),
//                new Pair<>("aa", ".*"),
//                new Pair<>("baaaa", "ba*a"),
//                new Pair<>("baaaa", "b.*a"),
//                new Pair<>("aabb", "a*b*"),
//                new Pair<>("aabb", ".*.*"),
                new Pair<>("ab", ".*c"),
                new Pair<>("ab", "ab*"),
                new Pair<>("ab", "abc*"),
                new Pair<>("aaa", "ab*a*c*a"),

        }) {
            boolean optimized1Solution = optimized1(s.v1, s.v2);


            System.out.println(s + " => " + optimized1Solution);

        }

    }


}
    
    