package searching;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {



    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l =0;
        int r = nums.length-1;
        while (l <= r){

            int mid =  (r+l) /2;

            if(nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                l = mid+1;

            }else {

                r = mid-1;
            }

        }


        return -1;
    }
    public static int search(List<Integer> nums, int target) {
        int[] arr = new int[nums.size()];
        for(int i =0; i < nums.size(); i++) {
            Integer n = nums.get(i);
            arr[i] = n;
        }
        return search(arr, target);


    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        int index = search(nums, 11);
        System.out.println(index);



    }
}
