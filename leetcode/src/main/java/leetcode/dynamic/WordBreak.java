package leetcode.dynamic;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList(new String[]{"leet","code"});
        String s = "leetcode";

        boolean[] bool = new boolean[s.length()+1];

        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] bool = new boolean[s.length()+1];
        bool[s.length()] = true;

        for(int i = s.length()-1; i>=0; i--) {
            for(String w : wordDict) {
                if((i+w.length() <= s.length()) && s.substring(i, i+w.length()).equals(w)) {
                    bool[i] = bool[i+w.length()];
                }
                if(bool[i]) break;
            }
        }
        return bool[0];
    }
}
