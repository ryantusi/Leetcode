// Perfect Squares

// Given an integer n, return the least number of perfect square numbers that sum to n.

// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

// Example 1:

// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.

// Example 2:

// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
    public int numSquares(int n) {
        // Generate all perfect squares <= n
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(n);
        visited.add(n);

        int level = 0; // represents number of perfect squares used

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process current BFS level
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                // Try subtracting every perfect square
                for (int square : squares) {
                    int next = current - square;

                    if (next == 0) return level + 1; // reached sum exactly
                    if (next < 0) break; // smaller than 0 → stop checking

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            level++;
        }

        return level;
    }
}
