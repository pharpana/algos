package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem974 {

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int runningSum = 0;
        map.put(0,1);

        for(int i=0; i< A.length; i++){
            runningSum += A[i];
            int reminder = runningSum%K;

            if(reminder <0) reminder += K;
            if(map.containsKey(reminder)){
                count += map.get(reminder);
            }

            map.put(reminder, map.getOrDefault(reminder,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        Problem974 problem = new Problem974();
        int[] arr = {5,5,4};
        System.out.println(problem.subarraysDivByK(arr,5));
    }
}
