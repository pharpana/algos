package problems;

/*
53. Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

 */
public class Problem53 {

    public int findMaxSum(int[] nums){

        int currSum=0;
        int maxSum = nums[0];

        for(int i=0; i<nums.length; i++){
            currSum = Math.max(currSum+nums[i], nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Problem53 problem53 = new Problem53();
        System.out.println(problem53.findMaxSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
