package problems;

/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true


 */

import java.util.*;
public class Problem20 {
    public boolean isValid(String s) {

        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('}', '{');
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');

        Set<Character> open = new HashSet<>();
        open.add('(');open.add('{');open.add('[');

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(open.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()){
                    return false;
                }

                if(stack.pop() != bracketMap.get(s.charAt(i))){
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }

    public static void main(String[] args){
        Problem20 problem20 = new Problem20();
        System.out.println(problem20.isValid("({[]})"));
        System.out.println(problem20.isValid("({[]}"));
    }

}
