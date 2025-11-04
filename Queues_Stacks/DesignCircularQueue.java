// Design your implementation of the circular queue.The circular queue is a linear data structure in which the operations are performed based on FIFO(First In First Out)principle,and the last position is connected back to the first position to make a circle.It is also called"Ring Buffer".

// One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.In a normal queue,once the queue becomes full,we cannot insert the next element even if there is a space in front of the queue.But using the circular queue,we can use the space to store new values.

// Implement the MyCircularQueue class:

// MyCircularQueue(k)Initializes the object with the size of the queue to be k.int Front()Gets the front item from the queue.If the queue is empty,return-1. int Rear()Gets the last item from the queue.If the queue is empty,return-1. boolean enQueue(int value)Inserts an element into the circular queue.Return true if the operation is successful.boolean deQueue()Deletes an element from the circular queue.Return true if the operation is successful.boolean isEmpty()Checks whether the circular queue is empty or not.boolean isFull()Checks whether the circular queue is full or not.

// You must solve the problem without using the built-in queue data structure in your programming language.

// Example 1:

// Input["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"][[3],[1],[2],[3],[4],[],[],[],[4],[]]Output[null,true,true,true,false,3,true,true,true,4]

// Explanation MyCircularQueue myCircularQueue=new MyCircularQueue(3);myCircularQueue.enQueue(1); // return True
// myCircularQueue.enQueue(2); // return True
// myCircularQueue.enQueue(3); // return True
// myCircularQueue.enQueue(4); // return False
// myCircularQueue.Rear(); // return 3
// myCircularQueue.isFull(); // return True
// myCircularQueue.deQueue(); // return True
// myCircularQueue.enQueue(4); // return True
// myCircularQueue.Rear(); // return 4

public class DesignCircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int count;
    private int size;

    public MyCircularQueue(int k) {
        queue = new int[k];
        size = k;
        head = 0;
        tail = -1; // important: tail starts before the first element
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        tail = (tail + 1) % size; // move circularly
        queue[tail] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        head = (head + 1) % size; // move circularly
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return queue[head];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return queue[tail];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
 