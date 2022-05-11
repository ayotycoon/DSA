
public class ContainerWithMostWater{
    // 11 Container With Most Water https://leetcode.com/problems/container-with-most-water

    private static int bruteForce(int[] height){
        int max = 0;

        for(int start = 0;start< height.length; start++){

            for(int end = start+1;end< height.length; end++){
                int minHeight = Math.min(height[start],height[end]);
                int diff = end-start;
                max = Math.max(max,minHeight * diff);



            }

        }

        return max;
            
    }
    private static int optimized1(int[] height){

        int max = 0; // If the max area is 0, then there is no area in the array to be considered
        int i = 0;
        int j = height.length - 1; // Start from the end of the array to avoid checking the same pair of elements twice
        while (i < j) { // While the two pointers are not equal to each other we can continue to check the area of the rectangle
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i)); // Calculate the area of the rectangle
            if (height[i] < height[j]) { // If the first element is smaller than the second element, then we move the first pointer to the next element in the array
                i++;
            } else { // Otherwise, we move the second pointer to the previous element in the array
                j--;
            }
        }
        return max; // Return the max area
    }

    public static void main(String[] args){

        int[] height = {1,8,6,2,5,4,8,3,7};


        int bruteForceSolution = bruteForce(height);
        int optimized1Solution = optimized1(height);

        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);

    }


}
    
    