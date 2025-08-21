// Given the head of a linked list, rotate the list to the right by k places.

 

// Example 1:

// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:

// Input: head = [0,1,2], k = 4
// Output: [2,0,1]


public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
         if (head == null || head.next == null || k == 0) return head;
        
        // Step 1: Find length
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        
        // Step 2: Normalize k
        k = k % n;
        if (k == 0) return head;
        
        // Step 3: Make circular
        tail.next = head;
        
        // Step 4: Find new tail (n - k - 1 steps from head)
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }
        
        // Step 5: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}
