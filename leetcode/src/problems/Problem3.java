package problems;

/*
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Problem3 {

    public int lengthOfLongestSubstring(String s) {

        int start=0, end=0;
        int ans = 0;
        int[] index = new int[256];

        for(;end<s.length(); end++){
            start = Math.max(index[s.charAt(end)], start);
            ans = Math.max(ans, end-start+1);
            index[s.charAt(end)] = end+1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem3 problem = new Problem3();
        System.out.println(problem.lengthOfLongestSubstring("abcabcbb"));
    }
}