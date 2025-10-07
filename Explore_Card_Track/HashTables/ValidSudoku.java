// Determine if a 9 x 9 Sudoku board is valid.Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.Each column must contain the digits 1-9 without repetition.Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

// Note:

// A Sudoku board(partially filled)could be valid but is not necessarily solvable.Only the filled cells need to be validated according to the mentioned rules.

// Example 1:

// Input:board=[
//     ["5","3",".",".","7",".",".",".","."],
//     ["6",".",".","1","9","5",".",".","."],
//     [".","9","8",".",".",".",".","6","."],
//     ["8",".",".",".","6",".",".",".","3"],
//     ["4",".",".","8",".","3",".",".","1"],
//     ["7",".",".",".","2",".",".",".","6"],
//     [".","6",".",".",".",".","2","8","."],
//     [".",".",".","4","1","9",".",".","5"],
//     [".",".",".",".","8",".",".","7","9"]]
    
// Output:true

// Example 2:

// Input:board=[
//     ["8","3",".",".","7",".",".",".","."],
//     ["6",".",".","1","9","5",".",".","."],
//     [".","9","8",".",".",".",".","6","."],
//     ["8",".",".",".","6",".",".",".","3"],
//     ["4",".",".","8",".","3",".",".","1"],
//     ["7",".",".",".","2",".",".",".","6"],
//     [".","6",".",".",".",".","2","8","."],
//     [".",".",".","4","1","9",".",".","5"],
//     [".",".",".",".","8",".",".","7","9"]]
    
// Output:false Explanation:Same as Example 1,except with the 5 in the top left corner being modified to 8. Since there are two 8'sin the top left 3 x3 sub-box,it is invalid.

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // 9 rows, 9 columns, 9 boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.')
                    continue; // ignore empty cells

                // Check row
                if (rows[r].contains(val))
                    return false;
                rows[r].add(val);

                // Check column
                if (cols[c].contains(val))
                    return false;
                cols[c].add(val);

                // Check 3x3 box
                int boxIndex = (r / 3) * 3 + (c / 3);
                if (boxes[boxIndex].contains(val))
                    return false;
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}

// The(r/3)*3+(c/3) trick uniquely identifies each of the 9 sub-boxes:
// [0 0 0|1 1 1|2 2 2]
// [0 0 0|1 1 1|2 2 2]
// [0 0 0|1 1 1|2 2 2]
// ------------------------
// [3 3 3|4 4 4|5 5 5]
// ...
