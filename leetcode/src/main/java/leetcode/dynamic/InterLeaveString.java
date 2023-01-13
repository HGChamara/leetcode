package leetcode.dynamic;

public class InterLeaveString {

    public static void main(String[] args) {

    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        for(int i= dp.length-1; i>=0; i--) {
            for(int j= dp[0].length-1; j>=0; i--) {

                if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j) && dp[i+1][j]) dp[i][j] = true;;
                if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j) && dp[i][j+1]) dp[i][j] = true;;
            }
        }
        return dp[0][0];
    }

}
