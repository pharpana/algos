package problems;

import java.util.HashMap;
import java.util.Map;

public class Problem560 {

    public int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        map.put(0,1);

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            if(map.containsKey(sum -k)){
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        Problem560 problem = new Problem560();
        System.out.println(problem.subArraySum(arr, 2));
    }
}
