import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion{
    // 6 ZigZag Conversion https://leetcode.com/problems/zigzag-conversion

    private static String bruteForce(String s, int numRows){
        /*
            Time O(N +M)
            Space O(N+M)

         */

            if(numRows == 0) return "";
            List<List<Character>> track = new ArrayList<>(numRows);
            for(int i =0; i < numRows;i++){
                track.add(new ArrayList<>());
            }



            int sign = +1;
            int trackIndex = 0;
            for(int i=0; i < s.length(); i++){

                track.get(trackIndex).add(s.charAt(i));

                if(trackIndex + sign >= numRows){

                    sign = -1;
                }else if(trackIndex + sign < 0){
                    sign = +1;
                }



                trackIndex = trackIndex+sign;

                if(trackIndex>= numRows || trackIndex < 0){
                    trackIndex = 0;
                }

            }






            StringBuilder sb = new StringBuilder("");

            for(var t: track){
                for(var c: t){

                    sb.append(c);
                }
            }


            return sb.toString();



    }

    private static String optimized1(String s, int numRows){
        if(numRows == 0) return "";

        return "";
            
    }

    public static void main(String[] args){

        String s = "PAYPALISHIRING";
        int numRows = 3;


        String bruteForceSolution= bruteForce(s,numRows);
        String optimized1Solution= optimized1(s,numRows);

        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);

    }


}
    
    