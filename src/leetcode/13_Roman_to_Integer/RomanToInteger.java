import java.util.HashMap;
import java.util.Stack;

public class RomanToInteger{
    // 14 Longest Common Prefix https://leetcode.com/problems/longest-common-prefix

    private static int bruteForce(String str){
        return 0;
    }

    private static int optimized1(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        Stack<Integer> s = new Stack<Integer>();

        int i =0;
        for(char c: str.toCharArray()){
            if(i == 0){
                s.add(map.get(c));
                i++;
                continue;
            }

            if(map.get(c) > map.get(str.charAt(i-1))){

                Integer diff = map.get(c) - s.pop();
                s.add(diff);
            }else {
                s.add(map.get(c));
            }

            i++;
        }

        int tot = 0;
        while(!s.isEmpty()){
            tot+= s.pop();
        }

        return tot;

    }

    public static void main(String[] args){

        int bruteForceSolution = bruteForce("XI");
        int optimized1Solution = optimized1("XI");


        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);

    }


}
    
    