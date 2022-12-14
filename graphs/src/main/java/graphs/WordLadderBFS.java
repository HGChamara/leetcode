package graphs;

import java.util.*;

public class WordLadderBFS {

    public static void main(String[] args) {

        List<String> wordList = new ArrayList<>();
        wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        ladderLength("hit", "cog", wordList);

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, ArrayList<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        set.add(beginWord);

        for(String word : wordList ) {
            for(int i=0; i<word.length(); i++) {
                String pattern = word.substring(0, i)+"*"+word.substring(i+1);
                if(map.get(pattern) == null) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(word);
                    map.put(pattern, list);
                }
                else {
                    map.get(pattern).add(word);
                }
            }
        }
        return bfs(beginWord,endWord,map,set);
    }

    public static int bfs(String beginWord, String endWord, Map<String, ArrayList<String>> map,Set<String> set ) {
        int i=1;
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);

        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for(int j=0; j<qSize; j++) {
                String word = queue.poll();
                if(word.equals(endWord)) return i;
                for(int K=0; K<word.length(); K++) {
                    String pattern = word.substring(0, K) + "*" + word.substring(K + 1);
                    if(map.get(pattern) != null) {
                        for(String w : map.get(pattern)) {
                            if(!set.contains(w)) {
                                queue.add(w);
                                set.add(w);
                            }
                        }
                    }
                }
            }
            i++;
        }

        return 0;
    }
}
