public class StringToIntegerAtoi {
    // 8 String to Integer (atoi) https://leetcode.com/problems/string-to-integer-atoi
    private static int startFrom(char c) {
        if(c == '+' || c == '-') return 1;
        return 0;
    }
    private static int bruteForce(String s) {
        if(null == s) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        boolean isNegetive = s.charAt(0) == '-';
        int startFrom = startFrom(s.charAt(0));
        int length = s.length();

        double result = 0;
        while(startFrom < length) {
            char c = s.charAt(startFrom);
            startFrom++;
            if(c == ' ') break;
            if((c - '0') > 9 || c == '.' || c == '+' || c == '-') break;
            result = result*10 + c - '0';
        }

        if(isNegetive) result = -result;

        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if(Integer.MAX_VALUE < result) return Integer.MAX_VALUE;

        return (int)result;

    }


    private static int optimized1(String s) {
     return 0;
    }



    public static void main(String[] args) {


        for (String s : new String[]{"2147483646"}) {
            int optimized1Solution = optimized1(s);


            System.out.println(optimized1Solution);

        }


    }


}
    
    