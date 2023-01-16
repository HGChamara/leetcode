package leetcode.dynamic;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }

    public static int minDistance(String word1, String word2) {

        int[][] cache = new int[word1.length()+1][word2.length()+1]; //[rows][columns]
        for(int i=0; i<=word1.length(); i++) {
            cache[i][word2.length()] = word1.length()-i;
        }
        for(int i=0; i<=word2.length(); i++) {
            cache[word1.length()][i] = word2.length()-i;
        }

        for (int i=0;i <= word1.length();  i++) {
            for (int j = 0; j <= word2.length(); j++) {
                System.out.print(cache[i][j]);
            }
            System.out.println("");
        }


        for (int i= word1.length()-1; i>=0; i--) {
            for(int j=word2.length()-1; j>=0; j--) {
                if(word1.charAt(i) == word2.charAt(j)) cache[i][j] = cache[i+1][j+1];
                else cache[i][j] = 1 + Math.min(Math.min(cache[i][j+1], cache[i+1][j]), cache[i+1][j+1]);
            }
        }
        return cache[0][0];
    }
}
