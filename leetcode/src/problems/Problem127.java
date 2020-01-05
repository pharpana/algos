package problems;

import java.util.*;

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
