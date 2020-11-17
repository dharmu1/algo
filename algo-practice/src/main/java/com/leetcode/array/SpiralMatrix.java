package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

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
Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l1 = new ArrayList<>();
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int startIndex=0;
        int colStartIndex=0;
        while (row>0&&col>0) {
            printMatrix(matrix, row, col, l1, startIndex++, colStartIndex++);
            row=row-1;
            col=col-1;
        }
        return l1;
    }

    private void printMatrix(int[][] matrix, int row, int col, List<Integer> resList,int rowIndex,int colIndex) {
        // copy first top horizontal row
        for (int i = colIndex; i <= col; i++) {
            resList.add(matrix[colIndex][i]);
        }
        //copy right side vertical row
        for (int i = 1; i <= row; i++) {
            resList.add(matrix[i][col - 1]);
        }
        //copy horizontal bottom row
        for (int i = col - 1; i >= colIndex; i--) {
            resList.add(matrix[row - 1][i]);
        }
        //copy left vertical row
        for (int i = row - 1; i >= 1; i--) {
            resList.add(matrix[i][0]);
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> res = new SpiralMatrix().spiralOrder(matrix);
        System.out.println(res);
    }
}
