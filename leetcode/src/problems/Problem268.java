package problems;

/*

268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 */

public class Problem268 {

    public int missingNumber(int[] nums) {

        int sum = 0;

        for(int i : nums) {
            sum+=i;
        }

        return (nums.length*(nums.length+1))/2 - sum;
    }

    public static void main(String[] args){
        Problem268 problem = new Problem268();
        System.out.println(problem.missingNumber(new int[] {3,0,1}));
    }
}
