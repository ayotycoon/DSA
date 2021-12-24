
public class LongestPalindromicSubstring{
    // 5 Longest Palindromic Substring https://leetcode.com/problems/longest-palindromic-substring

    private static boolean isPalindrome(String s,int i, int j){
        while(i <=j){

            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
    private static String bruteForce(String s){
        /*
            Time O(N^3)
            Space O(1)
         */
        int start = 0;
        int end = 1;

        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++){

                if(isPalindrome(s, i,j) && ((j-i) > (end-start))){
                    start = i;
                    end = j;
                }
            }
        }


            return s.substring(start,end+1);
    }

    public static int[] expand(String s, int start, int end){
        if(end >= s.length() || s.charAt(start) != s.charAt(end)) return new int[]{0,0,1};
        int a = start;
        int b = end;

        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            a = start;
            b = end;
            start--;
            end++;
        }
        return new int[]{a, b, b-a+1};


    }
    private static String optimized1(String s){
       /*
            Time O(N^2)
            Space O(1)
         */
        // expand from the center

        int[] max = new int[]{0,0,1};

        for(int i =0; i < s.length();i++){
            int[] possibility1 = expand(s, i, i+1);
            int[] possibility2 = expand(s, i, i);

            if(possibility1[2] > max[2]){
                max = possibility1;
            }
            if(possibility2[2] > max[2]){
                max = possibility2;
            }
        }


        return s.substring(max[0],max[1]+1);
            
    }

    public static void main(String[] args){
        String s = "racecar";
        String bruteForceSolution = bruteForce(s);
        String optimized1Solution = optimized1(s);

        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);

    }


}
    
    