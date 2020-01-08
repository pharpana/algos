package problems;
import java.util.*;
public class Problem13 {

    public int romanToInt(String s) {

        if(s == null || "".equals(s)) return 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);map.put('V', 5);map.put('X', 10);map.put('L', 50);
        map.put('C', 100);map.put('D', 500);map.put('M', 1000);

        int num = map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2; i>=0; i--){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1)) )
                num = num - map.get(s.charAt(i));
            else
                num = num + map.get(s.charAt(i));
        }

        return num;
    }

public static void main(String[] args){
        System.out.println(new Problem13().romanToInt("MMXX"));
}
}
