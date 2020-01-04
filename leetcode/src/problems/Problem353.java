package problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Problem353 {

    LinkedList<Integer> list = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    int[][] food;
    int width;
    int height;
    int score;
    int x, y;

    public Problem353(int width, int height, int[][] food) {
        list.add(0);
        set.add(0);
        this.width = width;
        this.height = height;
        this.food = food;
        this.score = 0;
        x=0;
        y=0;
    }

    public int move(String direction) {

        switch(direction) {
            case "U" : x--;
            break;
            case "R" : y++;
            break;
            case "D" : x++;
            break;
            case "L" : y--;
            break;
        }

        if(x<0 || x>=height || y<0 || y>=width){
            return -1;
        }

        if(score<food.length && x==food[score][0] && y==food[score][1]) {
            score++;
        } else {
            int tail = list.remove(list.size()-1);
            set.remove(tail);
        }

        list.addFirst(x*width+y);
        if(!set.add(x*width+y)) return -1;

        return score;
    }
}
