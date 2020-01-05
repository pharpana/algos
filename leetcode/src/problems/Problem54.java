package problems;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.List;

public class Problem54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length==0) return new ArrayList<>();

        int fRow = 0, fCol = 0, lRow = matrix.length-1, lCol = matrix[0].length-1;

        List<Integer> result = new ArrayList<>();

        while(fRow<=lRow && fCol<=lCol) {
            for(int i=fCol; i<=lCol; i++) {
                result.add(matrix[fRow][i]);
            }
            fRow++;

            for(int i=fRow; i<=lRow; i++) {
                result.add(matrix[i][lCol]);
            }
            lCol--;

            if(fRow<=lRow) {
                for(int i=lCol; i>=fCol; i--) {
                    result.add(matrix[lRow][i]);
                }
                lRow--;
            }

            if(fCol<=lCol) {
                for(int i=lRow; i>=fRow; i--) {
                    result.add(matrix[i][fCol]);
                }
                fCol++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix  = {{1,2,3},{4,5,6},{7,8,9}};
        Problem54 problem = new Problem54();
        problem.spiralOrder(matrix).forEach(System.out::print);
    }
}
