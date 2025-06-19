class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        // Your Code
        top++;
        arr[top]=x;
    }

    public int pop() {
        // Your Code
        if(top==-1) return top;
        int res= arr[top];
        top--;
        return res;
    }
    
    public int top() {
        // Your Code
        if(top==-1) return top;
        return arr[top];
    }

    public boolean empty() {
        // Your Code
        return top==-1;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        top = -1;
    }
}