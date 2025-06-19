class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        StackNode newnode = new StackNode(a);
        newnode.next = top;
        top = newnode;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if(top==null) return -1;
        int res=top.data;
        top=top.next;
        return res;
    }
    // Function to return the top from the stack without removing it.
    int top() {
        // Add your code here
        if(top==null) return -1;
        return top.data;
    }
    // Function to check if the stack is empty.
    boolean isEmpty() {
        // Add your code here
        return top == null;
    }
    // Function to return the size of the stack.
    int size() {
        // Add your code here
        int count = 0;
        StackNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }  
        return count;
    }
    // Function to clear the stack.
    void clear() {
        // Add your code here
        top = null;
    }
}