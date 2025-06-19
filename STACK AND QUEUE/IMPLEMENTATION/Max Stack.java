class Solution {
    Stack<Long> stack;
    long max;

    public Solution() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            max = x;
        } else {
            long diff = (long)x - max;
            stack.push(diff);
            if (diff > 0) max = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long diff = stack.pop();
        if (diff > 0) {
            max = max - diff;
        }
    }

    public int peek() {
        if (stack.isEmpty()) return -1;
        long diff = stack.peek();
        if (diff > 0) return (int) max;
        else return (int) (max + diff);
    }

    public int getMax() {
        return stack.isEmpty() ? -1 : (int) max;
    }
}
