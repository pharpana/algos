package problems;

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */


public class Problem387 {

    public int firstUniqChar(String s) {

        int[] charArr = new int[26];

        for(char c : s.toCharArray()){
            charArr[c-'a']++;
        }

        for(int i=0; i<s.length(); i++) {
            if(charArr[s.charAt(i)-'a'] == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem387 problem = new Problem387();
        System.out.println(problem.firstUniqChar("america"));
    }
}
