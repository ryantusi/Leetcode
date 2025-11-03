// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

// Example 2:

// Input: numRows = 1
// Output: [[1]]

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // first element always 1

            for (int j = 1; j < i; j++) {
                // middle elements = sum of two above
                int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                row.add(val);
            }

            if (i > 0)
                row.add(1); // last element (only if row has more than 1 element)
            result.add(row);
        }

        return result;
    }
}
