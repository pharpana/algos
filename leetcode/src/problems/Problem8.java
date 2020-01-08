package problems;

public class Problem8 {
    public int myAtoi(String str) {

        if(str == null || str.isEmpty()) return 0;

        long num = 0;
        int i = 0;
        while(i< str.length() && str.charAt(i) == ' '){
            i++;
        }

        boolean isNegative = false;
        if(i<str.length() && str.charAt(i) == '-'){
            isNegative = true;
            i++;
        } else if(i<str.length() && str.charAt(i) == '+') {
            isNegative = false;
            i++;
        }

        while(i<str.length() && (str.charAt(i) < '0' || str.charAt(i)>'9')){
            return 0;
        }

        int numStart = i;
        while(i<str.length() && str.charAt(i) >='0' && str.charAt(i)<='9'){
            i++;
        }

        if(numStart == i){
            return 0;
        }

        // form a long number, check for bounds
        // convert to int at end
        for(int k=numStart; k<i; k++){
            int digit = str.charAt(k) - '0';
            num *= 10;
            num = isNegative ? num-digit : num+digit;

            if(num < Integer.MIN_VALUE){
                num = Integer.MIN_VALUE;
                return (int) num;
            }

            if(num > Integer.MAX_VALUE) {
                num = Integer.MAX_VALUE;
                return (int) num;
            }
        }

        return (int) num;
    }

    public static void main(String[] args){
        System.out.println(new Problem8().myAtoi("4193 with words"));
    }
}
