// Given the root of a binary tree, return all duplicate subtrees.

// For each kind of duplicate subtrees, you only need to return the root node of any one of them.

// Two trees are duplicate if they have the same structure with the same node values.

 

/* Example 1:
       1
      / \
     2   3
    /   / \
   4   2   4
      /
     4
*/
// Input: root = [1,2,3,4,null,2,4,null,null,4]
// Output: [[2,4],[4]]

// Example 2:

// Input: root = [2,1,1]
// Output: [[1]]

// Example 3:

// Input: root = [2,2,2,3,null,3,null]
// Output: [[2,3],[3]]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null)
            return "#";

        // Serialize current subtree: node value + left + right
        String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);

        // Count occurrences in map
        map.put(serial, map.getOrDefault(serial, 0) + 1);

        // Add to result only when count becomes exactly 2
        if (map.get(serial) == 2) {
            result.add(node);
        }

        return serial;
    }
}
