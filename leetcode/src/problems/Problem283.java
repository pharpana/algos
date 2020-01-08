package problems;

import java.util.Arrays;

public class Problem283 {
    public void moveZeroes(int[] nums) {

        int read = 0;
        int write = 0;

        for(; read<nums.length; read++){
            if(nums[read] == 0){
                continue;
            }
            nums[write] = nums[read];
            write++;
        }

        for(;write<nums.length; write++){
            nums[write] = 0;
        }

    }

    public static void main(String[] args) {
        Problem283 problem = new Problem283();
        int[] arr = new int[]{1,0,2,0,4,0,13,14};
        problem.moveZeroes(arr);
        Arrays.stream(arr).forEach(t -> System.out.print(t + ","));
    }
}
