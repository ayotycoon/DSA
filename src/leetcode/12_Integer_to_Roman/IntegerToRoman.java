import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class IntegerToRoman{
    // 12 Integer to Roman https://leetcode.com/problems/integer-to-roman

    private static void bruteForce(){
/*        
Time O(1)
 Space O(1)
*/

    }
    private static String optimized1(int num){
        Map<Integer,String> map= new LinkedHashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        List<Map.Entry<Integer,String>> set =  map.entrySet().stream().collect(Collectors.toList());

        StringBuilder res = new StringBuilder();

        for(int i = set.size()-1; i>=0; i--){

            int ref = set.get(i).getKey();

            int diff = num/ref;
            // if theres perfect division
            if(diff != 0){
                for(int j=0; j < diff; j++){
                    res.append(set.get(i).getValue());
                }
                num = num%ref;
            }



        }

        return res.toString();


    }

    public static void main(String[] args){

        String optimized1Solution = optimized1(49);


        System.out.println(optimized1Solution);

    }


}
    
    