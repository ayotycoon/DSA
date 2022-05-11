import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {
    // 17 Letter Combinations of a Phone Number https://leetcode.com/problems/letter-combinations-of-a-phone-number
    private static final Map<Character, Character[]> map = new HashMap<>();
    private static final Map<Integer, List<String>> memo = new HashMap<>();

    private static void bruteForce() {


    }

    private static List<String> optimized1(String digits, int strIndex) {
        if(digits.equals(""))return new ArrayList<>();
        List<String> ans = new ArrayList<>();

        if (memo.containsKey(strIndex)) return memo.get(strIndex);
        if (strIndex == digits.length()) {

            ans.add("");
            return ans;
        }


        for (int i = strIndex; i < digits.length(); i++) {

            char curr = digits.charAt(i);
            Character[] values = map.get(curr);

            for (int j = 0; j < values.length; j++) {

                var x = optimized1(digits, i + 1);
                int finalJ = j;
                var a = x.stream().map(y -> values[finalJ] + y).collect(Collectors.toList());
                ans.addAll(a);
            }
            if (i < digits.length() - 1) break;
        }
        memo.put(strIndex, ans);
        return ans;
    }

    private static List<String> optimized2(String digits) {
        /*
        Time O(N2)
        Space O(M+N)
         */
        if(digits.equals("")) return new ArrayList<>();
        LinkedList<String> list= new LinkedList<>();
        list.add("");


        for (int i = 0; i < digits.length(); i++) {

            char curr = digits.charAt(i);
            Character[] values = map.get(curr);

            while(list.peek().length() == i){
                String x = list.remove();

                for(Character value: values){
                    list.add(x+value);
                }

            }


        }

        return list;

    }
    public static void main(String[] args) {
        String digits = "23";
        map.put('1', new Character[]{});
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});

        System.out.println(optimized1(digits, 0));
        System.out.println(optimized2(digits));

    }


}
    
    