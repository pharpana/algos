package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class Problem1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indexMap.containsKey(diff)) {
                return new int[]{indexMap.get(diff), i};
            }

            indexMap.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Problem1 problem = new Problem1();
        Arrays.stream(problem.twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(t -> System.out.print(t + ","));
    }
}
