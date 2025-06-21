class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[100000];
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
class Solution {
    public int largestRectangleArea(int[] heights) {
        MyStack stack=new MyStack();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.empty() && heights[stack.top()] > currentHeight) {
                int height = heights[stack.pop()];
                int width = stack.empty() ? i : i - stack.top() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}