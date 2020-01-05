package problems;

/*

151. Reverse Words in a String

Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

 */

public class Problem151 {

    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--) {
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.substring(0, sb.length()-1);
    }

    public static void main(String[] args) {
        Problem151 problem = new Problem151();
        System.out.println(problem.reverseWords("The sun rises in the East"));
    }
}
