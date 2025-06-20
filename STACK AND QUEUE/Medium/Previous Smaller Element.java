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
    
    public int peek() {
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

public class Solution {
    public int[] prevSmaller(int[] A) {
        int n=A.length;
        int[] pse=new int[n];
        MyStack stack=new MyStack();
        
        for (int i = 0; i<n; i++) {
            int ele =A[i];
            while (!stack.empty() && stack.peek() >= A[i]) {
                stack.pop();
            }
            pse[i] = stack.empty() ? -1 : stack.peek();
            stack.push(A[i]);
        }
        return pse;
    }
}
