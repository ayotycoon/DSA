import utils.Permutate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {
    // 31 Next Permutation https://leetcode.com/problems/next-permutation

    private static void bruteForce() {
/*        
Time O(1)
 Space O(1)
*/


    }

    private static List<List<Integer>> optimized1(int[] nums) {
/*        
Time O(1)
 Space O(1)
*/
        LinkedList<List<Integer>> list = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        list.add(new ArrayList<>());



        return ans;
    }


    public static void main(String[] args) {

        // bruteForce();
        // optimized1();

        System.out.println(Permutate.getAll(new String[]{"1", "2", "3","4"}));

    }


}
    
    