public class StringToIntegerAtoi {
    // 8 String to Integer (atoi) https://leetcode.com/problems/string-to-integer-atoi
    private static int startFrom(char c) {
        if (c == '+' || c == '-') return 1;
        return 0;
    }

    private static int bruteForce(String s) {
              /*
            Time O(N)
            Space O(1)

         */
        if (null == s) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        boolean isNegetive = s.charAt(0) == '-';
        int startFrom = startFrom(s.charAt(0));
        int length = s.length();

        double result = 0;
        while (startFrom < length) {
            char c = s.charAt(startFrom);
            startFrom++;
            if (c == ' ') break;
            if ((c - '0') > 9 || c == '.' || c == '+' || c == '-') break;
            result = result * 10 + c - '0';
        }

        if (isNegetive) result = -result;

        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (Integer.MAX_VALUE < result) return Integer.MAX_VALUE;

        return (int) result;

    }


    private static int optimized1(String s) {
              /*
            Time O(N)
            Space O(1)

         */
        if (s == null || s.length() == 0) return 0;

        int curr = 0;


        boolean limit = false;
        boolean seenNum = false;
        boolean signSeen = false;
        boolean negSeen = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenNum = true;

                int add = (curr * 10) + Character.getNumericValue(c);
                if(add < 0 || (curr * 10/10) != curr) {
                    limit = true;
                    break;
                }
                curr = add;
            } else {
                if (c == ' ' ) {
                    if(seenNum)break;
                    if(signSeen)break;
                }else if (!seenNum && !signSeen && (c == '+' || c == '-')) {
                    if (c == '+') {
                        signSeen = true;
                    }
                    if (c == '-') {
                        signSeen = true;
                        negSeen = true;
                    }
                }else {
                    break;
                }


            }

        }
        if(limit && negSeen) return Integer.MIN_VALUE;
        if(limit && !negSeen) return Integer.MAX_VALUE;
        return (negSeen ? -1 : 1) * curr;
    }


    public static void main(String[] args) {


        for (String s : new String[]{
//                "  +   47",
//                "-4444444444444444",
//                "y500 - 6",
                "-91283472332"

        }) {
            int optimized1Solution = optimized1(s);


            System.out.println(s +" => "+optimized1Solution);

        }


    }


}
    
    