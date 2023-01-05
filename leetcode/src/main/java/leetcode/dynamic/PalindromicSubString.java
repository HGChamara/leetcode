package leetcode.dynamic;

public class PalindromicSubString {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int finalResult = 0;

        for(int i=0; i< s.length(); i++) {
            finalResult += countPalindromes(s, i,i); // count odd palindrome combinations
            finalResult += countPalindromes(s, i,i+1); // count even palindrome combinations
        }
       return finalResult;
    }

    private static int countPalindromes(String s, int l, int r) {
        int result = 0;

        while(l>=0 && r<s.length() && (s.charAt(l)==s.charAt(r))) {
            l--;
            r++;
            result++;
        }

        return result;
    }

}
