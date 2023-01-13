package leetcode.graphs;

import java.util.Arrays;

public class LongestCommonSubSeq {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","abc"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] arr = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<text1.length(); i++) {
            for(int j=0; j<text2.length(); j++) {
                arr[i][j] = 0;
            }
        }
        for(int i=text1.length()-1; i>=0; i--) {
            for(int j=text2.length()-1; j>=0; j--) {
                if(text1.charAt(i)==text2.charAt(j)){
                    arr[i][j] = 1+arr[i+1][j+1];
                }
                else {
                    arr[i][j] = Math.max(arr[i+1][j], arr[i][j+1]);
                }
            }
        }



        return arr[0][0];
    }
}
