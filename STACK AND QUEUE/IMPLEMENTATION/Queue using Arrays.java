class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = -1;
        rear = -1;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        rear++;
        arr[rear]=x;
        if(front==-1) front =0;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(front>rear || front ==-1 || rear ==-1){
            return -1;
        }
        int res=arr[front];
        front++;
        return res;
        // Your code here
    }
    // Function to return the front element of the queue.
    int peek() {
        if(front>rear || front ==-1 || rear ==-1){
            return -1;
        }
        return arr[front];
    }
    // Function to return the size of the queue.
    int size() {
        if(front==-1 || rear==-1) return 0;
        return rear - front + 1;
    }
    // Function to check if the queue is empty or not.
    boolean isEmpty() {
        return front > rear || front == -1 || rear == -1;
    }
}