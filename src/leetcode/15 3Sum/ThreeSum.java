import java.util.*;

public class ThreeSum{
    // 15 3Sum https://leetcode.com/problems/3sum

    private static void sort(List<Integer> item){
        // O(1)

        if(item.get(0) > item.get(1)){
            Collections.swap(item,0,1);
        }
        if(item.get(0) > item.get(2)){
            Collections.swap(item,0,2);
        }
        if(item.get(1) > item.get(2)){
            Collections.swap(item,1,2);
        }


    }

    private static List<List<Integer>> bruteForce(int[] nums){
        /**
         * time O(N3)
         * space O(N)
         */
        Map<String,List<Integer>> ans = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            for(int j=i+1; j < nums.length; j++){
                for(int k=j+1; k < nums.length; k++){
                    int numI = nums[i];
                    int numJ = nums[j];
                    int numK = nums[k];

                    int add = numI + numJ + numK;

                    if(add == 0){
                        List<Integer> item = Arrays.asList(numI , numJ , numK);
                        sort(item);
                        String str = item.toString();
                        if(!ans.containsKey(str))ans.put(str,item);

                    }

                }
            }
        }

        return new ArrayList<>(ans.values());
    }
    private static List<List<Integer>> optimized1(int[] nums){
        /**
         * time O(N2)
         */
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i < nums.length-2; i++) {
            int numI = nums[i];
            if(i > 0 && nums[i-1] == numI ) continue;
            int diff = 0 - numI;


            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                if(nums[left] == nums[left-1] && nums[left] != numI) {
                    left++;
                    continue;
                }



                if((right+1 < nums.length) && (nums[right] == nums[right+1])) {
                    right--;
                    continue;
                }

                if(nums[left] + nums[right] == diff){
                    ans.add(Arrays.asList(numI, nums[left] ,nums[right]));
                    left++;
                    right--;
                }else if(nums[left] + nums[right] > diff){
                    right--;
                }else {
                    left++;
                }
            }


        }
        return ans;
            
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,-2,1,2,-1,-4};

        List<List<Integer>> bruteForceSolution = bruteForce(nums);
        List<List<Integer>> optimized1Solution = optimized1(nums);


        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);



    }


}
    
    