
public class MedianOfTwoSortedArrays{
    // 4 Median of Two Sorted Arrays https://leetcode.com/problems/median-of-two-sorted-arrays

    private static int getIndex(int [] num, int i){
        // max value because we want to ignore it
        if(i >= num.length || i < 0 ) return Integer.MAX_VALUE;
        return num[i];
    }
     private static double optimized(int[] nums1, int[] nums2) {
       /*
            Time O(log N)
            Space O(1)
         */
        int a = 0;
        int b = 0;
        int tot = nums1.length + nums2.length;
        int mid = tot/2;

        int i = 0;
        int j = 0;
        int track = -1;

        while(i < nums1.length || j < nums2.length){
            int  intI = getIndex(nums1,i);
            int  intJ = getIndex(nums2,j);


            track++;
            if(intI < intJ){
                if(track == mid-1){
                    a = getIndex(nums1,i);
                }else if(track == mid){
                    b = getIndex(nums1,i);
                }
                i++;

            }else {

                if( track == mid-1){
                    a = getIndex(nums2,j);
                }else if(track == mid){
                    b = getIndex(nums2,j);
                }
                j++;
            }


            if(tot %2 == 0 && track == mid) return ((double)(a+b)/2); // if even
            if(tot %2 != 0 && track == mid) return b; // if odd




        }

        return 0;

    }


    public static void main(String[] args){

        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{2,3};


         var ans = optimized(arr1,arr2);
         System.out.println(ans);

    }


}
    
    