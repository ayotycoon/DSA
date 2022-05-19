import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ValidSudoku{
    // 36 Valid Sudoku https://leetcode.com/problems/valid-sudoku

    private static int getGrid(int row, int column){
        if(row >= 0 && row <=2 && column >=0 && column <=2) return 0;
        if(row >= 0 && row <=2 && column >=3 && column <=5) return 1;
        if(row >= 0 && row <=2 && column >=6 && column <=8) return 2;
        if(row >= 3 && row <=5 && column >=0 && column <=2) return 3;
        if(row >= 3 && row <=5 && column >=3 && column <=5) return 4;
        if(row >= 3 && row <=5 && column >=6 && column <=8) return 5;
        if(row >= 6 && row <=8 && column >=0 && column <=2) return 6;
        if(row >= 6 && row <=8 && column >=3 && column <=5) return 7;
        if(row >= 6 && row <=8 && column >=6 && column <=8) return 8;

        return -1;

    }

    private static boolean bruteForce(char[][] board){
/*        
Time O(NM)
 Space O(N^2M)
*/
         List<Set<Character>> rowSet = new ArrayList(9);
         List<Set<Character>> gridSet = new ArrayList(9);
        for(int i=0; i <9 ; i++){
            rowSet.add(new HashSet<>());
            gridSet.add(new HashSet<>());
        }

        for(int row = 0; row < board.length; row++){
            Set<Character> columnSet = new HashSet<>();
            for(int column = 0; column < board[row].length; column++){
                Character curr = board[row][column];
                if(curr == '.') continue;

                if(columnSet.contains(curr)) return false;
                columnSet.add(curr);

                if(rowSet.get(column).contains(curr)) return false;
                rowSet.get(column).add(curr);

                int grid = getGrid(row,column);

                if(gridSet.get(grid).contains(curr)) return false;
                gridSet.get(grid).add(curr);




            }}

           return true;
    }
    private static boolean optimized1(char[][] board){
/*        
Time O(1)
 Space O(1)
*/
return false;
            
    }

    public static void main(String[] args) {


        new TestCaseExecutor(
                computeTestCase(new char[][]{new char[]{'5','3','.','.','7','.','.','.','.'}
                        ,new char[]{'6','.','.','1','9','5','.','.','.'}
                        ,new char[]{'.','9','8','.','.','.','.','6','.'}
                        ,new char[]{'8','.','.','.','6','.','.','.','3'}
                        ,new char[]{'4','.','.','8','.','3','.','.','1'}
                        ,new char[]{'7','.','.','.','2','.','.','.','6'}
                        ,new char[]{'.','6','.','.','.','.','2','8','.'}
                        ,new char[]{'.','.','.','4','1','9','.','.','5'}
                        ,new char[]{'.','.','.','.','8','.','.','7','9'}}),
                computeTestCase(
                        new char[][]{new char[]{'8','3','.','.','7','.','.','.','.'}
                        ,new char[]{'6','.','.','1','9','5','.','.','.'}
                        ,new char[]{'.','9','8','.','.','.','.','6','.'}
                        ,new char[]{'8','.','.','.','6','.','.','.','3'}
                        ,new char[]{'4','.','.','8','.','3','.','.','1'}
                        ,new char[]{'7','.','.','.','2','.','.','.','6'}
                        ,new char[]{'.','6','.','.','.','.','2','8','.'}
                        ,new char[]{'.','.','.','4','1','9','.','.','5'}
                        ,new char[]{'.','.','.','.','8','.','.','7','9'}}
                )


        );

    }


    @NotNull
    private static TestCase computeTestCase(char[][] board) {
        return new TestCase(
                "%s".formatted(
                        Arrays.toString(board)
                ),
                new TestCaseFunctionGroup("bruteForce", () -> {

                    return bruteForce(board)+"";

                }),

                new TestCaseFunctionGroup("optimized1", () -> {
                    return optimized1(board)+"";
                })


        );
    }



}
    
    