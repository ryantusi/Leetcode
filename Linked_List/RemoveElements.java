/*
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:

Input: head = [], val = 1
Output: []

Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 */

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node pointing to head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use current pointer to traverse
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the target value
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next; // New head after removals
    }
}
