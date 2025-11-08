// Min Stack

// Design a stack that supports push,pop,top,and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack()initializes the stack object.void push(int val)pushes the element val onto the stack.void pop()removes the element on the top of the stack.int top()gets the top element of the stack.int getMin()retrieves the minimum element in the stack.

// You must implement a solution with O(1)time complexity for each function.

// Example 1:

// Input["MinStack","push","push","push","getMin","pop","top","getMin"][[],[-2],[0],[-3],[],[],[],[]]

// Output[null,null,null,null,-3,null,0,-2]

// Explanation MinStack minStack=new MinStack();minStack.push(-2);minStack.push(0);minStack.push(-3);minStack.getMin(); // return -3
// minStack.pop();minStack.top(); // return 0
// minStack.getMin(); // return -2

public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minStack;

    public MinStack() {
        data = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
            minStack.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
