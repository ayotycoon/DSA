import java.util.*;

public class Vanessa {
    // 6 ZigZag Conversion https://leetcode.com/problems/zigzag-conversion

    private static final Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {





        int n = 50;
        char[][] _board = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[]row = new char[n];
            for (int j = 0; j < n; j++) {
row[j] = '.';
            }
            _board[i] = row;
        }

        int fun = optimized1(_board, 0, 0);
        System.out.println(fun);




    }

    private static int optimized1(char[][] board, int i, int j) {


        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return Integer.MAX_VALUE;


        String key = i + " " + j;
        if (map.containsKey(key)) return map.get(key);
        char curr = board[i][j];

        if (curr == '#') return Integer.MAX_VALUE;
        if (i == board.length - 1 && j == board[0].length - 1) {
            return 0;
        }
        board[i][j] = '#';
        int up = optimized1(board, i - 1, j);
        int down = optimized1(board, i + 1, j);
        int right = optimized1(board, i, j + 1);
        int left = optimized1(board, i, j - 1);

        board[i][j] = curr;

        int ans = Integer.MAX_VALUE;

        if (up < ans) ans = up;
        if (down < ans) ans = down;
        if (right < ans) ans = right;
        if (left < ans) ans = left;

        // System.out.println(key+" up="+up+" down="+down+" right="+right+" left="+left);
        if(ans == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        ans += 1;
        map.put(key, ans);


        /*
        ***
        ***
        ***
         */


        return ans;

    }


}



    
    