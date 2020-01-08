package problems;

import java.util.*;
public class Problem299 {

    public String getHint(String secret, String guess) {
        if(secret == null || secret.isEmpty() || guess== null || guess.isEmpty()){
            return "0A0B";
        }

        Map<Character, Integer> secretMap = new HashMap<>();
        for(char c : secret.toCharArray()){
            secretMap.put(c, secretMap.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> guessMap = new HashMap<>();
        for(char c : guess.toCharArray()){
            guessMap.put(c, guessMap.getOrDefault(c,0)+1);
        }

        int cow=0, bull=0;
        for(Map.Entry<Character, Integer> entry : guessMap.entrySet()){
            cow += Math.min(entry.getValue(), secretMap.getOrDefault(entry.getKey(), 0));
        }

        for(int i=0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                cow--;
                bull++;
            }
        }

        return bull+"A"+cow+"B";
    }

    public static void main(String[] args){
        Problem299 problem299 = new Problem299();
        System.out.println(problem299.getHint("1807", "7810"));
    }
}
