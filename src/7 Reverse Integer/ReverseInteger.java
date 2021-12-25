
public class ReverseInteger {
    // 7 Reverse Integer https://leetcode.com/problems/reverse-integer

    private static int bruteForce(int x) {
        int times = x < 0 ? -1 : 1;
        String str = x + "";
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {

            if (str.charAt(i) == '-') continue;
            sb.append(str.charAt(i));
        }

        long revInt = Long.parseLong(sb.toString());
        if (revInt > Integer.MAX_VALUE) return 0;
        return (int) (revInt * times);


    }

    private static int optimized1(int x) {

        boolean isNeg = x < 0 ? true : false;
        int res = 0;
        x = Math.abs(x);
        while (x > 0) {
            if (res > (Integer.MAX_VALUE / 10)) return 0;
            res = res * 10 + x % 10;
            x /= 10;
            if (res < 0) return 0; // if res go over int limit positive becomes negative
        }

        res = isNeg ? -1 * res : res;

        return res;
    }

    public static void main(String[] args) {

        int x = 12390;


        int bruteForceSolution = bruteForce(x);
        int optimized1Solution = optimized1(x);

        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);




    }


}
    
    