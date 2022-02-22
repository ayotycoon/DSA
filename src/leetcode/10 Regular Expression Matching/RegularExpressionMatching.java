import common.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RegularExpressionMatching {
    // 10 Regular Expression Matching https://leetcode.com/problems/regular-expression-matching

    private static void bruteForce() {


    }

    private static List<Integer[]> grouper(String s) {
        List<Integer[]> group = new ArrayList<>(s.length());
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
        return group;
    }
    private static boolean optimized1(List<Integer[]> _groupS,List<Integer[]> groupP,int groupIndexS,int groupIndexP,char prevMatchingS) {

      if(groupIndexS == _groupS.size() && groupIndexP == groupP.size()-1 &&  _groupS.get(_groupS.size() - 1)[1] == 0) return true;
      if(groupIndexS >= _groupS.size() || groupIndexP >= groupP.size()) return false;

        List<Integer[]> groupS = _groupS.stream().map(s -> Arrays.copyOf(s,s.length)).collect(Collectors.toList());
        boolean possibility1 = false;
        boolean possibility2 = false;
        boolean possibility3 = false;
        boolean possibility4 = false;


            var patternGroup = groupP.get(groupIndexP);
            char patternChar = (char)patternGroup[0].intValue();

            Integer[] stringGroup = groupS.get(groupIndexS);
            char stringChar = (char) stringGroup[0].intValue();

            if (patternChar == '.' || patternChar == stringChar) {
                // if the character is the last one in the string or the next character is not a *
                if(groupIndexS == groupS.size()-1 || (char)groupS.get(groupIndexS)[0].intValue() != '*'){
                    stringGroup[1]--;
                    patternGroup[1]--;
                    possibility1 =  optimized1(groupS,groupP,stringGroup[1] == 0 ? groupIndexS+1 : groupIndexS,patternGroup[1] == 0 ? groupIndexP+1 : groupIndexP, stringChar);
                }else{
                    // if the next character is a *
                    possibility1 =  optimized1(groupS,groupP, groupIndexS+1 , groupIndexP+1 , stringChar);
                }


            } else if (patternChar == '*' && prevMatchingS != ' ') {

                int prev = stringGroup[1];
                // check if theres a previous char forward. something lime |a*aa|
                if(groupIndexP + 1 < groupP.size()){
                    var x = groupP.get(groupIndexP+1);
                    if((char) x[0].intValue() == prevMatchingS && x[1] != 0) {
                        stringGroup[1] = x[1];
                        possibility2 = optimized1(groupS,groupP,stringGroup[1] == 0 ? groupIndexS+1 : groupIndexS,groupIndexP+1, prevMatchingS);
                    }
                }
                stringGroup[1] = prev;
                possibility3 = optimized1(groupS,groupP,stringGroup[1] == 0 ? groupIndexS+1 : groupIndexS,groupIndexP+1, prevMatchingS);

            } else if (patternChar != stringChar && groupIndexP + 1 < groupP.size() && (char)groupP.get(groupIndexP + 1)[0].intValue() == '*') {
// skip move forwad
                possibility4 = optimized1(groupS,groupP,groupIndexS,groupIndexP+1, prevMatchingS);

            }

                return possibility1 || possibility2 || possibility3 || possibility4;



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
//                new Pair<>("ab", ".*c"),
//                new Pair<>("ab", "ab*"),
//                new Pair<>("ab", "abc*"),
                new Pair<>("aaa", "ab*a*c*a"),

        }) {
            var groupS = grouper(s.v1);
            var groupP = grouper(s.v2);
            boolean optimized1Solution = optimized1(groupS, groupP,0,0,' ');


            System.out.println(s + " => " + optimized1Solution);

        }

    }


}
    
    