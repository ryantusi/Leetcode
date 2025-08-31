// Given an m x n matrix, return all elements of the matrix in spiral order.

 

// Example 1:

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:

// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
     public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: empty matrix
        if (matrix.length == 0) return result;
        
        int m = matrix.length;        // number of rows
        int n = matrix[0].length;     // number of columns
        
        int dir = 1;   // direction tracker: 1 = right, 2 = down, 3 = left, 4 = up
        int level = 1; // spiral "layer" we are in (outermost = 1, next inner = 2, etc.)
        
        int row = 0, col = 0; // start position at top-left corner
        
        // We must visit every cell exactly once, so loop m*n times
        for (int i = 0; i < m * n; i++) {
            
            // Add the current cell value to result
            result.add(matrix[row][col]);
            
            // Based on direction, decide next step
            if (dir == 1) { // moving right
                if (col == n - level) { // reached right boundary of current level
                    row++;   // move down
                    dir = 2; // change direction to down
                } else {
                    col++;   // keep moving right
                }
                
            } else if (dir == 2) { // moving down
                if (row == m - level) { // reached bottom boundary of current level
                    col--;   // move left
                    dir = 3; // change direction to left
                } else {
                    row++;   // keep moving down
                }
                
            } else if (dir == 3) { // moving left
                if (col == level - 1) { // reached left boundary of current level
                    row--;   // move up
                    dir = 4; // change direction to up
                    level++; // completed one spiral loop, go to inner level
                } else {
                    col--;   // keep moving left
                }
                
            } else if (dir == 4) { // moving up
                if (row == level - 1) { // reached top boundary of current level
                    col++;   // move right
                    dir = 1; // change direction to right
                } else {
                    row--;   // keep moving up
                }
            }
        }
        
        return result;
    }
}
