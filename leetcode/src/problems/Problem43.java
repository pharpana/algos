package problems;

/*
43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */

public class Problem43 {

    public String multiply(String num1, String num2) {

        int nl1 = num1.length();
        int nl2 = num2.length();

        int[] resArr = new int[nl1+nl2];

        for(int i=nl1-1; i>=0; i--) {
            for(int j=nl2-1; j>=0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) -'0');

                int valPos = i+j+1;
                int carryPos = i+j;
                int valueSum = resArr[valPos] + product;

                resArr[valPos] = valueSum%10;
                resArr[carryPos] = resArr[carryPos] + valueSum/10;
            }
        }

        int x = 0;
        for(;x<nl1+nl2;x++){
            if(resArr[x] !=0)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for(;x<nl1+nl2; x++) {
            sb.append(resArr[x]);
        }

        return "".equals(sb.toString()) ? "0" : sb.toString();

    }

    public static void main(String[] args) {
        Problem43 problem43 = new Problem43();
        System.out.println(problem43.multiply("999", "234"));
    }
}
