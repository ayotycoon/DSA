package sorting;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {



    private static <T> List<T> merge(@NotNull List<T> a, List<T> b) {

        int iA = 0;
        int iB = 0;
        List<T>  initial = new ArrayList<T>(a.size()+b.size());

        while (iA < a.size() && iB < b.size()) {

            boolean less = a.get(iA) instanceof Integer ? (Integer)a.get(iA) < (Integer) b.get(iB) :  (Double)a.get(iA) < (Double) b.get(iB);
            if (less) {
                initial.add(a.get(iA));
                iA++;
            } else {
                initial.add(b.get(iB));
                iB++;
            }

        }

        while (iA < a.size()) {
            initial.add(a.get(iA));
            iA++;

        }
        while (iB < b.size()) {
            initial.add(b.get(iB));
            iB++;

        }



        return initial;
    }

    public static <T> List<T> mergeSort(List<T> nums) {
        if (nums.size() == 1) return nums;

        int m = nums.size() / 2;
        List<T> arr1 = nums.subList(0, m);
        List<T> arr2 =  nums.subList(m, nums.size());

        if (arr1.size() != 1) {
            arr1 = mergeSort(arr1);
        }
        if (arr2.size() != 1) {
            arr2 = mergeSort(arr2);
        }
        return  merge( arr1, arr2);



    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(9, 4, 3, 1, 6, 3, 8, 3);


        List<Integer> sorted = mergeSort(nums);
        System.out.println(sorted);



    }
}