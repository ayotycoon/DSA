
public class PalindromeNumber{
    // 9 Palindrome Number https://leetcode.com/problems/palindrome-number

    private static boolean bruteForce(int y){
                /*
            Time O(N)
            Space O(N)

         */
        String str = y+"";
        int i =0;
        int j = str.length()-1;

        while(i <=j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }

return true;
            
    }
    private static boolean optimized1(int y){
        /*
            Time O(N)
            Space O(1)

         */
        if(y <0) return false;
        int x = y;
        int rev = 0;

        while(x > 0){

            rev = (rev*10) + (x - ((x/10)*10));
            x = (x/10);
        }


        return rev == y;

    }

    public static void main(String[] args){
        int x = 121;


        boolean bruteForceSolution = bruteForce(x);
        boolean optimized1Solution = optimized1(x);

        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);

    }


}
    
    