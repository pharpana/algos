package problems;

import java.util.*;

/*

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 */

public class Problem127 {

    static class Node {
        String key;
        int value;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> combinationsMap = new HashMap<>();
        int L = wordList.get(0).length();

        wordList.forEach(word -> {
            for(int i=0; i<L; i++){
                String newWord = word.substring(0,i) + "*" + word.substring(i+1, L);
                List<String> transformations = combinationsMap.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                combinationsMap.put(newWord, transformations);
            }
        });

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();

        while(!q.isEmpty()) {
            Node node = q.poll();

            String key = node.key;
            int value = node.value;

            if(key.equals(endWord)){
                return value;
            }

            for(int i=0; i<L; i++) {
                String word = key.substring(0,i) + "*" + key.substring(i+1, L);
                List<String> transformations = combinationsMap.getOrDefault(word, new ArrayList<>());

                for(String w : transformations){
                    if(!visited.containsKey(w)){
                        visited.put(w, true);
                        q.offer(new Node(w, value+1));
                    }
                }
            }
        }

        return 0;
    }
}
