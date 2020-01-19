package problems;

/*

647. Palindromic Substrings
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Note:

The input string length won't exceed 1000.

 */

public class Problem647 {

    public int countSubstrings(String s) {

        int res = 0;

        if(s == null || s.isEmpty()) return res;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i=0; i<s.length(); i++){
            for(int j=i; j>=0; j--) {
                if(s.charAt(i) == s.charAt(j) && (i-j<=2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        Problem647 problem = new Problem647();
        System.out.println(problem.countSubstrings("aaa"));
        System.out.println(problem.countSubstrings("abcaa"));
    }
}
