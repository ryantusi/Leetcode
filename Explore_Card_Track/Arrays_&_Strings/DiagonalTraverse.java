// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

 

// Example 1:

// Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,4,7,5,3,6,8,9]

// Example 2:

// Input: mat = [[1,2],[3,4]]
// Output: [1,2,3,4]

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];

        int row = 0, col = 0, dir = 1; // 1 = up-right, -1 = down-left
        for (int i = 0; i < m * n; i++) {
            res[i] = mat[row][col];

            if (dir == 1) { // moving up-right
                if (col == n - 1) { // hit right edge -> go down
                    row++;
                    dir = -1;
                } else if (row == 0) { // hit top edge -> go right
                    col++;
                    dir = -1;
                } else { // free to go up-right
                    row--;
                    col++;
                }
            } else { // dir == -1, moving down-left
                if (row == m - 1) { // hit bottom edge -> go right
                    col++;
                    dir = 1;
                } else if (col == 0) { // hit left edge -> go down
                    row++;
                    dir = 1;
                } else { // free to go down-left
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}
